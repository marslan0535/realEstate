package dataAccessLayer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.House;
import domain.Office;

public class DataAccessLayer {
	
	private Office office;

	public DataAccessLayer(String fileName, Office office) throws FileNotFoundException {
		this.office = office; 
		readFile(fileName);
	}

	public DataAccessLayer(JTable table, String fileName) throws IOException{
		
		String name = new String(fileName+".txt"); 
		
		BufferedWriter writeFile = new BufferedWriter(new FileWriter(name));
		StringBuilder text = new StringBuilder();
		text.append("id,price($),size(m^2),rooms,bathrooms,airconditioner\n");
		for (int i =0; i< table.getModel().getRowCount() ; i++) {
			for (int j = 0; j < 6; j++) {
				text.append(table.getModel().getValueAt(i, j)+", ");
			}
			text.append("\n");
		}
		
		writeFile.write(text.toString());
		writeFile.close();
	}
	

	
	
	private void readFile(String fileName) throws FileNotFoundException {
		File houses = new File(fileName);
		Scanner file = new Scanner(houses);
		boolean isHeaderPart = true;
		while(file.hasNext())
		{
			if (!isHeaderPart){

				String housesLine = file.nextLine();
				StringTokenizer stringTokenizer = new StringTokenizer(housesLine, ",");
				
				int id = Integer.parseInt(stringTokenizer.nextElement().toString().trim());
				int price= Integer.parseInt(stringTokenizer.nextElement().toString().trim());
				int size= Integer.parseInt(stringTokenizer.nextElement().toString().trim());
				int room = Integer.parseInt(stringTokenizer.nextElement().toString().trim());
				int bathroom = Integer.parseInt(stringTokenizer.nextElement().toString().trim());
				String airCond=stringTokenizer.nextElement().toString().trim();
				boolean airConditioner=getBooleanFromString(airCond);

				House house = new House(price, room, size, bathroom, airConditioner );
				office.addHouse(house);
			}else{
				file.nextLine();
				isHeaderPart = false;
			}
			
		}
		file.close();
		
	}
	
	private boolean getBooleanFromString(String string){
		if (string.equals("yes")) 
			return true;
		else if (string.equals("no"))
			return false;
		else
			return false;
	}

}

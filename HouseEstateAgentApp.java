package presentation;

import java.io.FileNotFoundException;

import dataAccessLayer.DataAccessLayer;
import domain.Office;

public class HouseEstateAgentApp {

	public static void main(String[] args) {
		Office office = new Office();
		try {
			DataAccessLayer dataAccessLayer = new DataAccessLayer("housing.txt", office);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EstateAgentGuiDesign gui = new EstateAgentGuiDesign(office);
	}

}

package domain;

import java.util.*;

public class Office {

	static ArrayList<House> houseList ;

	public Office() {
		// TODO Auto-generated method stub
		
		houseList = new ArrayList<House>();
	}
	
	public ArrayList<House> getHouseList() {
		return houseList;
	}
		
	public void addHouse(House house) {
		int i = 0;
		boolean idInitialized = false;
		while(!idInitialized && houseList.size()> i){
			if(houseList.get(i).getId() != i){
				house.setId(i);
				idInitialized = true;
			}
			i++;
		}
		if (!idInitialized) {
			house.setId(houseList.size());			
		}
		
		houseList.add(house);
	}
}

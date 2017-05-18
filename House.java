package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class House {

	private int price;
	private int room;
	private int size;
	private int bathroom;
	private boolean airConditioner;
	private int id;
	

	public House(int price, int room, int size, int bathroom, boolean airConditioner) {
		setPrice(price);
		setRoom(room);
		setSize(size);
		setBathroom(bathroom);
		setAirConditioner(airConditioner);
		
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBathroom() {
		return bathroom;
	}

	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}

	public boolean isAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(boolean airConditioner) {
		this.airConditioner = airConditioner;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price)  {
		
		this.price =price;
	}
	
	public int getRoom() {
		return room;
	}
	
	public void setRoom(int room) {
			this.room =room;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size)  {
		this.size = size;
	
	}
	/*
	private boolean PriceValueTest(String value) throws Exception{
		//Positive,valid number check
		// For price value
		Pattern pattern = Pattern.compile("\\d{1,3}[,\\\\.]?(\\\\d{1,2})?");
		Matcher matcher = pattern.matcher(String.valueOf(value));
		try {
			price = Integer.parseInt(value);
		}
		catch (Exception e) {
			throw new Exception("You entered unvalid value for price.Please enter a integer value.");	}
		if(matcher.matches()){
			return true;
		}else{
			throw new Exception("Should be VALÝD!!!");
	}
	}

	private boolean sizeValueTest(String value) throws Exception {
		//Positive,valid number check
		// For size value
		Pattern pattern = Pattern.compile("^1*(?:[1-9][0-9]?|1000)$");
		Matcher matcher = pattern.matcher(String.valueOf(value));
		try {
			price = Integer.parseInt(value);
		}
		catch (Exception e) {
		throw new Exception("You entered unvalid value for size.Please enter a integer value.");	}
		if(matcher.matches()){
			return true;
		}else{
			throw new Exception("Should be VALÝD!!!");
	}
		}
	
		private boolean roomValueTest(String value) throws Exception {
			//Positive,valid number check
			// For room value
			Pattern pattern = Pattern.compile("^1*(?:[1-9][0-9]?|80)$");
			Matcher matcher = pattern.matcher(String.valueOf(value));
			try {
				price = Integer.parseInt(value);
			}
			catch (Exception e) {
			throw new Exception("You entered unvalid value for room.Please enter a integer value.");	}
			if(matcher.matches()){
				return true;
			}else{
				throw new Exception("Should be VALÝD!!!");
		}
		}
		*/
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId()+"-"+getPrice()+"-"+getSize()+"-"+getRoom()+"-"+getBathroom()+"-"+isAirConditioner();
	}
}
	
	

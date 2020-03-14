import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CityControlSystem {
	
	private String systemName;
	public List <City> cityList;
	
	public CityControlSystem (String systemName) {
		this.systemName = systemName;
		this.cityList = new LinkedList<City>();
	}
	
	public boolean addCity (City city) {
		if (findCity(city.getCityName()) > 0) {
			System.out.println("This city is already added to the list");
			return false;
		} else {
			cityList.add(city);
			return true;
		}
	}
	
	public boolean removeCity (City city) {
		int foundPosition = findCity(city);
		if(foundPosition < 0) {
			System.out.println("You can`t delete city that is not on the list");
			return false;
			} 
			this.cityList.remove(city);
			return true;
	}
	public boolean updateCityInfo (City oldCity, City newCity) {
			int foundPosition = findCity(oldCity);
			if(foundPosition < 0) {
				System.out.println("You can`t modify city that is not on the list");
				return false;
			}
			this.cityList.set(foundPosition, newCity);
			return true;
	}
	
	public void printList() {
		if(cityList.isEmpty()) {
			System.out.println("There is no cities on your list....");
		} else {
			for(int i = 0; i < this.cityList.size(); i++) {
				System.out.println((i+1) + "City :" + this.cityList.get(i).getCityName() +
									", Country : " + this.cityList.get(i).getCountryName() + 
									", Tourist attraction : " + this.cityList.get(i).getMainAttractions());
			}
		}
	}
	
	public String queryCity(City city) {
		if(findCity(city) >= 0) {
			System.out.println(city.getCityName());
		} else {
			System.out.println("City is not on the list");
		}
		return null;
	}
	
	public City queryCity (String name) {
	
		int foundPosition = findCity(name);
		if(foundPosition >= 0) {
			return this.cityList.get(foundPosition);
		} 
		return null; 
	}
	
	private int findCity(City city) {
		return this.cityList.indexOf(city);
	}
	
	private int findCity(String name) {
		for(int i = 0; i < cityList.size(); i++) {
			City city = this.cityList.get(i);
			if(city.getCityName().equals(name)) {
				return i;
			} 
		}
		return -1;
	}
	
	public void printMenu () {
		System.out.println("Press: ");
		System.out.println("1 - to add the city to the list \n" +
							"2 - to update city info \n" +
							"3 - find city on the list \n" +
							"4 - to remove city from the list \n" +
							"5 - to print list of cities \n" +
							"6 - to print the menu again \n" +
							"7 - to print the list of cities in txt file \n" + 
							"0 - to close the program");
	}
	
	public void save(String fileName) throws FileNotFoundException {
	    PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
	    for (City city : cityList)
	         pw.println(city.toString()); // call toString() on club, like club.toString()
	    pw.close();
	}
	
}

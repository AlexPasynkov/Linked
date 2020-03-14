import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static CityControlSystem control = new CityControlSystem("Version 1.0");
	
	public static void main(String[] args) {
//		startProgram();
		control.printMenu();
		boolean quit = false;
		while(!quit) {
			System.out.println("Please make your choice ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				addCity();
				break;
			case 2:
				updateInfo();
				break;
			case 3:
				queryCity();
				break;
			case 4: 
				removeCity();
				break;
			case 5:
				control.printList();
				break;
			case 6:
				control.printMenu();
				break;
			case 7:
				try {
					control.save("h.txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
//	private static void startProgram() {
//		System.out.println("Starting program...");
//		System.out.println("Please enter user name");
//		String userName = scanner.nextLine();
//		if(userName.equals("CEO")) {
//			System.out.println("Good day boss");
//		} else {
//			System.out.println("Welcome " + userName);
//		}
//	}
	
	private static void addCity() {
		
		System.out.println("Please enter city name: ");
		String cityName = scanner.nextLine();
		System.out.println("Please enter country name: ");
		String countryName = scanner.nextLine();
	
		System.out.println("Please enter city main attractions: ");
		String mainAttractions = scanner.nextLine();
		City newCity = City.createNewCity(cityName,countryName, mainAttractions);
		control.addCity(newCity);
		System.out.println("New city " +cityName + " in " + countryName + ", with " + mainAttractions + " is added to the list");
	}
	
	public static void updateInfo() {
		System.out.println("Please enter name of the city you want to update: ");
		String name = scanner.nextLine();
		City existingCity = control.queryCity(name);
		if(control.queryCity(name) == null) {
			System.out.println("This city is not on the list, please check spelling... ");
		}
		System.out.println("Please enter new name of the city: ");
		String newCityName = scanner.nextLine();
		System.out.println("Please enter new country name: ");
		String newCountryName = scanner.nextLine();
		System.out.println("Please enter new city main attractions: ");
		String newCityAttractions = scanner.nextLine();
		City updatedCity = City.createNewCity(newCityName, newCountryName, newCityAttractions);
		control.updateCityInfo(existingCity, updatedCity);
		System.out.println("Information about " + existingCity.getCityName() + " was successfully updated."
				+ " Now city is called " + updatedCity.getCityName());
	}	
	
	public static void queryCity() {
		System.out.println("Please enter name of the city, that you want to find on the list...");
		String name = scanner.nextLine();
		City searchingCity = control.queryCity(name);
		
		if(searchingCity == null) {
			System.out.println(name + " is not found");
			return;
		} 	
		System.out.println("We have found " + searchingCity.getCityName() + ", it is located in " + 
					searchingCity.getCountryName()+ " .It`s main attraction is " + searchingCity.getMainAttractions());
	}
	
	public static void removeCity() {
		System.out.println("Please enter city that you want to remove from the list...");
		String name = scanner.nextLine();
		City removedCity = control.queryCity(name);
		if(removedCity == null) {
			System.out.println("This city is not on the list. Please check spelling");
		} 
		System.out.println(removedCity.getCityName() + " is going to be removed from database. Cities information is going to be lost"
				+ " Press Y to confirm or Press N to return to menu");
		String choice = scanner.nextLine();
		if(choice.equals("Y")) {
			control.removeCity(removedCity);
		System.out.println("The city " + removedCity.getCityName() + " was successfully removed from the base");
		} else if (choice.equals("N")) {
			control.printMenu();
			return;
		}
	}
}

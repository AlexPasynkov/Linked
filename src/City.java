import java.io.Serializable;

public class City implements Serializable {
	
	private String cityName;
	private String countryName;
	private String mainAttractions;
	
	public City (String cityName, String countryName,String mainAttractions) {
		this.cityName = cityName;
		this.countryName = countryName;
		this.mainAttractions = mainAttractions;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public String getMainAttractions() {
		return mainAttractions;
	}
	
	public static City createNewCity(String cityName,String countryName, String mainAttractions) {
		return new City(cityName,countryName, mainAttractions);
	}

	@Override
	public String toString() {
		return "City [cityName=" + this.cityName + ", countryName=" + this.countryName + ", mainAttractions=" + this.mainAttractions
				+ "]";
	}
	
}

import java.util.ArrayList;

/**
* The Car class is a class which function is to
* initialize Car-type objects, and to mantain them in memory.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class Car 
{
	/**
	* String which contains the brand of the car.
	*/
	private String brand;
	/**
	* String which contains the model of the car.
	*/
	private String model;
	/**
	* String which contains the color of the car.
	*/
	private String color;
	/**
	* String which contains the h.p. of the car.
	*/
	private String hp;
	/**
	* String which contains the year of the car.
	*/
	private String year;
	/**
	* String which contains the price of the car.
	*/
	private String price;
	/**
	* String which contains the km of the car.
	*/
	private String km;
	
	/**
	* ArrayList of type Car which obtains all the cars from DB.
	*/
	private static ArrayList<Car> cars = new ArrayList<Car>();
	
	/**
	* Constructor of the Car class.
	*
	* @param String brand
	* @param String model
	* @param String color
	* @param String hp
	* @param String year
	* @param String price
	* @param String km
	*/
	public Car(String brand, String model, String color, String hp, String year, String price, String km)
	{
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.hp = hp;
		this.year = year;
		this.price = price;
		this.km = km;
	}

	/**
	* Returns the name of the brand of the car.
	*
	* @return String
	*/
	public String getBrand() 
	{
		return brand;
	}

	/**
	* Returns the name of the model of the car.
	*
	* @return String
	*/
	public String getModel() 
	{
		return model;
	}

	/**
	* Returns the color of the car.
	*
	* @return String
	*/
	public String getColor() 
	{
		return color;
	}

	/**
	* Returns the hp of the car.
	*
	* @return String
	*/
	public String getHp() 
	{
		return hp;
	}

	/**
	* Returns the year of the car.
	*
	* @return String
	*/
	public String getYear() 
	{
		return year;
	}

	/**
	* Returns the price of the car.
	*
	* @return String
	*/
	public String getPrice() 
	{
		return price;
	}

	/**
	* Returns the km of the car.
	*
	* @return String
	*/
	public String getKm() 
	{
		return km;
	}
	
	/**
	* Sets the brand of the car with the new text.
	*
	* @param String brand
	*/
	public void setBrand(String brand) 
	{
		this.brand = brand;
	}

	/**
	* Sets the model of the car with the new text.
	*
	* @param String model
	*/
	public void setModel(String model) 
	{
		this.model = model;
	}

	/**
	* Sets the color of the car with the new text.
	*
	* @param String color
	*/
	public void setColor(String color) 
	{
		this.color = color;
	}

	/**
	* Sets the hp of the car with the new text.
	*
	* @param String hp
	*/
	public void setHp(String hp) 
	{
		this.hp = hp;
	}

	/**
	* Sets the year of the car with the new text.
	*
	* @param String year
	*/
	public void setYear(String year) 
	{
		this.year = year;
	}

	/**
	* Sets the price of the car with the new text.
	*
	* @param String price
	*/
	public void setPrice(String price) 
	{
		this.price = price;
	}

	/**
	* Sets the km of the car with the new text.
	*
	* @param String km
	*/
	public void setKm(String km) 
	{
		this.km = km;
	}
	
	/**
	* Returns a text containing all the infos about the actual car object.
	*
	* @return String
	*/
	public String toString()
	{
		return "Brand: " + brand + "    Model: " + model + "    Color: " + color + "    HP: " + hp + "    Year: " + year + "    Price: " + price + "    Km: " + km;
	}
	
	/**
	* Returns an ArrayList with all the cars present in DB.
	*
	* @return ArrayList
	*/
	public static ArrayList<Car> getCars()
	{
		return cars;
	}
}

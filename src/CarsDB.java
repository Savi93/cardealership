import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
* The CarDB class is a class which works
* with the car table of the mySQL DB.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class CarsDB 
{
	/**
	* Statement used to comunicate with the DB.
	*/
	private static Statement st;
	/**
	* Connection used to comunicate with the DB.
	*/
	private static Connection conn;
	/**
	* Car object which contains the info of the selected car.
	*/
	private static Car actualCar;
	
	/**
	* Method used to obtain the connection with the DB.
	*/
	public static void obtainConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardealershipdb","admin","admin");
			st = conn.createStatement();
		}
		
		catch(ClassNotFoundException d)
		{
			Log.addInLog("ClassNotFoundException");
		}
		
		catch(SQLException d)
		{
			Log.addInLog("SQLException");
		}
	}
	
	/**
	* Method used to obtain the number of cars present in DB.
	* 
	* @return int number
	*/
	public static int countCars()
	{
		int number = 0;
		
		obtainConnection();
		
		try
		{
			ResultSet result = st.executeQuery("SELECT * FROM cars");
			
			while(result.next() != false)
				number++;
			
			conn.close();
		}
		
		catch(SQLException e)
		{
			Log.addInLog("SQLException");
		}
		
		return number;
	}
	
	/**
	* Method used to insert a new car object inside the DB.
	* 
	* @param String brand
	* @param String model
	* @param String color
	* @param String hp
	* @param String year
	* @param String price
	* @param String km
	*/
	public static void insertCar(String brand, String model, String color, String hp, String year, String price, String km)
	{
		obtainConnection();
		
		try
		{
			st.executeUpdate("INSERT INTO cars(brand, model, color, hp, year, price, km) VALUES ('" + brand + "','" + model + "','" + color + "','" + hp + "','" + year + "','" + price + "','" + km + "')");
			conn.close();
		}
		
		catch(SQLException e)
		{
			Log.addInLog("SQLException");
		}
	}
	
	/**
	* Method used to delete a specific car from DB.
	* 
	* @param String brand
	* @param String model
	* @param String color
	* @param String hp
	* @param String year
	* @param String price
	* @param String km 
	*/
	public static void deleteCar(String brand, String model, String color, String hp, String year, String price, String km)
	{
		obtainConnection();
		
		try
		{
			st.executeUpdate("DELETE FROM cars WHERE brand = '" + brand + "' AND model = '" + model + "' AND color = '" + color + "' AND hp = '" + hp + "' AND year = '" + year + "' AND price = '" + price + "' AND km = '" + km + "'");
			
			int j = 0;
			
			for(Car car : Car.getCars())
			{
				if(car.getBrand().equals(brand) && car.getModel().equals(model) && car.getColor().equals(color) && car.getHp().equals(hp) && car.getYear().equals(year) && car.getPrice().equals(price) && car.getKm().equals(km))
				{
					Car.getCars().remove(j);
					break;
				}
				
				j++;
			}
			
			Seller.getSellers().clear();
			
			conn.close();
		}
		
		catch(SQLException e)
		{
			Log.addInLog("SQLException");
		}
	}
	
	/**
	* Method used to delete all the cars from DB.
	*/
	public static void deleteAll()
	{
		obtainConnection();
		
		try
		{
			st.executeUpdate("DELETE FROM cars");
			Car.getCars().clear();
			conn.close();
		}
		
		catch(SQLException e)
		{
			Log.addInLog("SQLException");
		}
	}
	
	/**
	* Method used to update some parameters of the actual car inside DB.
	* 
	* @param String brand
	* @param String model
	* @param String color
	* @param String hp
	* @param String year
	* @param String price
	* @param String km 
	*/
	public static void updateActualCar(String brand, String model, String color, String hp, String year, String price, String km)
	{
		obtainConnection();
		
		try
		{
			st.executeUpdate("UPDATE cars SET brand = '" + brand + "', model = '" + model + "', color = '" + color + "', hp = '" + hp + "', year = '" + year + "', price = '" + price + "', km = '" + km + "' WHERE brand = '" + actualCar.getBrand() + "' AND model = '" + actualCar.getModel() + "' AND color = '" + actualCar.getColor() + "' AND hp = '" + actualCar.getHp() + "' AND year = '" + actualCar.getYear() + "' AND price = '" + actualCar.getPrice() + "' AND km = '" + actualCar.getKm() + "'");
			conn.close();
		}
		
		catch(SQLException e)
		{
			Log.addInLog("SQLException");
		}
	}
	
	/**
	* Method used to set the actual car with a new with the specific parameters.
	* 
	* @param String brand
	* @param String model
	* @param String color
	* @param String hp
	* @param String year
	* @param String price
	* @param String km 
	*/
	public static void setActualCar(String brand, String model, String color, String hp, String year, String price, String km)
	{
		obtainConnection();
		
		try
		{
			ResultSet result = st.executeQuery("SELECT * FROM cars WHERE brand = '" + brand + "' AND model = '" + model + "' AND color = '" + color + "' AND hp = '" + hp + "' AND year = '" + year + "' AND price = '" + price + "' AND km = '" + km + "'");
			result.next();
			actualCar = new Car(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
			conn.close();
		}
		
		catch(SQLException e)
		{
			Log.addInLog("SQLException");
		}
	}
	
	/**
	* Returns the actual car object.
	* 
	* @return Car actualCar
	*/
	public static Car getActualCar()
	{
		return actualCar;
	}
	
	/**
	* Method used to filter the cars present in DB and to put inside an ArrayList only
	* the interesting ones.
	* 
	* @param String brand
	* @param String model
	* @param String color
	* @param String hp
	* @param String year
	* @param String price
	* @param String km 
	* @return ArrayList<Car>
	*/
	public static ArrayList<Car> filterCars(String brand, String model, String color, String hp, String year, String price, String km) 
	{
		Car.getCars().clear();
		
		obtainConnection();
		
		String[] token1 = new String[2];
		String[] token2 = new String[2];
		ResultSet result;
		
		if(brand.equals(""))
			brand = "1' OR '12' = '12";
		if(model.equals(""))
			model= "1' OR '12' = '12";
		if(color.equals(""))
			color = "1' OR '12' = '12";
		if(hp.equals(""))
			hp = "1' OR '12' = '12";
		if(year.equals(""))
			year = "1' OR '12' = '12";
		if(price.equals(""))
			price = "1' OR '12' = '12";
		if(km.equals(""))
			km = "1' OR '12' = '12";
		
		try
		{
			if(!(price.equals("1' OR '12' = '12")) && !(km.equals("1' OR '12' = '12")))
			{
				token1 = price.split("-");
				token2 = km.split("-");
				
				result = st.executeQuery("SELECT * FROM cars WHERE (brand = '" + brand + "') AND (model = '" + model + "') AND (color = '" + color + "') AND (hp = '" + hp + "') AND (year = '" + year + "') AND (price > '" + token1[0] + "' AND price <= '" + token1[1] + "') AND (km > '" + token2[0] + "' AND km <= '" + token2[1] + "')");
			}
			
			else if(price.equals("1' OR '12' = '12") && !(km.equals("1' OR '12' = '12")))
			{
				token2 = km.split("-");
				result = st.executeQuery("SELECT * FROM cars WHERE (brand = '" + brand + "') AND (model = '" + model + "') AND (color = '" + color + "') AND (hp = '" + hp + "') AND (year = '" + year + "') AND (price = '" + price + "') AND (km > '" + token2[0] + "' AND km <= '" + token2[1] + "')");
			}
			
			else if(!(price.equals("1' OR '12' = '12")) && km.equals("1' OR '12' = '12"))
			{
				token1 = price.split("-");
				result = st.executeQuery("SELECT * FROM cars WHERE (brand = '" + brand + "') AND (model = '" + model + "') AND (color = '" + color + "') AND (hp = '" + hp + "') AND (year = '" + year + "') AND (price > '" + token1[0] + "' AND price <= '" + token1[1] + "') AND (km = '" + km + "')");
			}
			
			else
				result = st.executeQuery("SELECT * FROM cars WHERE (brand = '" + brand + "') AND (model = '" + model + "') AND (color = '" + color + "') AND (hp = '" + hp + "') AND (year = '" + year + "') AND (price = '" + price + "') AND (km = '" + km + "')");
			
			while(result.next() != false)
				Car.getCars().add(new Car(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
			
			conn.close();
		}
		
		catch(SQLException e)
		{
			Log.addInLog("SQLException");
		}
		
		return Car.getCars();
	}
	
	/**
	* Method which gets all the Cars from DB, puts
	* them inside an ArrayList and returns them.
	* 
	* @return ArrayList<Car>
	*/
	public static ArrayList<Car> initializeCars() 
	{
		Car.getCars().clear();
		
		obtainConnection();
		
		try
		{
			ResultSet result = st.executeQuery("SELECT * FROM cars");
			
			while(result.next() != false)
				Car.getCars().add(new Car(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
			
			conn.close();
		}
		
		catch(SQLException e)
		{
			Log.addInLog("SQLException");
		}
		
		return Car.getCars();
	}
}

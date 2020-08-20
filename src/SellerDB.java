import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
* The SellerDB class is a class which works
* with the user table of the mySQL DB.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class SellerDB 
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
		
		catch(ClassNotFoundException e)
		{
			Log.addInLog("ClassNotFoundException");
		}
		
		catch (SQLException d) 
		{
			Log.addInLog("SQLException");
		}
	}
	
	/**
	* Method which checks if the current name is already used.
	* 
	* @param String name
	*/
	public static boolean checkExistenceSeller(String name)
	{
		boolean existing = false;
		
		obtainConnection();
		
		try
		{
			ResultSet result = st.executeQuery("SELECT * FROM users WHERE name = '" + name + "'");
			existing = result.next();
			conn.close();
		}
		
		catch (SQLException d) 
		{
			Log.addInLog("SQLException");
		}
		
		return existing;
	}
	
	/**
	* Method which is used to login.
	* It checks if the parameters are correct to log.
	* 
	* @param String name
	* @param String password
	*/
	public static boolean loginSeller(String name, String psw)
	{
		obtainConnection();
		
		boolean correct = false;
		
		try
		{
			ResultSet result = st.executeQuery("SELECT * FROM users WHERE name = '" + name + "'" + "AND" + " password = '" + psw + "'");
			correct = result.next();
			conn.close();
		}
	
		catch (SQLException d) 
		{
			Log.addInLog("SQLException");
		}
		
		return correct;
	}
	
	/**
	* Method which inserts a new seller inside the DB.
	* 
	* @param String name
	* @param String password
	*/
	public static void insertSeller(String name, String psw)
	{
		obtainConnection();
		
		try
		{
			st.executeUpdate("INSERT INTO users(name, password) VALUES (" + "'" + name + "'" + "," + "'" + psw + "')");
			conn.close();
		}
		
		catch(SQLException e)
		{
			Log.addInLog("SQLException");
		}
	}
	
	/**
	* Method used to delete a seller from DB.
	* 
	*@param String name 
	*/
	public static void deleteSeller(String name)
	{
		obtainConnection();
		
		try
		{
			st.executeUpdate("DELETE FROM users WHERE name = '" + name + "'");
			Iterator<Seller> itr = Seller.getSellers().iterator();
			
			while(itr.hasNext())
				if(itr.next().getName().equals(name))
					itr.remove();
			
			conn.close();
		}
		
		catch(SQLException e)
		{
			Log.addInLog("SQLException");
		}
	}
	
	/**
	* Method which deletes all the users from DB.
	*/
	public static void deleteAll()
	{
		obtainConnection();
		
		try
		{
			st.executeUpdate("DELETE FROM users WHERE name <> 'admin'");
			
			conn.close();
		}
		
		catch(SQLException e)
		{
			Log.addInLog("SQLException");
		}
		
	}
	
	/**
	* Method which gets all the Sellers from DB, puts
	* them inside an ArrayList and returns them.
	* 
	* @return ArrayList
	*/
	public static ArrayList<Seller> initializeSellers()
	{
		Seller.getSellers().clear();
		
		obtainConnection();
		
		try
		{
			ResultSet result = st.executeQuery("SELECT * FROM users");
			
			while(result.next() != false)
				Seller.getSellers().add(new Seller(result.getString(1), result.getString(2)));
			
			conn.close();
		}
		
		catch(SQLException e)
		{
			Log.addInLog("SQLException");
		}
		
		return Seller.getSellers();
	}
}

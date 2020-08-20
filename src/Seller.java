import java.util.ArrayList;

/**
* The Seller class is a class which function is to
* initialize Seller-type objects, and to mantain them in memory.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class Seller 
{
	/**
	* String which contains the name of the seller.
	*/
	private String name;
	/**
	* String which contains the password of the seller.
	*/
	private String psw;
	/**
	* ArrayList of type Seller which obtains all the users from DB.
	*/
	private static ArrayList<Seller> sellers = new ArrayList<Seller>();
	/**
	* Seller object which contains the current user.
	*/
	private static Seller current;
	
	/**
	* Constructor of the Seller class.
	*
	* @param String name
	* @param String password
	*/
	public Seller(String name, String psw)
	{
		this.name = name;
		this.psw = psw;
	}

	/**
	* Returns the name of the seller.
	*
	* @return String
	*/
	public String getName() 
	{
		return name;
	}

	/**
	* Returns the password of the seller.
	*
	* @return String
	*/
	public String getPsw() 
	{
		return psw;
	}
	
	/**
	* Returns a Seller object with the info about the current user.
	*
	* @return Seller
	*/
	public static Seller getCurrentSeller()
	{
		return current;
	}

	/**
	* Sets the name of the Seller with the new text.
	*
	* @param String
	*/
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	* Sets the password of the Seller with the new text.
	*
	* @param String
	*/
	public void setPsw(String psw) 
	{
		this.psw = psw;
	}
	
	/**
	* Sets the current seller with a new one.
	*
	* @param Seller
	*/
	public static void setCurrentSeller(Seller seller)
	{
		current = seller;
	}
	
	/**
	* Returns a text with the info about the current seller.
	*
	* @return String
	*/
	public String toString()
	{
			return "Seller: " + name;
	}
	
	/**
	* Returns an ArrayList of type Seller with the Seller's inside DB.
	*
	* @param ArrayList<Seller>
	*/
	public static ArrayList<Seller> getSellers()
	{
		return sellers;
	}
}

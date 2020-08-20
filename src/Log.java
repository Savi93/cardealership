import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
* The Log class is a class used to mantain a cronology of errors inside
* 5 .dat files.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/

public class Log 
{
	/**
	* Boolean status of initialization of the class.
	*/
	private static boolean initialized = false;
	
	/**
	* FileHandler used for important errors.
	*/
	private static FileHandler warnhandl;
	
	/**
	* FileHandler used for minor errors.
	*/
	private static FileHandler zerohandl;
	
	/**
	* Logger with a high level.
	*/
	private static Logger warnlev;
	
	/**
	* Logger with a low level.
	*/
	private static Logger zerolev;
	
	/**
	* Method used to write the exceptions inside file.
	* @param String exception
	*/
	public static void addInLog(String exception)
	{
		if(exception.equals("BadlyClosedChooseException") || exception.equals("WrongFormatException") || exception.equals("LoginFailedException") || exception.equals("ExistingUserException") || exception.equals("DeleteAllException"))
			zerolev.info(Seller.getCurrentSeller() + " " + exception);
		else if(exception.equals("SQLException") || exception.equals("ClassNotFoundException") || exception.equals("IOException") || exception.equals("NullPointerException"))
		{
			zerolev.info(Seller.getCurrentSeller() + " " + exception);
			warnlev.warning("WARNING!!! " + Seller.getCurrentSeller() + " " + exception);
		}
	}
	
	/**
	* Method used to initialize all the objects inside the class.
	* 
	*/
	public static void initializeLogger()
	{
		try 
		{
			warnhandl = new FileHandler("log_danger_%g_5.dat", 10000, 5, true);
			zerohandl = new FileHandler("log_all_%g_5.dat", 10000, 5, true);
			
			warnhandl.setFormatter(new SimpleFormatter());
			zerohandl.setFormatter(new SimpleFormatter());
			warnlev = Logger.getLogger("Warning");
			warnlev.setLevel(Level.WARNING);
			warnlev.addHandler(warnhandl);
			zerolev = Logger.getLogger("Zero");
			zerolev.setLevel(Level.ALL);
			zerolev.addHandler(zerohandl);
			initialized = true;
		} 
		catch (SecurityException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	* Getter of the boolean initialized variable.
	* @return boolean initialized
	*/
	public static boolean isInitialized()
	{
		return initialized;
	}
	
	/**
	* Method which permits to close the FileHandler's.
	* 
	*/
	public static void closeLogger()
	{
		warnhandl.close();
		zerohandl.close();
	}
}

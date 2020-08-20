/**
* The ExistingUserException class is an extra exception class
* which is called when a someone tries to create a new user with
* the same name of an existing one.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class ExistingUserException extends Exception
{
	/**
	* Constructor of the class.
	*/
	public ExistingUserException()
	{
		Log.addInLog("ExistingUserException");
	}
}

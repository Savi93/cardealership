/**
* The LoginFailedException class is an extra exception class
* which is called when a login fails.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class LoginFailedException extends Exception
{
	/**
	* Constructor of the class.
	*/
	public LoginFailedException()
	{
		Log.addInLog("LoginFailedException");
	}
}

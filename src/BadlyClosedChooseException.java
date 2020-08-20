/**
* The BadlyClosedChooseException class is an extra exception class
* which is called when an JFileChooser is badly closed.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class BadlyClosedChooseException extends NullPointerException
{
	/**
	* Constructor of the class.
	*/
	public BadlyClosedChooseException()
	{
		Log.addInLog("BadlyClosedChooseException");
	}
}

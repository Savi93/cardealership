/**
* The DeleteAllException class is an extra exception class
* which is called when all the users or all the cars are being deleted.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class DeleteAllException extends Exception
{
	/**
	* Constructor of the class.
	*/
	public DeleteAllException()
	{
		Log.addInLog("DeleteAllException");
	}
}

import java.io.IOException;

import javax.swing.JOptionPane;

/**
* The WrongFormatException class is an extra exception class
* which is called when same invalid data is inserted or imported.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class WrongFormatException extends IOException
{
	/**
	* Constructor of the class.
	*/
	public WrongFormatException()
	{
		Log.addInLog("WrongFormatException");
		JOptionPane.showMessageDialog(null, "Wrong data inserted! Select properly the data to insert before!", "Error", JOptionPane.ERROR_MESSAGE);
	}
}

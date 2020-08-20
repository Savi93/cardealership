import java.awt.Color;
import java.awt.GridLayout;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
* The Main class is a fundamental class of the application
* it simply initializes the main panel of the application.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class MainPanel extends JPanel
{
	/**
	* General selection pane for the application.
	*/
	private static JTabbedPane window;
	
	/**
	* Constructor of the panel.
	*/
	public MainPanel() 
	{
		Frame.showImportMenu();
		Frame.showLogOutMenu();
		SellerDB.initializeSellers();
		
		MainPagePanel mainpage = new MainPagePanel();
		SellersPanel sellers = new SellersPanel();
		CarsPanel cars = new CarsPanel();
		MyInfoPanel myinfo = new MyInfoPanel();
		
		setLayout(new GridLayout());
		setBackground(Color.white);
		setForeground(Color.white);
		
		UIManager.put("TabbedPane.selected", Color.lightGray);
		UIManager.put("TabbedPane.borderHightlightColor", Color.black);
		UIManager.put("TabbedPane.contentAreaColor", Color.lightGray);
		UIManager.put("TabbedPane.contentBorderInsets", Color.lightGray);
	
		window = new JTabbedPane();
		window.setBackground(Color.white);
		window.setForeground(Color.black);
		window.add("Mainpage", mainpage);
		window.add("Sellers", sellers);
		window.add("My info", myinfo);
		window.add("Cars", cars);
		window.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		add(window);
	}
	
	/**
	* Returns the tabbed pane of the panel.
	*
	* @return JTabbedPane
	*/
	public static JTabbedPane getWindows()
	{
		return window;
	}
	
	/**
	* Sets the visualized panel to
	* the Cars panel.
	*/
	public static void setWindowCars()
	{
		window.setSelectedIndex(3);
	}
	
	/**
	* Sets the visualized panel to
	* the MyInfo panel.
	*/
	public static void setWindowMyInfo()
	{
		window.setSelectedIndex(2);
	}
	
	/**
	* Sets the visualized panel to
	* the Seller panel.
	*/
	public static void setWindowSeller()
	{
		window.setSelectedIndex(1);
	}
}

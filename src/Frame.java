import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
* The Frame class is a fundamental class of the application
* it simply initializes a frame with all the panels.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/

public class Frame extends JFrame
{
	/**
	* Frame where the application will be showed.
	*/
	private static JFrame loginframe;
	/**
	* General panel of the whole application.
	*/
	private static MainPanel mainpanel;
	/**
	* Panel for the login of the users.
	*/
	private static LoginPanel loginpanel;
	/**
	* String object for mantaining in memory the brand of the searched cars.
	*/
	private static String brandtext;
	/**
	* String object for mantaining in memory the model of the searched cars.
	*/
	private static String modeltext;
	/**
	* String object for mantaining in memory the color of the searched cars.
	*/
	private static String colortext;
	/**
	* String object for mantaining in memory the h.p. of the searched cars.
	*/
	private static String hptext;
	/**
	* String object for mantaining in memory the year of the searched cars.
	*/
	private static String yeartext;
	/**
	* Integer variable for mantaining in memory the position in the combobox of the prices searched.
	*/
	private static int pricepos;
	/**
	* Integer variable for mantaining in memory the position in the combobox of the km searched.
	*/
	private static int kmpos;
	
	/**
	* Item which closes the application.
	*/
	private static JMenuItem close;
	/**
	* Item which permits to import new cars from a file.
	*/
	private static JMenu importmenu;
	/**
	* Item which permits to logout the user.
	*/
	private static JMenu logoutmenu;
	/**
	* Counter of the total amount of cars.
	*/
	private static int records;
	/**
	* Total number of deleted cars in the actual session.
	*/
	private static int deleted = 0;
	/**
	* Total number of added cars in the actual session.
	*/
	private static int added = 0;
	/**
	* Boolean variabe for mantaining in memory the status of the brandcheckbox.
	*/
	private static boolean brandcheck;
	/**
	* Boolean variabe for mantaining in memory the status of the modelcheckbox.
	*/
	private static boolean modelcheck;
	/**
	* Boolean variabe for mantaining in memory the status of the colorcheckbox.
	*/
	private static boolean colorcheck;
	/**
	* Boolean variabe for mantaining in memory the status of the hpcheckbox.
	*/
	private static boolean hpcheck;
	/**
	* Boolean variabe for mantaining in memory the status of the yearcheckbox.
	*/
	private static boolean yearcheck;
	/**
	* Boolean variabe for mantaining in memory the status of the pricecheckbox.
	*/
	private static boolean pricecheck;
	/**
	* Boolean variabe for mantaining in memory the status of the kmcheckbox.
	*/
	private static boolean kmcheck;
	/**
	* Boolean variabe for mantaining in memory the status of the allcheckbox.
	*/
	private static boolean allcheck;
	
	/**
	* Entry point of the application
	* @param args
	*/
	public static void main(String[] args) 
	{
		if(!(Log.isInitialized()))
			Log.initializeLogger();
		
		try
		{
			setRecords(CarsDB.countCars());
			JMenuBar bar = new JMenuBar();
			JMenu aboutmenu = new JMenu("About");
			logoutmenu = new JMenu("Logout");
			JMenu closemenu = new JMenu("Close");
			importmenu = new JMenu("Import");
			importmenu.setVisible(false);
			
			JMenuItem about = new JMenuItem("About");
			JMenuItem logout = new JMenuItem("Logout");
			logoutmenu.setVisible(false);
			close = new JMenuItem("Close");
			close.addActionListener(new close_click());
			logout.addActionListener(new logout_click());
			about.addActionListener(new about_click());
			JMenuItem importer = new JMenuItem("Import");
			importer.addActionListener(new importer_click());
			
			logoutmenu.add(logout);
			aboutmenu.add(about);
			closemenu.add(close);
			importmenu.add(importer);
			
			bar.add(aboutmenu);
			bar.add(closemenu);
			bar.add(importmenu);
			bar.add(logoutmenu);
			
			loginframe = new JFrame("DAVID'S USED CARS SHOP");
			loginframe.setBackground(Color.white);
			loginframe.setForeground(Color.white);
			loginpanel = new LoginPanel();
			loginframe.setJMenuBar(bar);
			loginframe.add(loginpanel);
			loginframe.setVisible(true);
			loginframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
			loginframe.addWindowListener(new exit_click());
			loginframe.setSize(loginframe.getMaximumSize());
		}
		
		catch(NullPointerException e)
		{
			Log.addInLog("NullPointerException");
		}
	}
	
	/**
	* ActionListener which permits to the user
	* to logout.
	*/
	private static class logout_click implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			loginframe.dispose();
			main(null);
		}
	}
	
	/**
	* ActionListener which permits to everyone
	* to get some specific information about the APP.
	*/
	private static class about_click implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			JOptionPane.showMessageDialog(null, "David's used cars shop APP, by SAVEV DAVID \n TOTAL RECORDS: " + records + "\nDELETED RECORDS: " + deleted + "\nADDED RECORDS: " + added + "\nDB Path: jdbc:mysql://localhost:3306/cardealershipdb", "Info", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	
	/**
	* WindowListener which performs some actions when the close button is pressed.
	* 
	*/
	private static class exit_click implements WindowListener
	{

		@Override
		public void windowClosed(WindowEvent arg0) 
		{
			Log.closeLogger();
		}
			
		@Override
		public void windowActivated(WindowEvent arg0) {}
		@Override
		public void windowClosing(WindowEvent arg0) {}
		@Override
		public void windowDeactivated(WindowEvent arg0) {}
		public void windowDeiconified(WindowEvent arg0) {}
		@Override
		public void windowIconified(WindowEvent arg0) {}
		@Override
		public void windowOpened(WindowEvent arg0) {}
		
	}
	
	/**
	* ActionListener which permits to everyone
	* to close the APP.
	*/
	private static class close_click implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			loginframe.dispose();
			Log.closeLogger();
		}
	}
	
	/**
	* ActionListener which permits to each user
	* to import new cars from a .txt or .dat file.
	*/
	private static class importer_click implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			JOptionPane.showMessageDialog(null, "Import .dat or .txt files with the following format: \nbrand;model;color;hp;year;price;km\nbrand;model;color;hp;year;price;km\nAND SO ON....");
			JFileChooser choose = new JFileChooser();
			int n = choose.showSaveDialog(null);
			
			if(n == JFileChooser.CANCEL_OPTION)
				try
				{
					throw new BadlyClosedChooseException();
				}
			
				catch(BadlyClosedChooseException b){}
				
			
			else if(!(choose.getSelectedFile().getName().endsWith(".txt") || choose.getSelectedFile().getName().endsWith(".dat")))
				try 
				{
					throw new WrongFormatException();
				} 
				
				catch (WrongFormatException e2) {}
			
			else
			{
				File file = choose.getSelectedFile();
				try 
				{
					String text;
						
					BufferedReader read = new BufferedReader(new FileReader(file));
					
					try
					{
						while((text = read.readLine()) != null)
						{
							String[] token = new String[7];
							token = text.split(";");
							
							int hp = Integer.valueOf(token[3]);
							int year = Integer.valueOf(token[4]);
							int price = Integer.valueOf(token[5]);
							int km = Integer.valueOf(token[6]);
								
							CarsDB.insertCar(token[0], token[1], token[2], token[3], token[4], token[5], token[6]);
							incrementAdded();
							incrementRecords();
								
							refreshMainPanel();
							JOptionPane.showMessageDialog(null, "File with cars successfully imported !");
						}
						
						read.close();
					}
					
					catch(NumberFormatException | ArrayIndexOutOfBoundsException d)
					{
						throw new WrongFormatException();
					}
					
					catch(WrongFormatException c) {}
				}
				
				catch (IOException e1) 
				{
					Log.addInLog("IOException");
				}
			}
		}	
	}
	
	/**
	* Returns the frame of the application.
	*
	* @return JFrame
	*/
	public static JFrame getLoginFrame()
	{
		return loginframe;
	}
	
	/**
	* Removes the login panel from the 
	* frame.
	*/
	public static void removeLoginPanel()
	{
		loginframe.getContentPane().removeAll();
		addMainPanel();
		loginframe.revalidate();
	}
	
	/**
	* Adds the main panel to the
	* frame.
	*/
	public static void addMainPanel()
	{
		mainpanel = new MainPanel();
		loginframe.add(mainpanel);
	}
	
	/**
	* Refreshes the whole
	* main panel.
	*/
	public static void refreshMainPanel()
	{
		loginframe.getContentPane().removeAll();
		addMainPanel();
		loginframe.revalidate();
		loginframe.repaint();
	}
	
	/**
	* Makes visible the
	* import menu.
	*/
	public static void showImportMenu()
	{
		importmenu.setVisible(true);
	}
	
	/**
	* Makes visible the
	* logout menu.
	*/
	public static void showLogOutMenu()
	{
		logoutmenu.setVisible(true);
	}
	
	/**
	* Returns the total number of cars in the database.
	*
	* @return JFrame
	*/
	public static int getRecords()
	{
		return records;
	}
	
	/**
	* Sets the number of deleted cars.
	*
	* @param int new deleted
	*/
	public static void setDeleted(int number)
	{
		deleted = number;
	}
	
	/**
	* Sets the total number of cars inside the database.
	*
	* @param int new number
	*/
	public static void setRecords(int number)
	{
		records = number;
	}
	
	/**
	* Increments the total number
	* of added cars in the session.
	*/
	public static void incrementAdded()
	{
		added++;
	}
	
	/**
	* Increments the total number
	* of deleted cars in the session.
	*/
	public static void incrementDeleted()
	{
		deleted++;
	}
	
	/**
	* Decrements the total number
	* of cars present.
	*/
	public static void decrementRecords()
	{
		records--;
	}
	
	/**
	* Increments the total number
	* of cars present.
	*/
	public static void incrementRecords()
	{
		records++;
	}

	/**
	* Returns the String object which mantains in memory the brand text.
	*
	* @return String
	*/
	public static String getBrandtext() {
		return brandtext;
	}

	/**
	* Returns the String object which mantains in memory the model text.
	*
	* @return String
	*/
	public static String getModeltext() {
		return modeltext;
	}

	/**
	* Returns the String object which mantains in memory the color text.
	*
	* @return String
	*/
	public static String getColortext() {
		return colortext;
	}

	/**
	* Returns the String object which mantains in memory the h.p. text.
	*
	* @return String
	*/
	public static String getHptext() {
		return hptext;
	}

	/**
	* Returns the String object which mantains in memory the year text.
	*
	* @return String
	*/
	public static String getYeartext() {
		return yeartext;
	}

	/**
	* Returns the integer variable which mantains in memory the position in the combobox of the range of prices searched.
	*
	* @return String
	*/
	public static int getPricePos() {
		return pricepos;
	}

	/**
		* Returns the integer variable which mantains in memory the position in the combobox of the range of km searched.
	*
	* @return String
	*/
	public static int getKmPos() {
		return kmpos;
	}

	/**
	* Returns a boolean variable which mantains in memory the brandcheck.
	*
	* @return boolean
	*/
	public static boolean isBrandcheck() {
		return brandcheck;
	}

	/**
	* Returns a boolean variable which mantains in memory the modelcheck.
	*
	* @return boolean
	*/
	public static boolean isModelcheck() {
		return modelcheck;
	}

	/**
	* Returns a boolean variable which mantains in memory the colorcheck.
	*
	* @return boolean
	*/
	public static boolean isColorcheck() {
		return colorcheck;
	}

	/**
	* Returns a boolean variable which mantains in memory the hpcheck.
	*
	* @return boolean
	*/
	public static boolean isHpcheck() {
		return hpcheck;
	}

	/**
	* Returns a boolean variable which mantains in memory the yearcheck.
	*
	* @return boolean
	*/
	public static boolean isYearcheck() {
		return yearcheck;
	}

	/**
	* Returns a boolean variable which mantains in memory the pricecheck.
	*
	* @return boolean
	*/
	public static boolean isPricecheck() {
		return pricecheck;
	}

	/**
	* Returns a boolean variable which mantains in memory the kmcheck.
	*
	* @return boolean
	*/
	public static boolean isKmcheck() {
		return kmcheck;
	}

	/**
	* Returns a boolean variable which mantains in memory the allcheck.
	*
	* @return boolean
	*/
	public static boolean isAllcheck() {
		return allcheck;
	}

	/**
	* Sets the text of the brandtext to mantain in memory.
	*
	* @param String new text
	*/
	public static void setBrandtext(String brandtext) {
		Frame.brandtext = brandtext;
	}

	/**
	* Sets the text of the modeltext to mantain in memory.
	*
	* @param String new text
	*/
	public static void setModeltext(String modeltext) {
		Frame.modeltext = modeltext;
	}

	/**
	* Sets the text of the colortext to mantain in memory.
	*
	* @param String new text
	*/
	public static void setColortext(String colortext) {
		Frame.colortext = colortext;
	}

	/**
	* Sets the text of the hptext to mantain in memory.
	*
	* @param String new text
	*/
	public static void setHptext(String hptext) {
		Frame.hptext = hptext;
	}

	/**
	* Sets the text of the yeartext to mantain in memory.
	*
	* @param String new text
	*/
	public static void setYeartext(String yeartext) {
		Frame.yeartext = yeartext;
	}

	/**
	* Sets the integer variable which mantains in memory the position in the combobox of the range of prices searched.
	*
	* @param String new text
	*/
	public static void setPricePos(int pricepos) {
		Frame.pricepos = pricepos;
	}

	/**
	* Sets the integer variable which mantains in memory the position in the combobox of the range of km searched.
	*
	* @param String new text
	*/
	public static void setKmPos(int kmpos) {
		Frame.kmpos = kmpos;
	}
	
	/**
	* Sets the status of the brandcheck to mantain in memory.
	*
	* @param boolean new status
	*/
	public static void setBrandcheck(boolean brandcheck) {
		Frame.brandcheck = brandcheck;
	}

	/**
	* Sets the status of the modelcheck to mantain in memory.
	*
	* @param boolean new status
	*/
	public static void setModelcheck(boolean modelcheck) {
		Frame.modelcheck = modelcheck;
	}

	/**
	* Sets the status of the colorcheck to mantain in memory.
	*
	* @param boolean new status
	*/
	public static void setColorcheck(boolean colorcheck) {
		Frame.colorcheck = colorcheck;
	}

	/**
	* Sets the status of the hpcheck to mantain in memory.
	*
	* @param boolean new status
	*/
	public static void setHpcheck(boolean hpcheck) {
		Frame.hpcheck = hpcheck;
	}

	/**
	* Sets the status of the yearcheck to mantain in memory.
	*
	* @param boolean new status
	*/
	public static void setYearcheck(boolean yearcheck) {
		Frame.yearcheck = yearcheck;
	}

	/**
	* Sets the status of the pricecheck to mantain in memory.
	*
	* @param boolean new status
	*/
	public static void setPricecheck(boolean pricecheck) {
		Frame.pricecheck = pricecheck;
	}

	/**
	* Sets the status of the kmcheck to mantain in memory.
	*
	* @param boolean new status
	*/
	public static void setKmcheck(boolean kmcheck) {
		Frame.kmcheck = kmcheck;
	}

	/**
	* Sets the status of the allcheck to mantain in memory.
	*
	* @param boolean new status
	*/
	public static void setAllcheck(boolean allcheck) {
		Frame.allcheck = allcheck;
	}
}

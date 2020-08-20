import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
* The LoginPanel class is a fundamental class of the application
* it is used to log inside the application.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class LoginPanel extends JPanel
{
	/**
	* JLabel containing the name of the application.
	*/
	private JLabel logoname;
	/**
	* JLabel containing the logo of the application.
	*/
	private JLabel logo;
	/**
	* JTextField used to enter the username.
	*/
	private JTextField userenter;
	/**
	* JpasswordField used to enter the password of the user.
	*/
	private JPasswordField pswenter;
	/**
	* JLabel containing "user".
	*/
	private JLabel userlabel;
	/**
	* JLabel containing "password".
	*/
	private JLabel pswlabel;
	/**
	* JButton which permits to enter.
	*/
	private JLabel enterbutton;
	/**
	* JButton used to create new users.
	*/
	private JLabel newuser;
	
	/**
	* First container used to mantain ordered the panel.
	*/
	private JPanel container1;
	
	/**
	* Second container used to mantain ordered the panel.
	*/
	private JPanel container2;
	
	/**
	* Third container used to mantain ordered the panel.
	*/
	private JPanel container3;
	
	/**
	* Fourth container used to mantain ordered the panel.
	*/
	private JPanel container4;
	
	/**
	* Fifth container used to mantain ordered the panel.
	*/
	private JPanel container5;
	
	
	/**
	* Constructor of the class.
	*/
	public LoginPanel()
	{
		Font myFont = new Font("MyFont", 25, 25);
		
		logoname = new JLabel(new ImageIcon("name.png"));
		logoname.setBackground(Color.black);
		logo = new JLabel(new ImageIcon("bugatti.png"));
		userenter = new JTextField();
		userenter.setFont(myFont);
		pswenter = new JPasswordField();
		pswenter.setFont(myFont);
		userlabel = new JLabel("Username: ");
		userlabel.setFont(myFont);
		pswlabel = new JLabel("Password: ");
		pswlabel.setFont(myFont);
		enterbutton = new JLabel(new ImageIcon("enter.png"));
		newuser = new JLabel(new ImageIcon("newuser.png"));
		
		enterbutton.addMouseListener(new enter_click());
		newuser.addMouseListener(new newuser_click());
		
		setLayout(new GridLayout(5,1));
		
		container1 = new JPanel(new GridLayout());
		container1.add(logoname);
		container1.setBackground(Color.white);
		container2 = new JPanel(new GridLayout());
		container2.add(logo);
		container2.setBackground(Color.white);
		container3 = new JPanel(new GridLayout());
		container3.setBackground(Color.white);
		container4 = new JPanel(new GridLayout(2,2));
		container4.add(userlabel);
		container4.add(userenter);
		container4.add(pswlabel);
		container4.add(pswenter);
		container4.setBackground(Color.white);
		container5 = new JPanel(new GridLayout(1,2));
		container5.add(enterbutton);
		container5.add(newuser);
		container5.setBackground(Color.white);
		
		add(container1);
		add(container2);
		add(container3);
		add(container4);
		add(container5);
	}
	
	/**
	* ActionListener used to enter inside the application.
	*/
	private class enter_click implements MouseListener
	{
		public void mousePressed(MouseEvent arg0) 
		{
			if(SellerDB.loginSeller(userenter.getText(), pswenter.getText()))
			{
				Seller.setCurrentSeller(new Seller(userenter.getText(), pswenter.getText()));
				Frame.removeLoginPanel();
			}
					
			else
			{
				JOptionPane.showMessageDialog(null, "Wrong access parameters!", "ERROR", JOptionPane.ERROR_MESSAGE);
				
				try
				{
					throw new LoginFailedException();
				}
				
				catch(LoginFailedException e) {}
				deleteLoginParameters();
			}			
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	/**
	* ActionListener used to create a new user.
	*/
	private class newuser_click implements MouseListener
	{
		@Override
		public void mousePressed(MouseEvent arg0) 
		{
			if(Pattern.matches("([a-z0-9]*[-._]?[a-z0-9]*)", userenter.getText()) && userenter.getText().length() >= 5 && Pattern.matches("([\\x03-\\x7F]{5,})", pswenter.getText()))
			{
				if(SellerDB.checkExistenceSeller(userenter.getText()))
				{
					JOptionPane.showMessageDialog(null, "Existing user!", "ERROR", JOptionPane.ERROR_MESSAGE);
					try
					{
						throw new ExistingUserException();
					}
					
					catch(ExistingUserException e){}
					
					deleteLoginParameters();
				}
					
				else
				{
					SellerDB.insertSeller(userenter.getText(), pswenter.getText());
					Seller.setCurrentSeller(new Seller(userenter.getText(), pswenter.getText()));
					Frame.removeLoginPanel();
				}			
			}
				
			else
			{
				JOptionPane.showMessageDialog(null, "Username or password NOT VALID!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				deleteLoginParameters();
			}
				
		}
		
		public void mouseClicked(MouseEvent arg0) {}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	/**
	* Method used to delete the text inserted inside username and password.
	*/
	public void deleteLoginParameters()
	{
		userenter.setText("");
		pswenter.setText("");
		this.repaint();
	}
}

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* The MainPagePanel class is a class of the application
* which shows a Welcome message to the user.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/

public class MainPagePanel extends JPanel
	{
		/**
		 * Label containing the Welcome text.
		 */
		private JLabel welcome;
		/**
		* Label containing the name of the current user.
		*/
		private JLabel info;
		/**
		* Label containing a smile image.
		*/
		private JLabel smile;
		
		/**
		* Constructor of the MainPagePanel.
		*/
		public MainPagePanel()
		{
			setBackground(Color.white);
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			welcome = new JLabel("WELCOME SELLER: " + Seller.getCurrentSeller().getName());
			welcome.setFont(new Font("MyFont", 35, 35));
			welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
			info = new JLabel("HAVE A NICE DAY AND GOOD WORK :)!");
			info.setFont(new Font("MyFont", 35, 35));
			info.setAlignmentX(Component.CENTER_ALIGNMENT);
			smile = new JLabel(new ImageIcon("smile.png"));
			smile.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(welcome);
			add(info);	
			add(smile);
		}
	}
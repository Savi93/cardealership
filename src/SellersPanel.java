import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

/**
* The SellersPanel class is a class which function is to
* show all the Sellers, and gives the possibility to delete users.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class SellersPanel extends JPanel
	{
		/**
		 * Combobox which contains all the sellers registred.
		 */
		private JComboBox deleteUser;
		/**
		* Label containing as text the title.
		*/
		private JLabel title;
		/**
		* Button which permits to delete all the users.
		*/
		private JButton deleteAll;
		/**
		* Button which permits to delete the user selected by the combobox.
		*/
		private JButton deleteThisUser;
		/**
		* Textarea contaning all the sellers.
		*/
		private JTextArea text;
		/**
		* Scrollbar of the textarea.
		*/
		private JScrollPane scroll;
		/**
		* First container used to organize the panel.
		*/
		private JPanel container0;
		/**
		* Second container used to organize the panel.
		*/
		private JPanel container1;
		/**
		* Third container used to organize the panel.
		*/
		private JPanel container2;
		
		/**
		* Constructor of the SellersPanel.
		*/
		public SellersPanel()
		{
			setBackground(Color.white);
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			text = new JTextArea();
			text.setEditable(false);
			text.setFont(new Font("MyFont",20,20));
			text.setForeground(Color.black);
			text.setBackground(Color.white);
			text.setBorder(new LineBorder(Color.black));
			text.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			scroll = new JScrollPane(text);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			deleteAll = new JButton("Delete ALL");
			deleteAll.addActionListener(new delete_all_click());
			deleteAll.setAlignmentX(Component.CENTER_ALIGNMENT);
			deleteAll.setBackground(Color.red);
			
			if(!(Seller.getCurrentSeller().getName().equals("admin")))
				deleteAll.setVisible(false);
			
			deleteUser = new JComboBox();
			deleteUser.setBackground(Color.lightGray);
			deleteThisUser = new JButton("Delete user");
			deleteThisUser.setBackground(Color.lightGray);
			deleteUser.setAlignmentX(Component.CENTER_ALIGNMENT);
			deleteThisUser.addActionListener(new delete_this_click());
			
			if(Seller.getCurrentSeller().getName().equals("admin"))
				for(Seller user : Seller.getSellers())
					deleteUser.addItem(user.getName());
			else
				deleteUser.addItem(Seller.getCurrentSeller().getName());
			
			deleteUser.removeItem("admin");
			
			title = new JLabel(new ImageIcon("sellerstitle.png"));
			title.setFont(new Font("myFont", 30, 30));
			title.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			for(Seller user : Seller.getSellers())
				text.append("\n" + "- " + user.toString());
			
			add(title);
			
			container0 = new JPanel(new GridLayout(1,1));
			container0.setBackground(Color.white);
			container0.add(scroll);
			add(container0);
			container0.setPreferredSize(getMaximumSize());
			
			add(deleteAll);	
			
			container1 = new JPanel();
			container1.setBackground(Color.white);
			container1.setLayout(new GridLayout(2,2));
			container1.add(new JPanel());
			container1.add(new JPanel());
			container1.add(deleteUser);
			container1.add(deleteThisUser);
			container1.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			container2 = new JPanel(new GridLayout(1,2));
			container2.setBackground(Color.white);
			container2.add(deleteAll);
			container2.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(container1);
			add(container2);
		}
		
		/**
		* ActionListener which deletes all the sellers.
		*/
		private class delete_all_click implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				SellerDB.deleteAll();
				Frame.refreshMainPanel();
				MainPanel.setWindowSeller();
				
				try
				{
					throw new DeleteAllException();
				}
				
				catch(DeleteAllException e) {}
			}
		}
		
		/**
		* ActionListener which deletes the seller selected by the combobox.
		*/
		private class delete_this_click implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(deleteUser.getSelectedItem() != null)
				{
					SellerDB.deleteSeller(deleteUser.getSelectedItem().toString());
						
					if(!(Seller.getCurrentSeller().getName().equals(deleteUser.getSelectedItem())))
					{
						Frame.refreshMainPanel();
						MainPanel.setWindowSeller();
					}
						
					else
					{
						Log.closeLogger();
						Frame.getLoginFrame().dispose();
					}
				}					
			}
		}		
	}
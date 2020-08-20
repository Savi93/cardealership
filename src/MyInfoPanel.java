import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* The MyInfoPanel  class is a fundamental class of the application
* it simply contains the infos about the user and permits to add an image.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class MyInfoPanel extends JPanel
{
	/**
	* JLabel which can contain the personal image.
	*/
	private JLabel image;
	
	/**
	* Path to the image.
	*/
	private File imageFile;
	
	/**
	* JLabel containing the name of the current user.
	*/
	private JLabel name;
	
	/**
	* General containing the title of the panel.
	*/
	private JLabel title;
	
	/**
	* NOT USED.
	*/
	private JButton changeImage;
	
	/**
	* Button which permits to select a personal image.
	*/
	private JButton addImage;
	
	/**
	* First container used to mantain ordered the panel.
	*/
	private JPanel container1;
	
	/**
	* Second container used to mantain ordered the panel.
	*/
	private JPanel container2;
	
	/**
	* Empty JLabel.
	*/
	private JLabel empty;
	
	/**
	* Constructor of the class.
	*/
	public MyInfoPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);
		
		empty = new JLabel();
		empty.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		changeImage = new JButton("");
		changeImage.setEnabled(false);
		changeImage.setBackground(Color.lightGray);
		addImage = new JButton("Add image");
		addImage.setBackground(Color.lightGray);
		addImage.addActionListener(new addImage_click());
		
		title = new JLabel(new ImageIcon("myinfotitle.png"));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		name = new JLabel(Seller.getCurrentSeller().toString());
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		name.setFont(new Font("MyFont", 25, 25));
		
		imageFile = new File(Seller.getCurrentSeller().getName() + ".png");
		
		if(imageFile.exists())
		{
			ImageIcon imageicon = new ImageIcon(Seller.getCurrentSeller().getName() + ".png");
			imageicon.getImage().flush();
			image = new JLabel(imageicon);
			addImage.setText("Change image");
		}
			
		else
		{
			image = new JLabel("NO IMAGE");
			image.setFont(new Font("MyFont", 35, 35));
		}
		
		image.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(title);
		add(name);
		add(image);
		
		container1 = new JPanel();
		container1.setLayout(new GridLayout(4,1));
		container1.setBackground(Color.white);
		container1.add(empty);
		add(container1);
		
		container2 = new JPanel();
		container2.setLayout(new GridLayout(2,1));
		container2.setBackground(Color.white);
		container2.add(addImage);
		container2.add(changeImage);
		add(container2);
		
	}
	
	/**
	* ActionListener used to select a personal image.
	*/
	private class addImage_click implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			JFileChooser chose = new JFileChooser();
			int n = chose.showOpenDialog(null);
			
			if(n == JFileChooser.CANCEL_OPTION)
				try
				{
					throw new BadlyClosedChooseException();
				}
			
				catch(BadlyClosedChooseException e){}
				
			else if(!(chose.getSelectedFile().getName().endsWith(".png") || chose.getSelectedFile().getName().endsWith(".jpg")))
				try 
				{
					throw new WrongFormatException();
				} 
				catch (WrongFormatException e1) {}
			
			else
			{
				File imageFile = chose.getSelectedFile();
				BufferedImage buff = null;
				Image tmp = null;
		
				try 
				{
					tmp = ImageIO.read(imageFile);
					tmp = tmp.getScaledInstance(300, 300, BufferedImage.SCALE_FAST);
					buff = new BufferedImage(300, 300, BufferedImage.SCALE_FAST);
					buff.getGraphics().drawImage(tmp, 0, 0, null);
					ImageIO.write(buff, "png", new File(Seller.getCurrentSeller().getName() + ".png"));
				} 
				
				catch (IOException e) 
				{
					Log.addInLog("IOException");
				}
			}
			
			Frame.refreshMainPanel();
			MainPanel.setWindowMyInfo();
		}
	}
}

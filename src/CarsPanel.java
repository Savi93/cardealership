import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
* The CarsPanel  class is a fundamental class of the application
* it shows the list of cars present in DB, and permits the user
* to delete or add cars.
*
* @author Savev David
* @version 1.0
* @since 29.05.17
*/
public class CarsPanel extends JPanel
	{
		/**
		 * TextField which permits to set as filter the brand of the car.
		 */
		private JTextField brandtext;
		
		/**
		 * TextField which permits to set as filter the model of the car.
		 */
		private JTextField modeltext;
		
		/**
		 * TextField which permits to set as filter the color of the car.
		 */
		private JTextField colortext;
		
		/**
		 * TextField which permits to set as filter the h.p. of the car.
		 */
		private JTextField hptext;
		
		/**
		 * TextField which permits to set as filter the year of the car.
		 */
		private JTextField yeartext;
		
		/**
		 * Combobox which permits to set as filter the price of the car.
		 */
		private JComboBox pricetext;
		
		/**
		 * Combobox which permits to set as filter the km of the car.
		 */
		private JComboBox kmtext;
		
		/**
		 * Checkbox which permits to set as filter the brand of the car.
		 */
		private JCheckBox brandcheck;
		
		/**
		 * Checkbox which permits to set as filter the model of the car.
		 */
		private JCheckBox modelcheck;
		
		/**
		 * Checkbox which permits to set as filter the color of the car.
		 */
		private JCheckBox colorcheck;
		
		/**
		 * Checkbox which permits to set as filter the h.p. of the car.
		 */
		private JCheckBox hpcheck;
		
		/**
		 * Checkbox which permits to set as filter the year of the car.
		 */
		private JCheckBox yearcheck;
		
		/**
		 * Checkbox which permits to set as filter the price of the car.
		 */
		private JCheckBox pricecheck;
		
		/**
		 * Checkbox which permits to set as filter the km of the car.
		 */
		private JCheckBox kmcheck;
		
		/**
		 * Checkbox which permits to set a general filter of the car.
		 */
		private JCheckBox allcheck;
		
		/**
		 * Button which permits to search the cars.
		 */
		private JButton go;
		
		/**
		 * Button which deletes the whole filtering parameters.
		 */
		private JButton filtering;
		
		/**
		 * Combobox which permits to delete the selected car.
		 */
		private JComboBox deleteCars;
		
		/**
		 * Label which contains the title of the page.
		 */
		private JLabel title;
		
		/**
		 * Button which deletes ALL the cars inside DB.
		 */
		private JButton deleteAll;
		
		/**
		 * Button which permits to delete the selected car of the combobox.
		 */
		private JButton deleteThisCar;
		
		/**
		 * Button which permits to add new cars.
		 */
		private JButton addnew;
		
		/**
		 * Button which permits to change same parameters of an existing car.
		 */
		private JButton update;
		
		/**
		 * TextArea which contains the list of the cars.
		 */
		private JTextArea text;
		
		/**
		 * Scroll element of the TextArea.
		 */
		private JScrollPane scroll;
		
		/**
		 * First container used to mantain ordered the panel.
		 */
		private JPanel container0;
		
		/**
		 * Second container used to mantain ordered the panel.
		 */
		private JPanel container01;
		
		/**
		 * Third container used to mantain ordered the panel.
		 */
		private JPanel container02;
		
		/**
		 * Fourth container used to mantain ordered the panel.
		 */
		private JPanel container03;
		
		/**
		 * Fifth container used to mantain ordered the panel.
		 */
		private JPanel container04;
		
		/**
		 * Sixth container used to mantain ordered the panel.
		 */
		private JPanel container1;
		
		/**
		 * Seventh container used to mantain ordered the panel.
		 */
		private JPanel container2;
		
		/**
		 * 8th container used to mantain ordered the panel.
		 */
		private JPanel container3;
		
		/**
		 * Constructor of the Class.
		 */
		public CarsPanel()
		{	
			setBackground(Color.white);
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			container0 = new JPanel();
			container0.setBackground(Color.white);
			
			container01 = new JPanel(new GridLayout(1,7));
			container01.setBackground(Color.white);
			
			container02 = new JPanel(new GridLayout(1,7));
			container02.setBackground(Color.white);
			
			container03 = new JPanel(new GridLayout(1,2));
			container03.setBackground(Color.white);
			
			container04 = new JPanel(new GridLayout(1,7));
			container04.setBackground(Color.white);
			
			brandtext = new JTextField();
			brandtext.setText(Frame.getBrandtext());
			brandtext.setEnabled(Frame.isBrandcheck());
			modeltext = new JTextField();
			modeltext.setText(Frame.getModeltext());
			modeltext.setEnabled(Frame.isModelcheck());
			colortext = new JTextField();
			colortext.setText(Frame.getColortext());
			colortext.setEnabled(Frame.isColorcheck());
			hptext = new JTextField();
			hptext.setText(Frame.getHptext());
			hptext.setEnabled(Frame.isHpcheck());
			yeartext = new JTextField();
			yeartext.setText(Frame.getYeartext());
			yeartext.setEnabled(Frame.isYearcheck());
			pricetext = new JComboBox();
			pricetext.addItem("");
			pricetext.addItem("0-5000");
			pricetext.addItem("5000-10000");
			pricetext.addItem("10000-20000");
			pricetext.addItem("20000-40000");
			pricetext.addItem("40000-999999");
			pricetext.setSelectedIndex(Frame.getPricePos());
			pricetext.setEnabled(Frame.isPricecheck());
			kmtext = new JComboBox();
			kmtext.addItem("");
			kmtext.addItem("0-50000");
			kmtext.addItem("50000-100000");
			kmtext.addItem("10000-150000");
			kmtext.addItem("150000-200000");
			kmtext.addItem("200000-999999");
			kmtext.setSelectedIndex(Frame.getKmPos());
			kmtext.setEnabled(Frame.isKmcheck());
			
			brandcheck = new JCheckBox("Brand");
			brandcheck.setSelected(Frame.isBrandcheck());
			brandcheck.setBackground(Color.white);
			brandcheck.addItemListener(new check_click());
			modelcheck = new JCheckBox("Model");
			modelcheck.setSelected(Frame.isModelcheck());
			modelcheck.setBackground(Color.white);
			modelcheck.addItemListener(new check_click());
			colorcheck = new JCheckBox("Color");
			colorcheck.setSelected(Frame.isColorcheck());
			colorcheck.setBackground(Color.white);
			colorcheck.addItemListener(new check_click());
			hpcheck = new JCheckBox("HP");
			hpcheck.setSelected(Frame.isHpcheck());
			hpcheck.setBackground(Color.white);
			hpcheck.addItemListener(new check_click());
			yearcheck = new JCheckBox("Year");
			yearcheck.setSelected(Frame.isYearcheck());
			yearcheck.setBackground(Color.white);
			yearcheck.addItemListener(new check_click());
			pricecheck = new JCheckBox("Price");
			pricecheck.setSelected(Frame.isPricecheck());
			pricecheck.setBackground(Color.white);
			pricecheck.addItemListener(new check_click());
			kmcheck = new JCheckBox("Km");
			kmcheck.setSelected(Frame.isKmcheck());
			kmcheck.setBackground(Color.white);
			kmcheck.addItemListener(new check_click());
			allcheck = new JCheckBox("SHOW ALL");
			allcheck.setSelected(Frame.isAllcheck());
			allcheck.setBackground(Color.white);
			allcheck.setAlignmentX(Component.CENTER_ALIGNMENT);
			allcheck.addActionListener(new all_check_click());
			
			go = new JButton("Search: ");
			filtering = new JButton("Clear filtering");
			go.setBackground(Color.lightGray);
			go.addActionListener(new go_click());
			filtering.setBackground(Color.gray);
			filtering.addActionListener(new filtering_click());
			
			container0.add(allcheck);
			container01.add(brandtext);
			container01.add(modeltext);
			container01.add(colortext);
			container01.add(hptext);
			container01.add(yeartext);
			container01.add(pricetext);
			container01.add(kmtext);
			container02.add(brandcheck);
			container02.add(modelcheck);
			container02.add(colorcheck);
			container02.add(hpcheck);
			container02.add(yearcheck);
			container02.add(pricecheck);
			container02.add(kmcheck);
			
			container03.add(go);
			container03.add(filtering);
			
			JPanel empty = new JPanel();
			empty.setBackground(Color.white);
			container04.add(empty);
			
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
			
			update = new JButton("Update this");
			update.addActionListener(new update_click());
			update.setAlignmentX(Component.CENTER_ALIGNMENT);
			update.setBackground(Color.lightGray);
			
			deleteCars = new JComboBox();
			deleteCars.setBackground(Color.lightGray);
			deleteThisCar = new JButton("Delete car");
			deleteThisCar.setBackground(Color.lightGray);
			deleteThisCar.setPreferredSize(new Dimension(200,30));
			deleteCars.setAlignmentX(Component.CENTER_ALIGNMENT);
			deleteThisCar.addActionListener(new delete_this_click());
			
			addnew = new JButton("Add new");
			addnew.setPreferredSize(new Dimension(400,30));
			addnew.setBackground(Color.green);
			addnew.addActionListener(new add_new_click());
			
			for(Car car : Car.getCars())
				deleteCars.addItem(car.getBrand() + ";" + car.getModel() + ";" + car.getColor() + ";" + car.getHp() + ";" + car.getYear() + ";" + car.getPrice() + ";" + car.getKm());
			
			title = new JLabel(new ImageIcon("carstitle.png"));
			title.setFont(new Font("myFont", 30, 30));
			title.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			for(Car car : Car.getCars())
				text.append("\n" + "- " + car.toString());
			
			add(title);
			add(container0);
			add(container01);
			add(container02);
			add(container03);
			add(container04);
			
			container1 = new JPanel(new GridLayout(1,1));
			container1.setBackground(Color.white);
			container1.add(scroll);
			add(container1);
			container1.setPreferredSize(getMaximumSize());
			
			container2 = new JPanel(new GridLayout(2,3));
			container2.setBackground(Color.white);
			container2.add(new JPanel());
			container2.add(new JPanel());
			container2.add(new JPanel());
			container2.add(deleteCars);
			container2.add(update);
			container2.add(deleteThisCar);
			container2.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(container2);
			
			container3 = new JPanel(new GridLayout(2,1));
			container3.setBackground(Color.white);
			container3.add(deleteAll);
			container3.add(addnew);
			container3.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(container3);
		}
		
		/**
		* ActionListener which enables the textfields of filtering by selecting
		* the proper checkbox.
		*/
		private class check_click implements ItemListener
		{
			public void itemStateChanged(ItemEvent arg0) 
			{
				if(brandcheck.isSelected())
					brandtext.setEnabled(true);
					
				else
				{
					brandtext.setEnabled(false);
					brandtext.setText("");
				}
								
				if(modelcheck.isSelected())
					modeltext.setEnabled(true);
					
				else
				{
					modeltext.setEnabled(false);
					modeltext.setText("");
				}
						
				if(colorcheck.isSelected())
					colortext.setEnabled(true);
					
				else
				{
					colortext.setEnabled(false);
					colortext.setText("");
				}	
						
				if(hpcheck.isSelected())
					hptext.setEnabled(true);
					
				else
				{
					hptext.setEnabled(false);
					hptext.setText("");
				}
						
				if(yearcheck.isSelected())
					yeartext.setEnabled(true);
					
				else
				{
					yeartext.setEnabled(false);
					yeartext.setText("");
				}
						
				if(pricecheck.isSelected())
				{
					pricetext.setEnabled(true);
				}
					
				else
				{
					pricetext.setEnabled(false);
					pricetext.setSelectedIndex(0);
				}
							
				if(kmcheck.isSelected())
				{
					kmtext.setEnabled(true);
				}
					
				else
				{
					kmtext.setEnabled(false);
					kmtext.setSelectedIndex(0);
				}
					
				if(((JCheckBox)arg0.getSource()).isSelected())
				{
					allcheck.setEnabled(false);
					allcheck.setSelected(false);
				}
				
				else if(!(brandcheck.isSelected()) && !(modelcheck.isSelected()) && !(colorcheck.isSelected()) && !(hpcheck.isSelected()) && 
						!(yearcheck.isSelected()) && !(pricecheck.isSelected()) && !(kmcheck.isSelected()))
					allcheck.setEnabled(true);
					
			}
		}
		
		/**
		* ActionListener which is related to the "all" checkbox.
		*/
		private class all_check_click implements ActionListener
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(allcheck.isSelected())
				{
					resetFilters();
					allcheck.setSelected(true);
				}
			}
			
		}
		
		/**
		* ActionListener related to the search button.
		* Permits a search of cars from DB.
		*/
		private class go_click implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(allcheck.isSelected())
				{
					CarsDB.initializeCars();
						
					Frame.setAllcheck(true);
					Frame.refreshMainPanel();
				} 
				
				else if(brandcheck.isSelected() || modelcheck.isSelected() || colorcheck.isSelected() || hpcheck.isSelected() || 
						yearcheck.isSelected() || pricecheck.isSelected() || kmcheck.isSelected())
				{
					Frame.setAllcheck(false);
					
					CarsDB.filterCars(brandtext.getText(), modeltext.getText(), colortext.getText(), hptext.getText(), yeartext.getText(), pricetext.getSelectedItem().toString(), kmtext.getSelectedItem().toString());
						
					if(brandcheck.isSelected())
					{
						Frame.setBrandcheck(true);
						Frame.setBrandtext(brandtext.getText());
					}
						
					else
					{
						Frame.setBrandcheck(false);
						Frame.setBrandtext("");
					}
								
					if(modelcheck.isSelected())
					{
						Frame.setModelcheck(true);
						Frame.setModeltext(modeltext.getText());
					}
						
					else
					{
						Frame.setModelcheck(false);
						Frame.setModeltext("");
					}
							
					if(colorcheck.isSelected())
					{
						Frame.setColorcheck(true);
						Frame.setColortext(colortext.getText());
					}
						
					else
					{
						Frame.setColorcheck(false);
						Frame.setColortext("");
					}
							
					if(hpcheck.isSelected())
					{
						Frame.setHpcheck(true);
						Frame.setHptext(hptext.getText());
					}
						
					else
					{
						Frame.setHpcheck(false);
						Frame.setHptext("");
					}
							
					if(yearcheck.isSelected())
					{
						Frame.setYearcheck(true);
						Frame.setYeartext(yeartext.getText());
					}
						
					else
					{
						Frame.setYearcheck(false);
						Frame.setYeartext("");
					}
							
					if(pricecheck.isSelected())
					{
						Frame.setPricecheck(true);
						Frame.setPricePos(pricetext.getSelectedIndex());
					}
						
					else
					{
						Frame.setPricecheck(false);
						Frame.setPricePos(0);
					}
							
					if(kmcheck.isSelected())
					{
						Frame.setKmcheck(true);
						Frame.setKmPos(kmtext.getSelectedIndex());
					}
						
					else
					{
						Frame.setKmcheck(false);
						Frame.setKmPos(0);
					}
						
					Frame.refreshMainPanel();
							
					}
				
				else
					JOptionPane.showMessageDialog(null, "No filters setted!", "Error", JOptionPane.ERROR_MESSAGE);
				
				MainPanel.setWindowCars();
			}
		}
		
		/**
		* ActionListener which resets all the filtering parameters.
		*/
		private class filtering_click implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				resetFilters();
			}
		}
		
		/**
		* ActionListener which deletes all the cars from DB.
		*/
		private class delete_all_click implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				CarsDB.deleteAll();
				CarsDB.initializeCars();
				Frame.refreshMainPanel();
				MainPanel.setWindowCars();
				Frame.setDeleted(Frame.getRecords());
				Frame.setRecords(0);
				
				try
				{
					throw new DeleteAllException();
				}
				
				catch(DeleteAllException e) {}
			}
		}

		/**
		* ActionListener which deletes the car selected by the combobox.
		*/
		private class delete_this_click implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(deleteCars.getSelectedItem() != null)
				{
					String[] token = new String[7];
					token = deleteCars.getSelectedItem().toString().split(";");
					CarsDB.deleteCar(token[0], token[1], token[2], token[3], token[4], token[5], token[6]);
					CarsDB.initializeCars();
					Frame.refreshMainPanel();
					MainPanel.setWindowCars();
					
					Frame.incrementDeleted();
					Frame.decrementRecords();
				}
			}
		}
		
		/**
		* ActionListener which permits to add new cars by opening JOptionpanes.
		*/
		private class add_new_click implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String brand;
				String model;
				String color;
				String hp;
				String year;
				String price;
				String km;
				
				brand = JOptionPane.showInputDialog("Insert the brand of the car..");
				model = JOptionPane.showInputDialog("Insert the model of the car..");
				color = JOptionPane.showInputDialog("Insert the color of the car..");
				hp = JOptionPane.showInputDialog("Insert the total amount of h.p. of the car..");
				year = JOptionPane.showInputDialog("Insert the production year of the car..");
				price = JOptionPane.showInputDialog("Insert the price of the car (in $)..");
				km = JOptionPane.showInputDialog("Insert the amount of km of the car..");
				
				if(brand.equals("") || model.equals("") || color.equals("") || hp.equals("") || year.equals("") || price.equals("") || km.equals(""))
					JOptionPane.showMessageDialog(null, "Invalid parameters inserted!", "Error", JOptionPane.ERROR_MESSAGE);
				
				else
				{
					try
					{
						int hpint = Integer.valueOf(hp);
						int yearint = Integer.valueOf(year);
						int priceint = Integer.valueOf(price);
						int kmint = Integer.valueOf(km);
						
						CarsDB.insertCar(brand, model, color, hp, year, price, km);
						CarsDB.initializeCars();
						Frame.refreshMainPanel();
						MainPanel.setWindowCars();
						
						Frame.incrementAdded();
						Frame.incrementRecords();
					}
					
					catch(NumberFormatException b)
					{
						try 
						{
							throw new WrongFormatException();
						} 
						catch (WrongFormatException e) {}
					}
				}
			}
		}
		
		/**
		* ActionListener which permits to edit some parameters of an existing car.
		*/
		private class update_click implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String brand;
				String model;
				String color;
				String hp;
				String year;
				String price;
				String km;
				
				if(deleteCars.getSelectedItem() != null)
				{
					String[] token = new String[7];
					token = deleteCars.getSelectedItem().toString().split(";");
					
					CarsDB.setActualCar(token[0], token[1], token[2], token[3], token[4], token[5], token[6]);
					
					brand = JOptionPane.showInputDialog(null, "Modify eventually the brand of the selected car.", CarsDB.getActualCar().getBrand());
					model = JOptionPane.showInputDialog(null, "Modify eventually the model of the selected car.", CarsDB.getActualCar().getModel());
					color = JOptionPane.showInputDialog(null, "Modify eventually the color of the selected car.", CarsDB.getActualCar().getColor());
					hp = JOptionPane.showInputDialog(null, "Modify eventually the total amount of h.p. of selected car.", CarsDB.getActualCar().getHp());
					year = JOptionPane.showInputDialog(null, "Modify eventually the production year of the selected car.", CarsDB.getActualCar().getYear());
					price = JOptionPane.showInputDialog(null, "Modify eventually the price of selected car (in $).", CarsDB.getActualCar().getPrice());
					km = JOptionPane.showInputDialog(null, "Modify eventually the amount of km of the selected car.", CarsDB .getActualCar().getKm());
					
					if(brand.equals("") || model.equals("") || color.equals("") || hp.equals("") || year.equals("") || price.equals("") || km.equals(""))
						JOptionPane.showMessageDialog(null, "Invalid parameters inserted!", "Error", JOptionPane.ERROR_MESSAGE);
					
					else
					{
						try
						{
							int hpint = Integer.valueOf(hp);
							int yearint = Integer.valueOf(year);
							int priceint = Integer.valueOf(price);
							int kmint = Integer.valueOf(km);
							
							CarsDB.updateActualCar(brand, model, color, hp, year, price, km);
							CarsDB.initializeCars();
							Frame.refreshMainPanel();
							MainPanel.setWindowCars();
						}
						
						catch(NumberFormatException b)
						{
							try 
							{
								throw new WrongFormatException();
							} 
							catch (WrongFormatException e) {}
						}
					}
				}
			}
		}
		
		/**
		* Method used to reset the filtering.
		*/
		public void resetFilters()
		{
			brandcheck.setSelected(false);
			modelcheck.setSelected(false);
			colorcheck.setSelected(false);
			hpcheck.setSelected(false);
			yearcheck.setSelected(false);
			pricecheck.setSelected(false);
			kmcheck.setSelected(false);
			allcheck.setSelected(false);
			brandtext.setText("");
			modeltext.setText("");
			colortext.setText("");
			hptext.setText("");
			yeartext.setText("");
			pricetext.setSelectedIndex(0);
			kmtext.setSelectedIndex(0);
			
			Frame.setAllcheck(false);
			Frame.setBrandcheck(false);
			Frame.setBrandtext("");
			Frame.setModelcheck(false);
			Frame.setModeltext("");
			Frame.setColorcheck(false);
			Frame.setColortext("");
			Frame.setHpcheck(false);
			Frame.setHptext("");
			Frame.setYearcheck(false);
			Frame.setYeartext("");
			Frame.setPricecheck(false);
			Frame.setPricePos(0);
			Frame.setKmcheck(false);
			Frame.setKmPos(0);
		}
	}
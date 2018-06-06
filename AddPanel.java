import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPanel extends JPanel
{
	public AddPanel(ArrayList<Item> inventory)
	{
		
		
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblName = new JLabel("Name: ");
		add(lblName, gbc);
		
		gbc.gridx++;
		JTextField txtName = new JTextField();
		add(txtName, gbc);
		txtName.setPreferredSize(new Dimension(100, 25));
		
		gbc.gridx--;
		gbc.gridy++;
		JLabel lblNum = new JLabel("Item Number: ");
		add(lblNum, gbc);
		
		gbc.gridx++;
		JTextField txtNum = new JTextField();
		add(txtNum, gbc);
		txtNum.setPreferredSize(new Dimension(100, 25));
		
		gbc.gridx--;
		gbc.gridy++;
		JLabel lblType = new JLabel("Type: ");
		add(lblType, gbc);
		
		gbc.gridx++;
		JTextField txtType = new JTextField();
		add(txtType, gbc);
		txtType.setPreferredSize(new Dimension(100, 25));
		
		gbc.gridx--;
		gbc.gridy++;
		JLabel lblQuantity = new JLabel("Quantity: ");
		add(lblQuantity, gbc);
		
		gbc.gridx++;
		JTextField txtQuantity = new JTextField();
		add(txtQuantity, gbc);
		txtQuantity.setPreferredSize(new Dimension(100, 25));
		
		gbc.gridx--;
		gbc.gridy++;
		JLabel lblLocation = new JLabel("Location: ");
		add(lblLocation, gbc);
		
		gbc.gridx++;
		JTextField txtLocation = new JTextField();
		add(txtLocation, gbc);
		txtLocation.setPreferredSize(new Dimension(100, 25));
		
		gbc.gridx--;
		gbc.gridy++;
		JLabel lblPrice = new JLabel("Price: ");
		add(lblPrice, gbc);
		
		gbc.gridx++;
		JTextField txtPrice = new JTextField();
		add(txtPrice, gbc);
		txtPrice.setPreferredSize(new Dimension(100, 25));
		
		gbc.gridx--;
		gbc.gridy++;
		JButton submit = new JButton ("Add Item");
		submit.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						try
						{
							if(txtName.getText() == null || txtNum.getText() == null || txtPrice.getText() == null || txtQuantity.getText() == null || txtLocation.getText() == null || txtType.getText() == null )
							{
								JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							}
							else
							{
								boolean already = true;
								Item add = new Item(Integer.parseInt(txtNum.getText()), Double.parseDouble(txtPrice.getText()), txtType.getText(), Integer.parseInt(txtQuantity.getText()), txtName.getText(), txtLocation.getText());
								for(int i = 0; i < inventory.size(); i++)
								{
									if(inventory.get(i).equals(add))
									{
										inventory.get(i).add();
										already = false;
										JOptionPane.showMessageDialog(null, "Item added.");
										txtNum.setText(null);
										txtName.setText(null);
										txtPrice.setText(null);
										txtQuantity.setText(null);
										txtLocation.setText(null);
										txtType.setText(null);
									}
									else if(inventory.get(i).getNum() == add.getNum())
									{
										JOptionPane.showMessageDialog(null, "Error. Item Numbers cannot be the same.");
										already = false;
										txtNum.setText(null);
									}
								}
								if(already)
								{
									inventory.add(add);
									JOptionPane.showMessageDialog(null, "Item added.");
									txtNum.setText(null);
									txtName.setText(null);
									txtPrice.setText(null);
									txtQuantity.setText(null);
									txtLocation.setText(null);
									txtType.setText(null);
								}
								
							}
							
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							txtNum.setText(null);
							txtName.setText(null);
							txtPrice.setText(null);
							txtQuantity.setText(null);
							txtLocation.setText(null);
							txtType.setText(null);
						}
						
					}
			
				});
		add(submit, gbc);
	}
}

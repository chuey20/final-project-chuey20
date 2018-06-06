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

public class NeedStockPanel extends JPanel
{
	public NeedStockPanel(ArrayList<Item> other)
	{
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JButton getStock = new JButton("Get Low Items");
		getStock.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						String low = "Low in Stock: /n";
						for(int i = 0; i < other.size(); i++)
						{
							if(other.get(i).getQuantity() <= 5)
							{
								low+=other.get(i).toString()+"\n";
							}
						}
						JOptionPane.showMessageDialog(null, low);
						
					}
			
				});
		
		gbc.gridy++;
		JLabel lblNum = new JLabel("Item number: ");
		add(lblNum, gbc);
		
		gbc.gridx++;
		JTextField txtNum  = new JTextField();
		txtNum.setPreferredSize(new Dimension(100, 25));
		add(txtNum, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JLabel lblQuantity = new JLabel("Desired Quantity: ");
		add(lblQuantity, gbc);
		
		gbc.gridx++;
		JTextField txtQuantity = new JTextField();
		txtQuantity.setPreferredSize(new Dimension(100, 25));
		add(txtQuantity, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						try
						{
							if(txtNum.getText() == null || txtQuantity.getText() == null)
							{
								JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							}
							else
							{
								for(int i = 0; i < other.size(); i++)
								{
									if(other.get(i).getNum() == Integer.parseInt(txtNum.getText()))
									{
										JOptionPane.showMessageDialog(null, "$"+(1.0*Integer.parseInt(txtQuantity.getText())*other.get(i).getPrice()));
										txtNum.setText(null);
										txtQuantity.setText(null);
									}
								}
							}
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							txtNum.setText(null);
							txtQuantity.setText(null);
						}
						
					}
			
				});
		add(calculate, gbc);
	}
}
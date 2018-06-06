import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TotalValueSpendPanel extends JPanel
{
	JButton submit;
	public TotalValueSpendPanel(ArrayList<Item> other)
	{
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		

		
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblItemNum = new JLabel("Item Number: ");
		add(lblItemNum, gbc);
		lblItemNum.setVisible(false);
		
		gbc.gridx=1;
		JTextField txtItemNum = new JTextField();
		txtItemNum.setPreferredSize(new Dimension(100, 25));
		add(txtItemNum, gbc);
		txtItemNum.setVisible(false);
		
		submit = new JButton("Calculate");
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		JButton itemPress = new JButton("Item Stock Value");
		add(itemPress, gbc);
		itemPress.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						txtItemNum.setVisible(true);
						lblItemNum.setVisible(true);
						submit.setVisible(true);
						
						gbc.gridx = 0;
						gbc.gridy = 4;
						submit.addActionListener(new ActionListener()
								{

									@Override
									public void actionPerformed(ActionEvent arg0) 
									{
										try
										{
											if(txtItemNum.getText() == null)
											{
												txtItemNum.setVisible(false);
												lblItemNum.setVisible(false);
												submit.setVisible(false);
												JOptionPane.showMessageDialog(null, "Error. Invalid input.");
												
											}
											else
											{
												for(int i = 0; i < other.size(); i++)
												{
													if(other.get(i).getNum() == Integer.parseInt(txtItemNum.getText()))
													{
														JOptionPane.showMessageDialog(null, "$"+other.get(i).getPrice()*other.get(i).getQuantity());
														txtItemNum.setText(null);
														txtItemNum.setVisible(false);
														lblItemNum.setVisible(false);
														submit.setVisible(false);
														return;
													}
													
													
												}
											}
											txtItemNum.setText(null);
											txtItemNum.setVisible(false);
											lblItemNum.setVisible(false);
											submit.setVisible(false);
											JOptionPane.showMessageDialog(null, "Error. Invalid input.");
										}
										catch(Exception e)
										{
											txtItemNum.setText(null);
											txtItemNum.setVisible(false);
											lblItemNum.setVisible(false);
											submit.setVisible(false);
											JOptionPane.showMessageDialog(null, "Error. Invalid input.");
										}
									}
							
								});
						add(submit, gbc);
						revalidate();
						
					}
			
				});
		
	
		gbc.gridx = 0;
		gbc.gridy = 0;
		JButton allPress = new JButton("Total Value");
		allPress.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						txtItemNum.setText(null);
						txtItemNum.setVisible(false);
						lblItemNum.setVisible(false);
						submit.setVisible(false);
						double sum = 0.0;
						for(int i = 0; i < other.size(); i++)
						{
							sum+= other.get(i).getQuantity()*other.get(i).getPrice();
						}
						JOptionPane.showMessageDialog(null, "$"+sum);
						return;

					}
			
				});
		add(allPress, gbc);
		
		
		
	}
}

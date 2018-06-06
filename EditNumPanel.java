import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditNumPanel extends JPanel
{
	public EditNumPanel(Item other, InventoryFrame frame, EditPanel eP)
	{
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblNum = new JLabel("New Item Number: ");
		add(lblNum, gbc);
		
		gbc.gridx = 1;
		JTextField txtNum = new JTextField();
		txtNum.setPreferredSize(new Dimension(100, 25));
		add(txtNum, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		JButton submit = new JButton("Change");
		submit.addActionListener( new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							if(txtNum.getText() == null)
							{
								JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							}
							else
							{
								other.setNum(Integer.parseInt(txtNum.getText()));
								JOptionPane.showMessageDialog(null, "Number changed.");
								txtNum.setText(null);
							}
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							txtNum.setText(null);
						}
					}
				});
		add(submit, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy++;
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						frame.change(eP, "Edit Panel");
						
					}
			
				});
		add(back, gbc);
	}
}

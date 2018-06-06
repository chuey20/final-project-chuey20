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

public class EditTypePanel extends JPanel
{
	String old;
	public EditTypePanel(Item other, InventoryFrame frame, EditPanel eP, NewTypePanel nTP, ListPanel lP, ArrayList<Item> items) 
	{
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblType = new JLabel("New Type: ");
		add(lblType, gbc);
		
		gbc.gridx = 1;
		JTextField txtType = new JTextField();
		txtType.setPreferredSize(new Dimension(100, 25));
		add(txtType, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		JButton submit = new JButton("Change");
		submit.addActionListener( new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						if(txtType.getText() == null)
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid input.");
						}
						else
						{
							old  = other.getType();
							other.setType(txtType.getText());
							JOptionPane.showMessageDialog(null, "Type changed.");
							txtType.setText(null);
							nTP.update();
							lP.update();
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

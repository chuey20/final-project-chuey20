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

public class EditLocationPanel extends JPanel
{
	private static final long serialVersionUID = 695546205400691872L;

	public EditLocationPanel(Item other, InventoryFrame frame, EditPanel eP)
	{
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblLocation = new JLabel("New Location: ");
		add(lblLocation, gbc);
		
		gbc.gridx = 1;
		JTextField txtLocation = new JTextField();
		txtLocation.setPreferredSize(new Dimension(100, 25));
		add(txtLocation, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		JButton submit = new JButton("Change");
		submit.addActionListener( new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						if(txtLocation.getText() == null)
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							txtLocation.setText(null);
						}
						else
						{
							other.setLocation(txtLocation.getText());
							JOptionPane.showMessageDialog(null, "Location changed.");
							txtLocation.setText(null);
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

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

public class EditNamePanel extends JPanel
{
	private static final long serialVersionUID = -8440976924245598071L;

	public EditNamePanel(Item other,  InventoryFrame frame, EditPanel eP)
	{
		
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblName = new JLabel("New Name: ");
		add(lblName, gbc);
		
		gbc.gridx = 1;
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(100, 25));
		add(txtName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		JButton submit = new JButton("Change");
		submit.addActionListener( new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						if(txtName.getText() == null)
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							txtName.setText(null);
						}
						else
						{
							other.setName(txtName.getText());
							JOptionPane.showMessageDialog(null, "Name changed.");
							txtName.setText(null);
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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel
{
	public HomePanel()
	{
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		//picture, directions
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblDirections = new JLabel("Welcome to the SyMec Inventory");
		add(lblDirections, gbc);
		
		gbc.gridy++;
		ImageIcon image = new ImageIcon("pic2.JPG");
		JLabel label = new JLabel(image);
		add(label, gbc);
		
		
		
	}
}

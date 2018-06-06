import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class EditPanel extends JPanel
{
	public EditPanel(Item item, InventoryFrame other, NewTypePanel nTP, ListPanel lP, ArrayList<Item> list)
	{
		EditPanel eP = this;
		EditNamePanel editName = new EditNamePanel(item, other, eP);
		EditLocationPanel editLocation = new EditLocationPanel(item, other, eP);
		EditNumPanel editNum = new EditNumPanel(item, other, eP);
		EditPricePanel editPrice = new EditPricePanel(item, other, eP);
		EditTypePanel editType = new EditTypePanel(item, other, eP, nTP, lP, list);
		
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblDirections = new JLabel("Pick an option to edit");
		add(lblDirections, gbc);
		
		gbc.gridy++;
		String[] optionAdd = {"Name", "Item Number", "Type", "Location", "Price"};
		JList<String> optionsList = new JList<String>(optionAdd);
		
		JScrollPane options = new JScrollPane(optionsList);
		options.setPreferredSize(new Dimension(200, 100));
		add(options, gbc);
		
		gbc.gridy++;
		JButton  go = new JButton("Go");
		go.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						if(optionsList.getSelectedIndex() == -1)
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid input.");
						}
						else if(optionsList.getSelectedIndex() == 0)
						{
							other.change(editName, "Edit Name");
						}
						else if(optionsList.getSelectedIndex() == 1)
						{
							other.change(editNum, "Edit Number");
						}
						else if(optionsList.getSelectedIndex() == 2)
						{
							other.change(editType, "Edit Type");
						}
						else if(optionsList.getSelectedIndex() == 3)
						{
							other.change(editLocation, "Edit Location");
						}
						else if(optionsList.getSelectedIndex() == 4)
						{
							other.change(editPrice, "Edit Price");
						}
						optionsList.setSelectedIndex(-1);
						
					}
			
				});
		add(go, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{	lP.update();
						nTP.update();
						other.change("List");
						
					}
			
				});
		add(back, gbc);
	}


}

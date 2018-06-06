import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListPanel extends JPanel
{
	private static final long serialVersionUID = 6181392593648630324L;
	ArrayList<Item> other;
	JScrollPane scroll;
	ArrayList<String> convert;
	String[] typeAdd;
	InventoryFrame frame;
	JButton go;
	ActionListener listener;
	ListPanel lP;
	public ListPanel(ArrayList<Item> inventory, InventoryFrame iF)
	{
		lP = this;
		frame = iF;
		other = inventory;
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		
		convert = new ArrayList<String>();
		for(int i = 0; i < other.size(); i++)
		{
			if(!convert.contains(other.get(i).getType()))
			{
				convert.add(other.get(i).getType());
			
			}
		}
		
		typeAdd = new String[convert.size()];
		for(int k = 0; k < convert.size(); k++)
		{
			typeAdd[k] = convert.get(k);
		}
		JList<String> typeList = new JList<String>(typeAdd);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		scroll = new JScrollPane(typeList);
		scroll.setPreferredSize(new Dimension(200, 100));
		add(scroll, gbc);
		
		gbc.gridy++;
		go = new JButton("Go");
		listener = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(typeList.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Error. Invalid input.");
				}
				for(int i = 0; i < typeAdd.length; i++)
				{
					if(typeList.getSelectedIndex() == i)
					{
						NewTypePanel add = new NewTypePanel(frame, typeAdd[i], other, lP);
						frame.change(add, "Items");
						typeList.setSelectedIndex(-1);
					}
				}

			}
	
		};
		go.addActionListener(listener);
		
		add(go, gbc);
		
		
	}
	
	public void update()
	{
		convert = new ArrayList<String>();
		for(int i = 0; i < other.size(); i++)
		{
			if(!convert.contains(other.get(i).getType()))
			{
				convert.add(other.get(i).getType());
			
			}
		}
		
		typeAdd = new String[convert.size()];
		for(int k = 0; k < convert.size(); k++)
		{
			typeAdd[k] = convert.get(k);
		}
		JList<String> typeList = new JList<String>(typeAdd);
		scroll.setViewportView(typeList);
		scroll.revalidate();
		revalidate();
		
		go.removeActionListener(listener);
		listener = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(typeList.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Error. Invalid input.");
				}
				for(int i = 0; i < typeAdd.length; i++)
				{
					if(typeList.getSelectedIndex() == i)
					{
						NewTypePanel add = new NewTypePanel(frame, typeAdd[i], other, lP);
						frame.change(add, "Items");
						typeList.setSelectedIndex(-1);
					}
				}

			}
	
		};
		go.addActionListener(listener);
	}

	

}

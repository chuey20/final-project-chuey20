import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class NewTypePanel extends JPanel
{
	private static final long serialVersionUID = 5590150782400381948L;
	
	String type;
	NewTypePanel nTP;
	ArrayList<Item> other;
	InventoryFrame frame;
	ListPanel lP;
	
	public NewTypePanel(InventoryFrame f, String t, ArrayList<Item> o, ListPanel l)
	{
		nTP = this;
		other = o;
		frame = f;
		lP = l;
		
		type = t;
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		for(int i = 0; i < other.size(); i++)
		{
			if(other.get(i).getType().equals(type))
			{
				JLabel lblAdd = new JLabel(other.get(i).toString());
				add(lblAdd, gbc);
				//add quantity button
				gbc.gridx++;
				JButton plus = new JButton("+");
				plus.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent arg0) 
							{
								for(int k = 0; k < other.size(); k++)
								{
									if(other.get(k).toString().equals(lblAdd.getText()))
									{
										other.get(k).add();
										lblAdd.setText(other.get(k).toString());
									}
								}
							}
					
						});
				add(plus, gbc);
				gbc.gridx++;
				JButton minus = new JButton("-");
				minus.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent arg0) 
							{
								for(int k = 0; k < other.size(); k++)
								{
									if(other.get(k).toString().equals(lblAdd.getText()))
									{
										if(other.get(k).getQuantity() <= 0)
										{
											JOptionPane.showMessageDialog(null, "Quantity  cannot be  negative");
										}
										else
										{
											other.get(k).remove();
											lblAdd.setText(other.get(k).toString());
										}
									}
								}
							}
					
						});
				add(minus, gbc);
				gbc.gridx++;
				JButton edit = new JButton("Edit");
				edit.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent arg0) 
							{
								for(int k = 0; k < other.size(); k++)
								{
									if(other.get(k).toString().equals(lblAdd.getText()))
									{
										EditPanel addPanel = new EditPanel(other.get(k), frame, nTP, lP, other);
										frame.change(addPanel, "Edit Panel");
										return;
									}
								}
								
								
							}
					
						});
				add(edit, gbc);
				
				gbc.gridx++;
				JButton delete = new JButton("Delete");
				delete.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent e) 
							{
								for(int k = 0; k < other.size(); k++)
								{
									if(other.get(k).toString().equals(lblAdd.getText()))
									{
										other.remove(k);
										remove(plus);
										remove(minus);
										remove(lblAdd);
										remove(edit);
										remove(delete);
										nTP.update();
										lP.update();
									}
								}
								
								 int here = 0;
								for(int k = 0; k < other.size(); k++)
								{
									if(other.get(k).getType().equals(type))
									{
										here++;
									}
								}
								
								if(here == 0)
								{
									//frame.change(lP, "ListPanel");
									frame.change("List");
								}
								
								
							}
					
						});
				add(delete, gbc);
				
				gbc.gridx = 0;
				gbc.gridy++;
			
				
			}
		}
		
		gbc.gridx = 0;
		gbc.gridy++;
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						frame.change("List");
						
					}
			
				});
		add(back,  gbc);
	}
	
	public void update()
	{
		nTP = this;
		

		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		for(int i = 0; i < other.size(); i++)
		{
			if(other.get(i).getType().equals(type))
			{
				JLabel lblAdd = new JLabel(other.get(i).toString());
				add(lblAdd, gbc);
				//add quantity button
				gbc.gridx++;
				JButton plus = new JButton("+");
				plus.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent arg0) 
							{
								for(int k = 0; k < other.size(); k++)
								{
									if(other.get(k).toString().equals(lblAdd.getText()))
									{
										other.get(k).add();
										lblAdd.setText(other.get(k).toString());
									}
								}
							}
					
						});
				add(plus, gbc);
				gbc.gridx++;
				JButton minus = new JButton("-");
				minus.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent arg0) 
							{
								for(int k = 0; k < other.size(); k++)
								{
									if(other.get(k).toString().equals(lblAdd.getText()))
									{
										if(other.get(k).getQuantity() <= 0)
										{
											JOptionPane.showMessageDialog(null, "Quantity  cannot be  negative");
										}
										else
										{
											other.get(k).remove();
											lblAdd.setText(other.get(k).toString());
										}
									}
								}
							}
					
						});
				add(minus, gbc);
				gbc.gridx++;
				JButton edit = new JButton("Edit");
				edit.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent arg0) 
							{
								for(int k = 0; k < other.size(); k++)
								{
									if(other.get(k).toString().equals(lblAdd.getText()))
									{
										EditPanel addPanel = new EditPanel(other.get(k), frame, nTP, lP, other);
										frame.change(addPanel, "Edit Panel");
										return;
									}
								}
								
								
							}
					
						});
				add(edit, gbc);
				
				gbc.gridx++;
				JButton delete = new JButton("Delete");
				delete.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent e) 
							{
								for(int k = 0; k < other.size(); k++)
								{
									if(other.get(k).toString().equals(lblAdd.getText()))
									{
										other.remove(k);
										lP.update();
									}
								}
								
								int here = 0;
								for(int k = 0; k < other.size(); k++)
								{
									if(other.get(k).getType().equals(type))
									{
										here++;
									}
								}
								
								if(here == 0)
								{
									frame.change("List");
								}
								
								
							}
					
						});
				add(delete, gbc);
				
				gbc.gridx = 0;
				gbc.gridy++;
			
				
			}
		}
	}
	
	
}

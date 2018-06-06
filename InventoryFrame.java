import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class InventoryFrame extends JFrame
{
	JPanel overall;
	CardLayout cl;
	ArrayList<Item> inventory;
	InventoryFrame here;
	public InventoryFrame()
	{
		here = this;
		setTitle("SyMec Inventory");
		cl = new CardLayout();
		overall = new JPanel();
		overall.setLayout(cl);
		
		inventory = new ArrayList<>();
		
		
		InputStream istream;
		StringBuilder builder = new StringBuilder();
		int c;
		final int EOF = -1;
		
		try {
			File inputFile = new File("DataFile1");
			istream = new FileInputStream(inputFile);
			try {
				while ((c = istream.read()) != EOF)
					builder.append((char)c);
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} finally {
				try {
					istream.close();
				} catch (IOException e) {
					System.out.println("File did not close");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] words = builder.toString().split("\n");
		for(int i = 0; i < words.length && !words[0].equals(""); i+= 6)
		{
			String[] info = new String[6];
			for(int k = i; k < i + 6; k++)
			{
				info[k-i]= words[k];
			}
			Item add = new Item(Integer.parseInt(info[0]), Double.parseDouble(info[3]), info[1], Integer.parseInt(info[5]), info[2], info[4]);
			inventory.add(add);
		}
		
		JMenuBar menu = new JMenuBar();
		JMenuItem home = new JMenuItem("Home");
		JMenuItem add = new JMenuItem("Add Item");
		JMenu calculate = new JMenu("Calculate");
		JMenuItem list = new JMenuItem("Inventory List");
		
		
		JMenuItem totalValue = new JMenuItem("Total Value");
		JMenuItem needStock = new JMenuItem("Items to Restock");
		
		calculate.add(totalValue);
		calculate.add(needStock);
		
		menu.add(home);
		menu.add(add);
		menu.add(list);
		menu.add(calculate);
		
		setJMenuBar(menu);
		
		AddPanel addPanel = new AddPanel(inventory);
		HomePanel homePanel = new HomePanel();
		ListPanel listPanel = new ListPanel(inventory, this);
		NeedStockPanel needPanel = new NeedStockPanel(inventory);
		TotalValueSpendPanel totalPanel = new TotalValueSpendPanel(inventory);
		
		overall.add(addPanel,"Add");
		overall.add(homePanel, "Home");
		overall.add(listPanel, "List");
		overall.add(needPanel, "Need");
		overall.add(totalPanel, "Total");
		
		cl.show(overall, "Home");
		add(overall);
		setBounds(400, 300, 600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		add.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						cl.show(overall, "Add");
					}
			
				});
		
		home.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "Home");
			}
	
		});
		
		list.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				listPanel.update();
				cl.show(overall, "List");
				
			}
	
		});
		
		needStock.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "Need");
			}
	
		});
		
		totalValue.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "Total");
			}
	
		});
		
		int delay = 1000; //milliseconds
		  ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		          here.save();
		      }
		  };
		  new javax.swing.Timer(delay, taskPerformer).start();
		
	}
	
	public static void main(String[] args) 
	{
		new InventoryFrame();
	}
	
	public void change(JPanel change, String name)
	{
		overall.add(change, name);
		cl.show(overall, name);
	}
	
	public void change(String name)
	{
		cl.show(overall, name);
	}
	
	public void save()
	{
		FileWriter outFile = null;
		try {
			outFile = new FileWriter("DataFile1");
		} catch (IOException e1) {
			// TODO Auto-generated catch blocks
			e1.printStackTrace();
		}
		BufferedWriter outStream = new BufferedWriter(outFile);
		for(int i = 0; i < inventory.size(); i++)
		{
			try {
				outStream.write(inventory.get(i).toStupidString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{
			outStream.flush();
			outFile.flush();
			outStream.close();
			outFile.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}

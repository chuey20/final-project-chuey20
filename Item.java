
public class Item 
{
	private int itemNum;
	private double price;
	private String type;
	private int quantity;
	private String name;
	private String location;
	
	public Item(int i, double p, String t, int q, String n, String l)
	{
		itemNum = i;
		price = p;
		type = t;
		quantity = q;
		name = n;
		location = l;
	}
	
	public int getNum()
	{
		return itemNum;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public String locate()
	{
		return location;
	}
	
	public boolean equals(Item other)
	{
		if(itemNum == other.getNum() && price == other.getPrice() && type.equals(other.getType()) && name.equals(other.getName()) && location.equals(other.locate()))
		{
			return true;
		}
		return false;
	}
	
	public void add()
	{
		quantity++;
	}
	
	public void remove()
	{
		quantity--;
	}
	
	public void setNum(int n)
	{
		itemNum = n;
	}
	
	public void setPrice(double p)
	{
		price = p;
	}
	
	public void setType(String t)
	{
		type = t;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setLocation(String l)
	{
		location = l;
	}
	
	public String toString()
	{
		return ""+type+", #"+itemNum+", "+name+", $"+price+", "+location+", "+quantity+" ";
	}
	
	public String toStupidString()
	{
		return ""+itemNum+"\n"+type+"\n"+name+"\n"+price+"\n"+location+"\n"+quantity+"\n";
	}
	
	public static Item fromStupidString(String stuff)
	{
		String[] info = new String[6];
		for(int i = 0; i < 6; i++)
		{
			info[i] = stuff.substring(0, stuff.indexOf("/n"));
			stuff = stuff.substring(stuff.indexOf("/n")+1);
		} 
		
		Item add = new Item(Integer.parseInt(info[0]), Double.parseDouble(info[1]), info[2], Integer.parseInt(info[3]), info[4], info[5]);
		return add;
	}
		
}


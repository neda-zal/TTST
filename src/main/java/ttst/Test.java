package ttst;

import java.util.ArrayList;

public class Test 
{
	private String username,password,description,added;
	private int categoryId; 
	private double minPrice,maxPrice;
	private long startDate, endDate;
	private ArrayList<Item> ownedItems;
	private ArrayList<Auction> followedAuctions;
	
	public String searchAuction()
	{
		User user = new User(username, password);
		ArrayList<Auction> auction = new ArrayList<>();
		
		try 
		{
			auction.addAll(user.searchAuction(categoryId, description, minPrice, maxPrice, startDate,endDate));
		}
		catch(Exception e)
		{
			added = "Error";
			return added;
		}
		added = "Added";
		return added;
	}
	
	public void setUsername(String username)
	{
		 this.username= username;
	}
	public String getUsername()
	{
		return username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return password;
	}
	
	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}
	public int getCategoryId()
	{
		return categoryId;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getDescription()
	{
		return description;
	}
	
	public void setMinPrice(double minPrice)
	{
		this.minPrice = minPrice;
	}
	public double getMinPrice()
	{
		return minPrice;
	}
	
	public void setMaxPrice(double maxPrice)
	{
		this.maxPrice = maxPrice;
	}
	public double getMaxPrice()
	{
		return maxPrice;
	}
	
	public void setStartDate(long startDate)
	{
		this.startDate = startDate;
	}
	public long getStartDate()
	{
		return startDate;
	}
	
	public void setEndDate(long endDate)
	{
		this.endDate = endDate;
	}
	public long getEndDate()
	{
		return endDate;
	}
	
	public ArrayList<Item> getOwnedItems() 
	{
		return ownedItems;
	}
	public void setOwnedItems(ArrayList<Item> ownedItems) 
	{
		this.ownedItems = ownedItems;
	}
	
	public void setFollowedAuctions(ArrayList<Auction> followedAuctions) 
	{
		this.followedAuctions = followedAuctions;
	}
	public ArrayList<Auction> getFollowedAuctions() 
	{
		return followedAuctions;
	}
}

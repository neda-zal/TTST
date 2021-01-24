package fitnesse;
import ttst.Seller;

public class CreateAuctionFixture 
{
	private String username,password;
	public double startPrice;
	public long itemId,startTime,endTime;
	
	public boolean createAuction()
	{
		Seller seller = new Seller(username, password);
		
		try
		{
			seller.createAuction(itemId, startPrice, startTime, endTime);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	//--------------------------------------------------
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
	//------------------------------------------------
	public void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}
	public long getStartTime()
	{
		return startTime;
	}
	
	public void setEndTime(long endTime)
	{
		this.endTime = endTime;
	}
	public long getEndTime()
	{
		return endTime;
	}
	
	public void setStartPrice(long startPrice)
	{
		this.startPrice = startPrice;
	}
	public double getStartPrice()
	{
		return startPrice;
	}
	
	public void setItemId(long itemId)
	{
		this.itemId = itemId;
	}
	public long getItemId()
	{
		return itemId;
	}
}

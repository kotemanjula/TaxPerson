package TaxCalc;

public class Item 
{
  Double basePrice;
  ItemType itemType;
  String itemId;
  
  public Item(Double basePrice,ItemType itemType, String itemId )
  {
	  this.basePrice = basePrice;
	  this.itemType = itemType;
	  this.itemId = itemId;
  }
  
  public Double getBasePrice()
  {
	  return this.basePrice;
  }
  
  public ItemType getItemType()
  {
	  return this.itemType;
  }
  
  public String getItemId()
  {
	  return this.itemId;
  }
	
}


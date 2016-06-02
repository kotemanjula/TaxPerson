package TaxCalc;

import java.util.HashMap;

public class TaxCalculator 
{
	/*
	 * Map with key as item's unique id, value as Item object.
	 * This list has all the items available
	 */
  HashMap<String,Item> items = new HashMap<String,Item>();
  
  public TaxCalculator(HashMap<String,Item> items)
  {
	  this.items = items;
  }
  
  public Double getItemTotalCost(String itemId) throws Exception
  {
	  Double totalCost = 0.0;
	  
	  if(itemId != null && !itemId.isEmpty() && items.containsKey(itemId))
	  {
		  Item item = items.get(itemId);
		  
		  if(item.itemType == ItemType.BASIC)
		  {
			  totalCost = item.basePrice + (0.01 * item.basePrice);
		  }
		  else if(item.itemType == ItemType.LUXURY)
		  {
			  totalCost = item.basePrice + (0.09 * item.basePrice);
		  }
		  else
		  {
			  throw new Exception("Item Type Invalid");  
		  }
	  }
	  if(itemId != null & !items.containsKey(itemId))
	  {
		  throw new Exception("Item Price Not Available");
	  }
	  
	  return totalCost;
  }
	
}

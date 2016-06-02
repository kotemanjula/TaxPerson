package test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TaxCalc.Item;
import TaxCalc.ItemType;
import TaxCalc.TaxCalculator;

public class TaxCalcTest {
  
	TaxCalculator taxCal = null;
	
 @BeforeTest
  public void init()
  {
	 HashMap<String,Item> itemMap = new HashMap<String, Item>();
	 
	 Item item1 = new Item(100.0, ItemType.BASIC,"1");
	 Item item2 = new Item(200.0, ItemType.LUXURY,"2");
	 Item item3 = new Item(300.0, null,"3");
	 
	 itemMap.put("1", item1);
	 itemMap.put("2", item2);
	 itemMap.put("3", item3);
	 
	 taxCal = new TaxCalculator(itemMap);
	 
  }
	
	
  @Test
  public void testCalcBasic() 
  {
	  try
	  {
		  Double totalCost = taxCal.getItemTotalCost("1");
		  Assert.assertEquals(totalCost, 101.0);
	  }
	  catch(Exception e)
	  {
		  
	  }
  }
  
  @Test
  public void testCalc() 
  {
	  try
	  {
		  Double totalCost = taxCal.getItemTotalCost("2");
		  Assert.assertEquals(totalCost, 218.0);
	  }
	  catch(Exception e)
	  {
		  
	  }
  }
  
  @Test
  public void testCalcItemNotFound() 
  {
	  String excMsg = "";
	  try
	  {
		  Double totalCost = taxCal.getItemTotalCost("5");
	  }
	  catch(Exception e)
	  {
		  excMsg = e.getMessage();
	  }
	  Assert.assertEquals(excMsg, "Item Price Not Available");
  }
  
  @Test
  public void testCalcItemTypeNotFound() 
  {
	  String excMsg = "";
	  try
	  {
		  Double totalCost = taxCal.getItemTotalCost("3");
	  }
	  catch(Exception e)
	  {
		  excMsg = e.getMessage();
	  }
	  Assert.assertEquals(excMsg, "Item Type Invalid");
  }
}

package dataObjects;

import org.junit.Assert;
import org.junit.Test;

public class EntryDataTest {
	
	String income= new String("Income"); //Correct way of writing
	String income2 = new String("income"); //Incorrect
	
	String expense= new String("Expense"); //Correct way of writing
	String expense2 = new String("expense"); //Incorrect
	
	String category = new String("Food"); //Correct way of writing
	String category1 = new String("food"); //Incorrect
	
	EntryData data = new EntryData("User_wallet.txt"); //Filled file
	EntryData emptydata = new EntryData("Amani_wallet.txt"); //Empty file
	EntryData unusualData = new EntryData("users.txt"); //Wrong file
	
	//testing calculateTotalIncome
	@Test
	public void calculateTotalIncome() {
		Assert.assertEquals(383000.0,data.calculateTotal(income),0);
		Assert.assertEquals(0.0,emptydata.calculateTotal(income),0);
	}
	
	@Test
	public void calculateTotalExpenses() {
		Assert.assertEquals(590000.0,data.calculateTotal(expense),0);
		Assert.assertEquals(0.0,emptydata.calculateTotal(income),0);
	}
	
	@Test
	public void calculateTotalErrors() {
		Assert.assertEquals(0.0,data.calculateTotal(income2),0);
		Assert.assertEquals(0.0,data.calculateTotal(expense2),0);
		Assert.assertEquals(0.0,emptydata.calculateTotal(income2),0);
		Assert.assertEquals(0.0,emptydata.calculateTotal(expense2),0);
		Assert.assertEquals(0.0,unusualData.calculateTotal(income),0);
		Assert.assertEquals(0.0,unusualData.calculateTotal(expense),0);
	}
	
	//testing calculateTotalInCategory
	@Test
	public void calculateTotalInCategory_Income() {
		Assert.assertEquals(0.0,data.calculateTotalInCategory(income,category),0);
		Assert.assertEquals(0.0,emptydata.calculateTotalInCategory(income,category),0);
	}
	
	@Test
	public void calculateTotalInCategory_Expense() {
		Assert.assertEquals(7000.0,data.calculateTotalInCategory(expense,category),0);
		Assert.assertEquals(0.0,emptydata.calculateTotalInCategory(expense,category),0);
	}
	
	@Test
	public void calculateTotalInCategory_Errors() {
		//test on actual data
		Assert.assertEquals(0.0,data.calculateTotalInCategory(income2,category),0);
		Assert.assertEquals(0.0,data.calculateTotalInCategory(income,category1),0);
		Assert.assertEquals(0.0,data.calculateTotalInCategory(income2,category1),0);
		//test on empty data
		Assert.assertEquals(0.0,emptydata.calculateTotalInCategory(income2,category),0);
		Assert.assertEquals(0.0,emptydata.calculateTotalInCategory(income,category1),0);
		Assert.assertEquals(0.0,emptydata.calculateTotalInCategory(income2,category1),0);
		//test on unusual data
		Assert.assertEquals(0.0,unusualData.calculateTotalInCategory(income2,category),0);
		Assert.assertEquals(0.0,unusualData.calculateTotalInCategory(income,category1),0);
		Assert.assertEquals(0.0,unusualData.calculateTotalInCategory(income2,category1),0);
	}
}
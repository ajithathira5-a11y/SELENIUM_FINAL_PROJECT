package com.indusvalley.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.indusvalley.base.IndusValleyBase;

public class IndusValleyCartTest extends IndusValleyBase {
	
	@Test(priority = 14)
	public void cartIconClickVerify()
	{
		ca.cartIconClick();
		Reporter.log("Cart Icon clicked successfully");

	}
	
	@Test(priority = 15)
	public void myCartTextCheckVerify()
	{
		String text = ca.myCartTextCheck();
		
		System.out.println("cart texttt ====== "+text);
		
		Assert.assertEquals(text, "MY CART(2)");
		
		Reporter.log("myCart Text Verified successfully");

	}
	
	@Test(priority = 16)
	public void incrementButtonClickVerify()
	{
		ca.incrementButtonClick();
		
		Reporter.log("Increment Button Clicked successfully");

	}
	
	
	@Test(priority = 18)
	public void deleteButtonClickVerify()
	{
		ca.deleteButtonClick();
		Reporter.log("Delete Button Clicked successfully");

	}
	
	
	@Test(priority = 17)
	public void decrementButtonClickVerify()
	{
		ca.decrementButtonClick();
		Reporter.log("Decrement Button Clicked successfully");

	}
	
		
	@Test(priority = 19)
	public void checkOutClickVerify()
	{
		ca.checkOutClick();
		Reporter.log("CheckOut Clicked successfully");

		
	}
	
	@Test(priority = 20)
	public void cashDeliveryClickVerify()
	{
		ca.cashDeliveryClick();
		Reporter.log("Cash Delivery Clicked successfully");

	}
	

}

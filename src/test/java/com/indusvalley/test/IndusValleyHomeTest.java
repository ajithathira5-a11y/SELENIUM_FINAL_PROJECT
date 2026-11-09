package com.indusvalley.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.indusvalley.base.IndusValleyBase;

//<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">


public class IndusValleyHomeTest extends IndusValleyBase {
	

	@Test(priority = 0)
	public void countLink()
	{
		int count = ho.linkCount();  //expected 705
		System.out.println("actual link count = "+count);
		Assert.assertEquals(count, 719);
		Reporter.log("Link count fetched successfully");

	}
	
	@Test(priority = 1)
	public void homeTitleVerify()
	{
		String actual_title = ho.homeTitle();
		System.out.println("actual home title =  "+actual_title);

		Assert.assertEquals("The Indus Valley - 100% Healthy Cookware | Toxin-free",actual_title);
		Reporter.log("Home title verified successfully");

	}
	
	@Test (priority = 2)				//scroll if needed
	public void castIronButtonTextVerify()
	{
		String actualTxt = ho.castIronButtonText();
		System.out.println("cast iron actual title =  "+actualTxt);

		
		Assert.assertEquals("Cast Iron", actualTxt);
		
		Reporter.log("castIron ButtonText verified successfully");

	}
	
	@Test(priority = 3)
	public void castIronButtonclickVerify()
	{
		ho.castIronButtonclick();
		
		Reporter.log("castIron Button clicked successfully");

	}
	
	
	@Test(priority = 4)
	public void searchItems()
	{
		
		ho.search("castiron");   //data driven aak
		
		Reporter.log("Item searched successfully");

	}
	
	@Test(priority = 5)
	public void productsTextVerify()
	{
		String actual_Text = ho.productsText();
		System.out.println("actual product text  = "+actual_Text);
		
		Assert.assertEquals("Products", actual_Text);
		
		Reporter.log("products Text Verified successfully");

	}
	
	@Test(priority = 6)
	public void addButtonTextVerify()
	{
		String button_text = ho.addButtonText();
		System.out.println("actual add button  text  = "+button_text);
		
		Assert.assertEquals("Add +", button_text);
		Reporter.log("Add+ Button Text Verified successfully");

		
	}
	
	@Test(priority = 7)
	public void addButtonClickVerify()
	{
		ho.addButtonClick();
		Reporter.log("Add+ Button clicked successfully");

	}
	
	@Test(priority = 8)
	public void cartPopUpCloseVerify()
	{
//		ho.cartPopUpClose();
		System.out.println("cart popoup closee=====");
		Reporter.log("CartPopUp Close Verified successfully");


	}
	
	@Test(priority = 9)
	public void imageClickVerify()
	{
		ho.imageClick();
		Reporter.log("image click Verified successfully");

	}
	
	@Test(priority = 10)
	public void addToCartButtonTextVerify()
	{
		String text = ho.addToCartButtonText();
		System.out.println("add to cart  text  = "+text);
		Assert.assertEquals("Add To Cart", text);
		
		Reporter.log("Add To Cart Button Text Verified successfully");

	}
	
	@Test(priority = 11)
	public void addToCartButtonClick()
	{
		ho.addToCartButtonClick();
		Reporter.log("Add To Cart clicked successfully");

		
//		ho.cartPopUpClose();
		
	}
	
	@Test(priority = 12)
	public void filterVerify()
	{
		ho.navigateBack();
		ho.filter(2);   // data driven
		ho.refreshpage();
		
		Reporter.log("Add To Cart clicked successfully");

	}
	
	@Test(dataProvider = "SearchItems", priority = 13)
	public void randomSearch(String searchKeys)
	{
		ho.searchRandom(searchKeys);
	}
	

}

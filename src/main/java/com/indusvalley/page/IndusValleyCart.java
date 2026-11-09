package com.indusvalley.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IndusValleyCart {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//*[contains(@class,'icon-cart')]")
	WebElement cartIcon;
	
//	@FindBy(xpath= "//*[@id=\"wd_gk_ckt_btn\"]")
//	WebElement checkOut;
	
//	@FindBy(xpath = "/html/body/div/div/div[1]/div[2]/div/div[2]/div/button[4]")
//	WebElement cashDelivery;
	
//	@FindBy(xpath= "//*[@id=\"CartDrawer-Item-1\"]/div[2]/div[4]/div/quantity-popover/div[1]/div/quantity-input/button[2]")
//	WebElement incrementButton;
	
	
//	@FindBy(xpath= "//*[@id=\"CartDrawer-Item-1\"]/div[2]/div[4]/div/quantity-popover/div[1]/div/quantity-input/button[1]")
//	WebElement decrementButton;
//	
//	@FindBy(id= "CartDrawer-Remove-2")
//	WebElement deleteButton;
	
//	
//	@FindBy(xpath = "//*[@id=\"gokwik-iframe\"]")
//	WebElement iframeDel;
	
	@FindBy(xpath = "//*[@id=\"CartDrawer\"]/div[2]/div[2]/h2")
	WebElement myCartText;
	
	By incrementButton = By.xpath("//*[@id='CartDrawer-Item-1']//quantity-input/button[@name='plus']");
	
	By decrementButton = By.xpath("//*[@id='CartDrawer-Item-1']//quantity-input/button[@name='minus']");

	By deleteButton = By.id("CartDrawer-Remove-2");
		
	By iframeDel = By.id("gokwik-iframe");
	
	By cartNum = By.xpath("//*[@id=\"Drawer-quantity-1\"]");
	
	By checkOut = By.id("wd_gk_ckt_btn");
	
	
	public IndusValleyCart(WebDriver driver,WebDriverWait wait)
	{
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	public void cartIconClick()
	{
		cartIcon.click();
	}
	
	public String myCartTextCheck()
	{
		return myCartText.getText();
	}
	
	public void incrementButtonClick()
	{
		
		WebElement inquantity = wait.until(ExpectedConditions.visibilityOfElementLocated(cartNum));

		String oldValue = inquantity.getAttribute("value");

		WebElement incbutton = wait.until(ExpectedConditions.elementToBeClickable(incrementButton));

		incbutton.click();
		
		int quantity = Integer.parseInt(oldValue);
		quantity++;

		String newValue = String.valueOf(quantity);
		
		wait.until(ExpectedConditions.attributeToBe(cartNum,"value",newValue));		

		
//		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(cartNum,"value",oldValue)));		

	}
	

	public void decrementButtonClick()
	{
		
//		WebElement decbutton = wait.until(ExpectedConditions.elementToBeClickable(decrementButton));
		
		WebElement decquantity = wait.until(ExpectedConditions.visibilityOfElementLocated(cartNum));
		
		String oldValue = decquantity.getAttribute("value");
		
		System.out.println("Decrement: old value = " + oldValue);
		 
		WebElement decbutton = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(decrementButton)));
		
		decbutton.click();
		
		int quantity = Integer.parseInt(oldValue);
		quantity--;

		String newValue = String.valueOf(quantity);
		
		wait.until(ExpectedConditions.attributeToBe(cartNum,"value",newValue));	
		
		System.out.println("Decrement: new value = " + newValue);

		
//		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(cartNum,"value",oldValue)));	
		
		wait.until(ExpectedConditions.elementToBeClickable(checkOut));

		
	}
	
	public void deleteButtonClick()
	{
		
//		WebElement delbutton = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
	    WebElement delbutton = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(deleteButton)));

		delbutton.click();
		
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteButton));
	    
	    
	    // Re-locate quantity element after cart re-render
	    WebElement quantity = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(cartNum)
	    );

	    String currentValue = quantity.getAttribute("value");

	    System.out.println("Quantity after delete = " + currentValue);

	}
	
	public void checkOutClick()
	{
		
		WebElement checkButton = wait.until(ExpectedConditions.elementToBeClickable(checkOut));

		
		JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript( "arguments[0].scrollIntoView({block:'center'});",checkButton );
	       
		wait.until(ExpectedConditions.elementToBeClickable(checkOut));
		
		checkButton.click();
	}
	
	public void cashDeliveryClick()
	{
//		driver.switchTo().frame(iframeDel);
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//	    js.executeScript( "arguments[0].scrollIntoView({block:'center'});",cashDelivery );
//	       
//		wait.until(ExpectedConditions.elementToBeClickable(cashDelivery));
//		
//		cashDelivery.click();
//		driver.switchTo().defaultContent();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeDel));

		System.out.println("GoKwik iframe loaded");

		By cashDelivery = By.cssSelector("[data-testid='payment-method-cod']");

		WebElement cashButton = wait.until(ExpectedConditions.elementToBeClickable(cashDelivery));

//		cashButton.click();
		
		cashButton.getText();

		System.out.println("order will placed if clicked on cash on delivery");

		driver.switchTo().defaultContent();

	}
	
	
	
	

}

package com.indusvalley.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.indusvalley.base.IndusValleyBase;


public class IndusValleyHome {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(tagName = "a")
	List<WebElement> linkList;
	
	@FindBy(xpath = "//*[@id=\"st-search\"]")
	WebElement searchBar;
	
	@FindBy(xpath = "//*[@id=\"st-main-content\"]/div[1]/div[1]")
	WebElement productsButtonText;
	
	@FindBy(xpath = "//*[@id=\"collection-template--20386411544753__quinn_tab_widget_JQWKHh\"]/div[2]/div[1]/div/div/div[1]")
	WebElement castIronButon;
	
	@FindBy(xpath = "//*[@id=\"st-results-list\"]/div/div[1]/div/div/div[6]/div/div/button")
	WebElement addButton;
	
	@FindBy(xpath = "/div[@id='CartDrawer']//button[@aria-label='Close']")
	WebElement cartPopupClose;
	
	@FindBy(xpath = "//*[@id=\"st-results-list\"]/div/div[2]/div/div/div[1]/a/span")
	WebElement image;
	
	@FindBy(xpath = "//*[@id=\"ProductSubmitButton-template--20386412495025__main\"]")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//*[@id=\"st-sort\"]/select")
	WebElement filterButton;
	

	
	

	
	public IndusValleyHome(WebDriver driver, WebDriverWait wait)
	{
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	
	public int linkCount()
	{
		return linkList.size();
	}
	
	public String homeTitle()
	{
		return driver.getTitle();
	}
	
	public void castIronButtonclick()
	{ 
		JavascriptExecutor js = (JavascriptExecutor) driver;

       js.executeScript( "arguments[0].scrollIntoView({block:'center'});",castIronButon );
       
     
		wait.until(ExpectedConditions.elementToBeClickable(castIronButon));
    
		System.out.println("castIronButtonclick ===");
		
		castIronButon.click();
	}
	
	public String castIronButtonText()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

	       js.executeScript( "arguments[0].scrollIntoView({block:'center'});",castIronButon );
		return castIronButon.getText();
	}
	
	
	public void search(String searchItem)
	{
     
		System.out.println("searching items=======");
		
		  searchBar.click();
		    searchBar.clear();

		    searchBar.sendKeys(searchItem);

		    searchBar.sendKeys(Keys.RETURN);
	}
	
	public void searchRandom(String key)
	{
		searchBar.click();
	    searchBar.clear();

	    searchBar.sendKeys(key);

	    searchBar.sendKeys(Keys.RETURN);
	}
	
	public String productsText()
	{
		return productsButtonText.getText();
	}
	
	public String addButtonText()
	{
	    wait.until(ExpectedConditions.visibilityOf(addButton));
 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript( "arguments[0].scrollIntoView({block:'center'});",addButton );
		
		return addButton.getText();
	}
	
	public void addButtonClick()
	{
		System.out.println("add button clickk=======");
	    wait.until(ExpectedConditions.visibilityOf(addButton));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript( "arguments[0].scrollIntoView({block:'center'});",addButton );
		
		wait.until(ExpectedConditions.elementToBeClickable(addButton));

		addButton.click();
	}
	
	public void cartPopUpClose()
	{
		System.out.println("cart popoup closee=====");
//		cartPopupClose.click();

	}
	
	public void imageClick()
	{
		System.out.println("image  clickkk====");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript( "arguments[0].scrollIntoView({block:'center'});",image );
		
		wait.until(ExpectedConditions.elementToBeClickable(image));


		image.click();
	}
	
	public String addToCartButtonText()
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript( "arguments[0].scrollIntoView({block:'center'});",addToCartButton );
		
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		
		return addToCartButton.getText();
	}
	
	public void addToCartButtonClick()
	{
		System.out.println("add to cart  clickk===");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
			
		js.executeScript( "arguments[0].scrollIntoView({block:'center'});",addToCartButton );
			
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

		addToCartButton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

	}
	
	public void filter(int filterIndex)
	{
		System.out.println("filter========");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript( "arguments[0].scrollIntoView({block:'center'});",filterButton );
			
		wait.until(ExpectedConditions.visibilityOf(filterButton));
		wait.until(ExpectedConditions.elementToBeClickable(filterButton));


		Select sel = new Select(filterButton);
		sel.selectByIndex(filterIndex);
	}
	
	public void navigateBack()
	{
		driver.navigate().back();
	}
	
	public void refreshpage()
	{
		driver.navigate().refresh();
	}
	

}

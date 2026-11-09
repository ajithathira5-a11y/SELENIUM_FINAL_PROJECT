package com.indusvalley.page;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndusValleyLogin {
	
	WebDriver driver;
	
	WebDriverWait wait;

	@FindBy(xpath = "//*[@id=\"svgkp\"]")
	WebElement profile;
	
	@FindBy(id = "phone-input")
	WebElement phoneNum;

	@FindBy(xpath = "//*[@id=\"input-0\"]")
	WebElement otpField;
	
	@FindBy(xpath = "//*[@id=\"iframe-kp\"]")
	WebElement iframePhone;
	
	@FindBy(xpath = "//*[@id=\"iframe-kp\"]")
	WebElement iframeOtp;
	
	@FindBy(css = "input.ap-otp-input")
	List<WebElement> otpFieldsList;
	
	@FindBy(xpath = "//*[@id=\"collection-template--20386411544753__quinn_tab_widget_JQWKHh\"]/div[2]/div[1]/div/div/div[1]")
	WebElement castIron;
	
	
	public IndusValleyLogin(WebDriver driver, WebDriverWait wait)
	{
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	public void sendNum()
	{
		    wait.until(ExpectedConditions.elementToBeClickable(profile));
		    profile.click();

		    System.out.println("---------Profile clicked");
		    
			driver.switchTo().frame(iframePhone);


		  WebElement ph =   wait.until(ExpectedConditions.visibilityOf(phoneNum));

		    System.out.println("----------Phone field visible");

		    ph.click();
		    ph.clear();
		    ph.sendKeys("9526394115");
		    
			driver.switchTo().defaultContent();


		    System.out.println("------------Phone number entered: ");
	    
	}
	
	public void otpSend()
	{
		
		driver.switchTo().frame(iframeOtp);

		Scanner scanner = new Scanner(System.in);

	    System.out.print("===== Enter OTP: ");

	    String otp = scanner.nextLine();

	    List<WebElement> fields = wait.until(ExpectedConditions.visibilityOfAllElements(otpFieldsList));

	    System.out.println("OTP fields found: " + fields.size());

	    for (int i = 0; i < otp.length() && i < fields.size(); i++)
	    {
	        fields.get(i).sendKeys(String.valueOf(otp.charAt(i)));
	    }

	    System.out.println("OTP entered into browser");
		
		driver.switchTo().defaultContent();
		
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("iframe-kp")));
		  
		  JavascriptExecutor js = (JavascriptExecutor) driver;

	       js.executeScript( "arguments[0].scrollIntoView({block:'center'});",castIron);
	       
	     
			wait.until(ExpectedConditions.elementToBeClickable(castIron));

	}

}

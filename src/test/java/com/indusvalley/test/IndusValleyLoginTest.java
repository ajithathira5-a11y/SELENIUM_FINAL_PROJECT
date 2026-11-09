package com.indusvalley.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.indusvalley.base.IndusValleyBase;

public class IndusValleyLoginTest extends IndusValleyBase{
	
	@Test(priority = -1)
	public void phoneNumSend()
	{
		lo.sendNum();
		Reporter.log("Phone number send successfully");

	}
	
	@Test(priority = -2,  dependsOnMethods = "phoneNumSend")
	public void otpVerify()
	{
		lo.otpSend();
		Reporter.log("OTP verified successfully");

	}

}

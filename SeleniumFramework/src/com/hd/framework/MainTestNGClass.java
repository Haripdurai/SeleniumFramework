package com.hd.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class MainTestNGClass extends WrapperMethods{
	 
	 //Declare browser
	 public WebDriver driver;
	 
	 String PptyVal;
	
	 
	 @BeforeTest
	  public void beforeTest() throws IOException, BiffException {
		 
		//Create a object for the MainTestNGClass class to access the methods of WrapperMethods class
		 MainTestNGClass m = new MainTestNGClass();
		 
		 m.InitiateBrowser();	 
		 	 		 
	  }

	
 	 @Test
 	 public void f() throws IOException {
 		
 		//Create a object for the MainTestNGClass class to access the methods of WrapperMethods class
 		 //to be removed or find another alternative as it is repetition in beforeTest() method 
		 MainTestNGClass m = new MainTestNGClass();
		 
		 PptyVal = m.ReadPptyFileUtils("username");
		 
		 driver.findElement(By.name("uid")).sendKeys(PptyVal);
		 
		 PptyVal = m.ReadPptyFileUtils("password");
		 
		 driver.findElement(By.name("uid")).sendKeys(PptyVal);
 		
 	 
 	 }
 
 	 @AfterTest
 	 public void afterTest() {
 		 
 		 driver.quit();
 		 
 
 	 }

}
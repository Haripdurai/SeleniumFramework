package com.hd.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WrapperMethods {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	
	public String ReadPptyFileUtils(String PptyName) throws IOException{
		
		//Read properties file in Java
		Properties prop = new Properties();
							
		//System.getProperty("user.dir") to get the current java project directory path
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Utils.properties");
					
		prop.load(ip);
		
		String PptyName1 = prop.getProperty(PptyName);
		
		return PptyName1;
	}
	
	public String readExcel(int col, int row) throws IOException, BiffException{
		
		String TestController_Path = ReadPptyFileUtils("TestController_Path");
		
		System.out.println(TestController_Path);
		
		Workbook wk = Workbook.getWorkbook(new File(TestController_Path));
		Sheet sh = wk.getSheet(0);
		String val = sh.getCell(col,row).getContents();
		
		return val;
		
	}
	
	public WebDriver InitiateBrowser() throws BiffException, IOException{
		
		String val = readExcel(3,1);
		WebDriver driver = null;
		
		if ("Firefox".equals(val)){
			
			driver = new FirefoxDriver();
			
		}if ("chrome".equals(val)){
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\99JarFiles\\chromedriver.exe");
			driver=new ChromeDriver();		
						
		}if("IE".equals(val)){
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\99JarFiles\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
		}
		
		
		
		String URL = ReadPptyFileUtils("URL");
		
		driver.get(URL);
				
		return driver;
		
	}
	
	
	
	/*public boolean sendval(String loc, String locnam, String value){
		
		//finding the web element from findele method
		WebElement ele=findele(driver, loc,locnam);
		ele.clear();
		//entering the value to the text box
		ele.sendKeys(value);
		
		
		return false;
	}
	
	//Finding the web element using the Locator and locator name
	public WebElement findele(WebDriver driver, String loc,String locnam){
				try{	
					//Finding the element with ID
					if(loc.equalsIgnoreCase("id")){
						return driver.findElement(By.id(locnam));
						}
					//Finding the element with name
					else if(loc.equalsIgnoreCase("name")){
						return driver.findElement(By.name(locnam));
						}
					//Finding the element with class name
					else if(loc.equalsIgnoreCase("className")){
						return driver.findElement(By.className(locnam));
						}
					//Finding the element with Link text
					else if(loc.equalsIgnoreCase("linkText")){
						
						return driver.findElement(By.linkText(locnam));
						}
					//Finding the element with Partial Link Text
					else if(loc.equalsIgnoreCase("partialLinkText")){
						return driver.findElement(By.partialLinkText(locnam));
						}
					//Finding the element with Xpath
					else if(loc.equalsIgnoreCase("xpath")){
						return driver.findElement(By.xpath(locnam));
						}
					//Finding the element with tagname
					else if(loc.equalsIgnoreCase("tagname")){
						return driver.findElement(By.tagName(locnam));
						}
					//Finding the element with CSS selector
					else if(loc.equalsIgnoreCase("css")){
						return driver.findElement(By.cssSelector(locnam));
						}
					
				}catch (NoSuchElementException e) {
						//reportStep(stepNum, "There is no element as: "+obj+" mentioned in this page; Refer Snapshot");
					e.printStackTrace();
						return null;
					} catch(ElementNotVisibleException e){
						//reportStep(stepNum, "The edit field threw an unknown exception; Refer Snapshot");
						e.printStackTrace();
						return null;
						
					}catch(Exception e){
						//reportStep(stepNum, "The edit field threw an unknown exception; Refer Snapshot");
						e.printStackTrace();
						return null;
					}
				return null;				
			}
*/
	

}

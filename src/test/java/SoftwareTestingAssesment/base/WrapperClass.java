package SoftwareTestingAssesment.base;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperClass extends TestBase {

	public void waitTillElementClickable(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	//EnterText
	public void enterText(By element, String str) {
		//this.waitTillElementClickable(element);
		waitForTimeOutInSec(3);
		this.click(element);
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(str);
	}

	//Select From Date
	
	public void selectFromDate(String Frommonth, String Fromdate)
	{
		while(true)
		{
			String Text = driver.findElement(By.xpath("//div[contains(@class,'odf-calendar-title')]")).getText();
			
			if(Text.equals(Frommonth))
			{
				break;
			}else {
				
				driver.findElement(By.xpath("//button//span[contains(@glyph,'arrow-right')]")).click();
			}
		}
		
		//WebElement DateSelect = driver.findElement(By.xpath("//div[contains(@class,'odf-calendar-day')]"));
		List<WebElement> DateSelectList = driver.findElements(By.xpath("//div[contains(@class,'odf-calendar-day')]"));
		//List<WebElement> DateSelectList = DateSelect.findElements(By.tagName("div"));
		int DN=DateSelectList.size();
		
		for(int i=0;i<DN;i++)
		{
			String DateSelectEx = DateSelectList.get(i).getText();
			
			if (DateSelectEx.equals(Fromdate)) {
				DateSelectList.get(i).click();
				break;
			}
		}
	}
	
	//Select To Date
	
		public void selectToDate(String Tomonth, String Todate)
		{
			while(true)
			{
				String Text = driver.findElement(By.xpath("//div[contains(@class,'odf-calendar-title')]")).getText();
				
				if(Text.equals(Tomonth))
				{
					break;
				}else {
					
					driver.findElement(By.xpath("//button//span[contains(@glyph,'arrow-right')]")).click();
				}
			}
			
			//WebElement DateSelect = driver.findElement(By.xpath("//div[contains(@class,'odf-calendar-day')]"));
			List<WebElement> DateSelectList = driver.findElements(By.xpath("//div[contains(@class,'odf-calendar-day')]"));
			//List<WebElement> DateSelectList = DateSelect.findElements(By.tagName("div"));
			int DN=DateSelectList.size();
			
			for(int i=0;i<DN;i++)
			{
				String DateSelectEx = DateSelectList.get(i).getText();
				
				if (DateSelectEx.equals(Todate)) {
					DateSelectList.get(i).click();
					break;
				}
			}
		}
	
	
	public void clickWithJS(By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor jsClick = (JavascriptExecutor) driver;
		jsClick.executeScript("arguments[0].click();", element);
	}

	public void waitForTimeOutInSec(int waitTime) {
		int wait = waitTime * 1000;
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {

			Thread.currentThread().interrupt();
		}
	}

	public void click(By locator) {
		waitForTimeOutInSec(3);
		try {
			driver.findElement(locator).click();
		} catch (NoSuchElementException e) {
			try {
				clickWithJS(locator);
			} catch (Exception e1) {
				WebElement element = driver.findElement(locator);
				Actions actions = new Actions(driver);
				actions.moveToElement(element).click().build().perform();
			}
		}
	}
	
	
	//Select To value from dropdown
	
			
	

}

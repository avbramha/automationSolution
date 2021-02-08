package SoftwareTestingAssesment.TestCases;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import SoftwareTestingAssesment.base.WrapperClass;

public class LoginTest extends WrapperClass {

	@Test
	public void loginDemoSite() throws InterruptedException {
		// driver.findElement(By.cssSelector(OR.getProperty("demologo"))).click();
		// Thread.sleep(5000);

		// int size = driver.findElements(By.tagName("iframe")).size();
		// Thread.sleep(5000);
		driver.switchTo().frame("slave-1-1");
		System.out.println("Switch to frame");
		Thread.sleep(5000);

		// driver.findElement(By.xpath("//td[@class = 'sbi-td']/input")).click();
		driver.findElement(By.xpath("//td[@class = 'sbi-td']/input")).sendKeys("flight");
		Thread.sleep(2000);
		// System.out.println(size);

		driver.findElement(By.xpath("//td[@class = 'sbi-td']//following-sibling::td//input")).click();
		Thread.sleep(2000);

		driver.switchTo().defaultContent();

		driver.switchTo().frame("master-1");
		System.out.println("Switch to frame");
		Thread.sleep(2000);

		//driver.findElement(By.xpath("//span[@class='lc_ si22 ']")).click();
		driver.findElement(By.xpath("//a[contains(@aria-label,'Book Now Flights ')]")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2000);

		// Alert alert = driver.switchTo().alert();
		// Thread.sleep(5000);
		// System.out.println("Switch to Alert");
		// alert.accept();

		driver.findElement(By.xpath("//button[@id='didomi-notice-agree-button']")).click();
		Thread.sleep(5000);
		// driver.switchTo().defaultContent();
		// driver.switchTo().window(tabs2.get(1));

		// Date selection
		driver.findElement(By.xpath("//div[contains(@class,'odf-datepicker')]")).click();
		Thread.sleep(2000);
		
		String Frommonth = "August '21";
		String Fromdate = "1";
		
		String Tomonth = "August '21";
		String ToDate = "7";
		
		selectDate(Frommonth,Fromdate);
		Thread.sleep(2000);
		
		selectDate(Tomonth,ToDate);
		Thread.sleep(2000);
		
		// Service Class selection
		driver.findElement(By.xpath("//div[@class='odf-space-outer-right-m']")).click();
		Thread.sleep(2000);

		WebElement ServiceClass = driver.findElement(By.xpath("//div[@class='odf-space-outer-right-m']//ul"));
		List<WebElement> ServiceClassList = ServiceClass.findElements(By.tagName("li"));
		for (WebElement li : ServiceClassList) {
			if (li.getText().equals("First")) {
				li.click();
			}
		}

		// click on Traveler dropthrough
		// driver.findElement(By.xpath("//div[contains(@class,'odf-input odf-text-lg')]")).click();
		// By element = By.xpath("//div[contains(@class,'odf-input-group focus odf-input-inline-focus')]/input");
		
		By elementFrom = By.xpath("//div[contains(@class,'odf-input-group')]/input[@placeholder='Where from?']");
		By elementTo = By.xpath("//div[@class='odf-input-group']/input");
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(element)));

		enterText(elementFrom, "London");
		Thread.sleep(2000);
		enterText(elementTo, "Paris");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class='odf-input-group']/input")).sendKeys("Paris");
		

		// driver.close();
		// driver.switchTo().window(tabs2.get(0));

	}

}

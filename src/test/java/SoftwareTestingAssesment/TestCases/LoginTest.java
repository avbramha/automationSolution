package SoftwareTestingAssesment.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SoftwareTestingAssesment.base.WrapperClass;

public class LoginTest extends WrapperClass {

	@Test
	public void loginDemoSite() throws InterruptedException, IOException {

		// Launch the URL
		driver.get(config.getProperty("testsiteurl"));
		if (driver.getTitle().equals(config.getProperty("UrlTitle"))) {
			Assert.assertTrue(true);
			logger.info("URL is Launch");
		} else {
			captureScreen(driver, "loginDemoSite");
			Assert.assertTrue(false);
			logger.info("URL is not Launch");

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

		// driver.findElement(By.cssSelector(OR.getProperty("demologo"))).click();
		// Thread.sleep(5000);

		// int size = driver.findElements(By.tagName("iframe")).size();
		// Thread.sleep(5000);
		driver.switchTo().frame("slave-1-1");
		System.out.println("Switch to frame");
		Thread.sleep(5000);

		// driver.findElement(By.xpath("//td[@class = 'sbi-td']/input")).click();
		driver.findElement(By.xpath("//td[@class = 'sbi-td']/input")).sendKeys(config.getProperty("searchPara"));
		logger.info("Value Entered successfully for search functionality");
		Thread.sleep(2000);
		// System.out.println(size);

		driver.findElement(By.xpath("//td[@class = 'sbi-td']//following-sibling::td//input")).click();
		logger.info("Search button click Successfully");
		Thread.sleep(2000);

		driver.switchTo().defaultContent();

		driver.switchTo().frame("master-1");
		System.out.println("Switch to frame");
		Thread.sleep(2000);

		// driver.findElement(By.xpath("//span[@class='lc_ si22 ']")).click();
		driver.findElement(By.xpath("//a[contains(@aria-label,'za.edreams.com')]")).click();
		logger.info("Flight Booking side link click successfully");
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
		logger.info("Aggrement notice Pop-Up has been aggred successfully");
		Thread.sleep(5000);
		// driver.switchTo().defaultContent();
		// driver.switchTo().window(tabs2.get(1));

		// From Date selection
		driver.findElement(By.xpath("//div[contains(@class,'odf-datepicker')]")).click();
		logger.info("From Date picker clicked successfuly");
		Thread.sleep(2000);

//		String Frommonth = "August '21";
//		String FromDate = "1";

		selectFromDate(config.getProperty("Frommonth"), config.getProperty("FromDate"));
		Thread.sleep(2000);

		// To Date selection
		driver.findElement(By.xpath("//div[contains(@class,'odf-col odf-calendar-end')]")).click();
		logger.info("To Date picker clicked successfuly");
		Thread.sleep(2000);

//		String Tomonth = "August '21";
//		String ToDate = "7";

		selectToDate(config.getProperty("Tomonth"), config.getProperty("ToDate"));
		Thread.sleep(2000);

		// Service Class selection
		driver.findElement(By.xpath("//div[@class='odf-space-outer-right-m']")).click();
		logger.info("Service class dropdown clicked successfuly");
		Thread.sleep(2000);

		WebElement ServiceClass = driver.findElement(By.xpath("//div[@class='odf-space-outer-right-m']//ul"));
		List<WebElement> ServiceClassList = ServiceClass.findElements(By.tagName("li"));
		for (WebElement li : ServiceClassList) {
			if (li.getText().equals(config.getProperty("ServiceClass"))) {
				li.click();
				logger.info("Service class selected successfuly from dropdown");
				break;
			}
		}

		// Traveler count
		driver.findElement(By.xpath("//div[contains(@class,'odf-col odf-col-sm')]/div/div[1]/div")).click();
		logger.info("Traveler count dropdown selected successfuly");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//button[contains(@class,'odf-btn odf-btn-secondary odf-btn-square inc')]")).click();
		logger.info("Traveler count selected successfuly");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(@class,'css-1mb0azi')]"));

		// click on Traveler dropthrough
		// driver.findElement(By.xpath("//div[contains(@class,'odf-input
		// odf-text-lg')]")).click();
		// By element = By.xpath("//div[contains(@class,'odf-input-group focus
		// odf-input-inline-focus')]/input");

		By elementFrom = By.xpath("//div[contains(@class,'odf-input-group')]/input[@placeholder='Where from?']");
		By elementTo = By.xpath("//div[@class='odf-input-group']/input");
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(element)));

		enterText(elementFrom, config.getProperty("DepartingFrom"));
		logger.info("Departing from place selected successfuly");
		Thread.sleep(3000);
		enterText(elementTo, config.getProperty("Arriving"));
		logger.info("Arriving from place selected successfuly");
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//div[@class='odf-input-group']/input")).sendKeys("Paris");

		// driver.close();
		// driver.switchTo().window(tabs2.get(0));

		driver.findElement(By.xpath("//button[text()='Search Flights']")).click();
		logger.info("Search flights button selected successfully");
		Thread.sleep(5000);

//		driver.switchTo().frame("ssIFrame_google");
//		Thread.sleep(2000);
//		driver.switchTo().defaultContent();
//		
//		driver.findElement(By.xpath("//button[text()='UNDERSTOOD']")).click();
//		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Select']")).click();
		logger.info("Flights option selected successfully");
		Thread.sleep(5000);

//		driver.findElement(By.xpath("//span[text()='ECONOMY LIGHT2']//parent::div//parent::div//parent::div//button")).click();
//		Thread.sleep(2000);

		// Pass Data for 1st Passenger
		driver.findElement(By.xpath("//div[@id='passengers0']//input[contains(@placeholder,'E.g. Amelia')]"))
				.sendKeys(config.getProperty("PassengerName1"));
		logger.info("1st Passenger Name entered successfuly");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='passengers0']//input[contains(@placeholder,'E.g. Earhart')]"))
				.sendKeys(config.getProperty("PassengerSurname1"));
		logger.info("1st Passenger Surname entered successfuly");
		Thread.sleep(2000);

		// Pass Data for 1st Passenger
		driver.findElement(By.xpath("//div[@id='passengers1']//input[contains(@placeholder,'E.g. Amelia')]"))
				.sendKeys(config.getProperty("PassengerName2"));
		logger.info("2nd Passenger Name entered successfuly");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='passengers1']//input[contains(@placeholder,'E.g. Earhart')]"))
				.sendKeys(config.getProperty("PassengerSurname2"));
		logger.info("2nd Passenger Surname entered successfuly");
		Thread.sleep(2000);

		// Pass Contact detail Data
		driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys(config.getProperty("Email"));
		logger.info("Email Id entered successfuly");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Confirm email']"))
				.sendKeys(config.getProperty("ConfirmEmail"));
		logger.info("Confirm Email Id entered successfuly");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys(config.getProperty("Address"));
		logger.info("Address detail entered successfuly");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys(config.getProperty("City"));
		logger.info("City detail entered successfuly");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Postcode']")).sendKeys(config.getProperty("Postcode"));
		logger.info("Postcode detail entered successfuly");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='1234567890']")).sendKeys(config.getProperty("PhoneNumber"));
		logger.info("PhoneNumber detail entered successfuly");
		Thread.sleep(2000);

		// select value from Country dropdown

		WebElement CountryDrop = driver.findElement(By.xpath("//select[@name='country']"));
		CountryDrop.click();
		logger.info("Country dropdown clicked successfuly");
		Thread.sleep(2000);

		List<WebElement> CountryDropList = CountryDrop.findElements(By.tagName("option"));

		for (WebElement Country : CountryDropList) {
			if (Country.getText().equals(config.getProperty("Country"))) {
				Country.click();
				logger.info("Country Selected successfuly");
				Thread.sleep(2000);
				break;
			}
		}

		// select value from Country Code dropdown

		WebElement CountryCodeDrop = driver.findElement(By.xpath("//select[@name='phoneCode1']"));
		CountryDrop.click();
		logger.info("PhoneCode dropdown clicked successfuly");
		Thread.sleep(2000);

		List<WebElement> CountryCodedDropList = CountryCodeDrop.findElements(By.tagName("option"));

		for (WebElement Country : CountryCodedDropList) {
			if (Country.getText().equals(config.getProperty("CountryCode"))) {
				Country.click();
				logger.info("PhoneCode selected successfuly");
				Thread.sleep(2000);
				break;
			}
		}
		
		
		// select check box
		
		WebElement CheckBox = driver.findElement(By.xpath("//label[@for='customersinfosave']//span[@class='odf-icon odf-icon-tick']"));
		CheckBox.click();
		logger.info("Checked box clicked successfuly");
		Thread.sleep(2000);
		
		//Select to continue button
		
		WebElement Continue = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
		Continue.click();
		logger.info("Continue button clicked successfuly");
		Thread.sleep(2000);
		
		//Selecting option as continue without
//		driver.switchTo().frame("Criteo DIS iframe");
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(normalize-space(.),'Continue without')]")).click();
		logger.info("Continue wihtout bagage selection button clicked successfuly");
		Thread.sleep(2000);
//		driver.switchTo().defaultContent();
//		Thread.sleep(2000);
		
		//Select option from Recommended for a stress-free trip 
		
		driver.findElement(By.xpath("//div[@data-type='standard']//span[contains(text(),'Select')]")).click();
		logger.info("Select option from Recommended for stress-free trip obtain button clicked successfuly");
		Thread.sleep(2000);
		
		//Click to continue payment
		driver.findElement(By.xpath("//button[normalize-space()='Continue to payment']")).click();
		logger.info("Continue button clicked successfuly");
		

	}

}

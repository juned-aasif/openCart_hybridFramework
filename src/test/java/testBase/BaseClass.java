package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties property;
	public WebDriverWait wait;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException {
		
		logger = LogManager.getLogger(this.getClass());
		
		// properties file configuration
		FileInputStream proFile = new FileInputStream("./src/test/resources/config.properties");
		property = new Properties();
		property.load(proFile);
		
		// WebDriver setup
		switch(br.toLowerCase()) {
		case("chrome") : driver= new ChromeDriver(); break;
		case("edge") : driver = new EdgeDriver(); break;
		case("firefox"): driver = new FirefoxDriver(); break;
		default : logger.info("Driver configurations issue"); return;
		}
		
		//driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(property.getProperty("url"));
	}// setup
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	public String randString() {
		@SuppressWarnings("deprecation")
		String genString= RandomStringUtils.randomAlphabetic(5);
		return genString;
	}
	
	public String randNumeric() {
		@SuppressWarnings("deprecation")
		String genNumber = RandomStringUtils.randomNumeric(10);
		return genNumber;
	}
	
	public String randPass() {
		@SuppressWarnings("deprecation")
		String genString= RandomStringUtils.randomAlphabetic(4);
		String genNumber = RandomStringUtils.randomNumeric(3);
		return (genString+"@"+genNumber);
	}
	
	
	public String capScreen(String name) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + name+ "_" + timeStamp+ ".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}

}// class

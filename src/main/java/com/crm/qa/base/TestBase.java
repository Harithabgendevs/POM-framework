package com.crm.qa.base;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	public static Properties prop;
	
	public static final int DEFAULT_WAIT_UNTIL_DURATION = 10;
    public static final long DEFAULT_WAIT_TIME = 200;

    public WebDriver driver;

    public TestBase(){
    }

    public WebDriver getDriver(){
        String currentDir = System.getProperty("user.dir");
        String currentOS = System.getProperty("os.name").toUpperCase();
        System.out.println("TESTS RUNNING IN OS :: " +  currentOS);
        if(currentOS.contains("mac os")){
            System.setProperty("webdriver.chrome.driver" , currentDir+ "/driver/chromedriver");
        }else{
            System.setProperty("webdriver.chrome.driver" , currentDir+ "/driver/chromedriver.exe");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        //driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return driver;
    }	
	
		
	}	


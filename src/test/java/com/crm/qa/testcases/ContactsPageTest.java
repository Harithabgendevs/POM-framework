
package com.crm.qa.testcases;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pageobjects.ContactsPage;
import com.crm.qa.pageobjects.HomePage;
import com.crm.qa.pageobjects.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	   
	public ContactsPageTest(){
			super();
			
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		driver=getDriver();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		AssertJUnit.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
		contactsPage.selectContactsByName("ui uiii");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

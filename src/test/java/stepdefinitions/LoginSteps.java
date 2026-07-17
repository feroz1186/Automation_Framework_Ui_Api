package stepdefinitions;


import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;

public class LoginSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);

    @Given("user navigates to login page")
    public void user_navigates_to_login_page() {
    	logger.info("Browser Launched....");
        driver.get(ConfigReader.get("baseUrl"));
        logger.info("Navigate to URL....");
        logger.info("===================================================");
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUserName(username);
        logger.info("Entered UserName");
        loginPage.enterPassword(password);
        logger.info("Entered Password");
        logger.info("===================================================");

    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.clickLogin();
        logger.info("Click Login Button...");

        logger.info("===================================================");

    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        logger.info("Dashboard verification inprogress.....");

        Assert.assertTrue(loginPage.isDashBoardDisplayed());
    }
    @When("When user enters username {string} and password {string}")
    public void datadriven(String uname,String pword)
    {
    	loginPage.enterUserName(uname);
    	loginPage.enterPassword(pword);
    }
    
    @When("user enters the following login details")
    public void datatabledemo(DataTable dataTable)
    {
    	List<Map<String,String>> logindata=dataTable.asMaps(String.class,String.class);
    	
    	for(Map<String,String> map : logindata)
    	{
    		loginPage.enterUserName(map.get("username"));
        	loginPage.enterPassword(map.get("password"));
    	}
    }

}
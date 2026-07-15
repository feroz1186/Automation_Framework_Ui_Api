package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(name="username")
	private WebElement usernamefield;
	
	@FindBy(name="password")
	private WebElement passwordfield;
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement loginButton;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement dashboardName;

	public void enterUserName(String username)
	{
		type(usernamefield, username);
	}
	
	public void enterPassword(String password)
	{
		type(passwordfield,password);
	}
	
	public void clickLogin()
	{
		click(loginButton);
	}
	
	public boolean isDashBoardDisplayed()
	{
		return getText(dashboardName).length() > 0;
	}
}

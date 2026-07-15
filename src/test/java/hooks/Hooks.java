package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverManager;
import utils.TokenManager;

public class Hooks {
	
	@Before(order = 0)
    public void setUp(Scenario scenario) {
        if (isUIScenario(scenario)) {
            DriverManager.getDriver();
        }
        else//If its api project generate token first
        {
        	TokenManager.getToken();
        }
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && isUIScenario(scenario)) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        if (isUIScenario(scenario)) {
            DriverManager.quitDriver();
        }
    }

    private boolean isUIScenario(Scenario scenario) {
        return scenario.getSourceTagNames().contains("@ui");
    }
	

}

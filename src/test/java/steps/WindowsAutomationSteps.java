package steps;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import io.cucumber.java.en.Then;

import io.appium.java_client.windows.WindowsDriver;

public class WindowsAutomationSteps {
	private static WindowsDriver windowsAppSession = null;
	private boolean isNotepad = false;
	
	@Given("that I open {string}")
	public void ProgramOpens(String appToOpen) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			 DesiredCapabilities capabilities = new DesiredCapabilities();
			 capabilities.setCapability("app", appToOpen);
			 capabilities.setCapability("platformName","Windows");
			 capabilities.setCapability("deviceName", "WindowsPC");
			 windowsAppSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			 windowsAppSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			} catch (Exception e) {
				if(windowsAppSession != null) {
					windowsAppSession.quit();
				}
			 
			 throw new io.cucumber.core.exception.CucumberException(appToOpen + " failed to start", e);
		  }
	}
	
	@When("I enter {string} into the {string} field")
	public void IEnterText(String inputText, String editLocator) {
		windowsAppSession.findElementByName(editLocator).sendKeys(inputText);
	}
	
	@When("I press the {string} button")
	public void IPressTheButtons(String buttonToPress) {
		windowsAppSession.findElementByName(buttonToPress).click();
	}
	
	@Then("I expect that {string} contains {string}")
	public void i_expect_the_result_pane_to_contain_the_output(String resultLocator, String expectedResult) {
		String actualResult = windowsAppSession.findElementByName(resultLocator).getText().trim();
		assertEquals(expectedResult, actualResult);
		
		try { windowsAppSession.findElementByName(resultLocator).clear(); } catch(Exception e) { /*This is a do not save catch. Errors here can be ignored*/ }
		windowsAppSession.closeApp(); //close app should have a handler if a "Close without saving" window spawns to avoid the above
	}
}
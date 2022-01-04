package steps;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import io.cucumber.java.en.Then;

import io.appium.java_client.windows.WindowsDriver;

public class WindowsAutomationSteps {
	private static WindowsDriver windowsAppSession = null;
	
	@Given("that I open {string}")
	public void ProgramOpens(String appToOpen) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			 DesiredCapabilities capabilities = new DesiredCapabilities();
			 capabilities.setCapability("app", appToOpen);
			 capabilities.setCapability("platformName","Windows");
			 capabilities.setCapability("deviceName", "WindowsPC");
			 windowsAppSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			 windowsAppSession.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
	
	//EVERYTHING AFTER THIS IS PROTOTYPING -------------------------------------------
	
	public void SwitchToPartialTitleMatchWindow(String partialTitle) throws Exception {
		//We should implement this to use the page timeout being set somewhere
		//This'll need to be 15-30 seconds for manual curation for sure
		//Can probably implement a process check to be sure that the metabolon process hasn't fallen on its face to terminate faster
		//in a fail case
		int count = 0;
		int checksToDo = 120;
		int pageTimeout = 30000;
		
		int timeToWaitBetween = pageTimeout/checksToDo;
		
		do
		{
			try {
				for (var winHandle : windowsAppSession.getWindowHandles()) 
				{
				    windowsAppSession.switchTo().window(winHandle);
				    if(windowsAppSession.getTitle().contains(partialTitle)) {
				    	return;
				    }
				}
			}
			catch(Exception bypassFailure) {
				try {Thread.sleep(timeToWaitBetween);} catch(Exception sleepFailure) { throw sleepFailure; }
			}

			count++;
		}while(count < checksToDo);
		
		throw new org.openqa.selenium.TimeoutException("New window failed to load in the alotted timeout");
	}
	
	@When("I press the {string} xpath button")
	public void IPressTheButtonsXpath(String buttonToPress) {
		windowsAppSession.findElementByXPath(buttonToPress).click();
	}
	
	@When("I enter {string} into the {string} xpath")
	public void IEnterTextXpath(String inputText, String editLocator) {
		windowsAppSession.findElementByXPath(editLocator).sendKeys(inputText);
	}
	
	@Then("I expect that {string} xpath contains {string}")
	public void i_expect_the_result_pane_to_contain_the_output_xpath(String resultLocator, String expectedResult) {
		String actualResult = windowsAppSession.findElementByXPath(resultLocator).getText().trim();
		assertEquals(expectedResult, actualResult);
		
		try { windowsAppSession.findElementByXPath(resultLocator).clear(); } catch(Exception e) { /*This is a do not save catch. Errors here can be ignored*/ }
		windowsAppSession.closeApp(); //close app should have a handler if a "Close without saving" window spawns to avoid the above
	}
	
	@Then("the window {string} opens")
	public void TheWindowOpens(String paritalWindowTitle) throws Exception {
		SwitchToPartialTitleMatchWindow(paritalWindowTitle);
	}
	
	@Then("the {string} button should exist")
	public void the_element_exists(String buttonNameToCheck){
		//The wait until is a built in implicit wait, but I don't believe it's needed as long as the window change succeeded.
		//I only saw instant failure if the window was closed, but it's here just in case. Until we determine this.
		//Need to determine page load. We'll figure this out. For now just getting here and interaction is the goal
		
		//We may actually be able to implement window waiting into ExpectedConditions...
		WebDriverWait wait = new WebDriverWait(windowsAppSession, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(buttonNameToCheck)));
		
		//Xpath will work with these controls much better as we can do a partial match on CompoundSummaryWith...
		List<WebElement> allEntries = windowsAppSession.findElementsByName("Wpf.Controls.Redux.Models.CompoundSummaryWithHistoricalStats");
		allEntries.get(0).click();
		try {Thread.sleep(5000);}catch(Exception e) {}
		
		//Just here after a wait to verify we're clicking the right locations
		allEntries.get(5).click();
		
		//Give us a chance to verify by hand right now
		try {Thread.sleep(15000);}catch(Exception e) {}
	}
	//END PROTOTYPING ----------------------------------------------------------------
}
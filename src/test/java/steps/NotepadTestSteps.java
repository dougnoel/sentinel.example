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

public class NotepadTestSteps {
	private static WindowsDriver notepadSession = null;
	
	public static String testInput = "test";
	
	@Given("that I open Notepad.exe")
	public void that_I_open_Notepad_exe() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			 DesiredCapabilities capabilities = new DesiredCapabilities();
			 capabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
			 capabilities.setCapability("platformName","Windows");
			 capabilities.setCapability("deviceName", "WindowsPC");
			 notepadSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			 notepadSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			} catch (Exception e) {
				if(notepadSession != null) {
					notepadSession.quit();
				}
			 
			 throw new io.cucumber.core.exception.CucumberException("Notepad failed to start", e);
		  }
	}

	@When("I enter {string} into the main window")
	public void i_enter_into_the_main_window(String string) {
		notepadSession.findElementByClassName("Edit").sendKeys(testInput);
	}

	@Then("I verify that the main window contains {string}")
	public void i_verify_that_the_main_window_contains(String string) {
	    String displayedText = notepadSession.findElementByClassName("Edit").getText();
	    assertEquals(testInput, displayedText);
	    notepadSession.findElementByClassName("Edit").clear();
	    notepadSession.quit();
	}
}

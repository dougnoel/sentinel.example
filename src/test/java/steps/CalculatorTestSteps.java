package steps;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import io.cucumber.java.en.Then;

import io.appium.java_client.windows.WindowsDriver;

public class CalculatorTestSteps {
	private static WindowsDriver calculatorSession = null;

	@Given("that I open Calculator.exe")
	public void that_I_open_Calculator_exe() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			 DesiredCapabilities capabilities = new DesiredCapabilities();
			 capabilities.setCapability("app", "C:\\Windows\\System32\\win32calc.exe");
			 capabilities.setCapability("platformName","Windows");
			 capabilities.setCapability("deviceName", "WindowsPC");
			 calculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			 calculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			} catch (Exception e) {
				if(calculatorSession != null) {
					calculatorSession.quit();
				}
			 
			 throw new io.cucumber.core.exception.CucumberException("Calculator failed to start", e);
		  }
	}

	@When("I press the one button")
	public void i_press_the_one_button() {
		calculatorSession.findElementByName("1").click();
	}

	@When("I press the plus button")
	public void i_press_the_plus_button() {
		calculatorSession.findElementByName("Add").click();
	}

	@When("I press the two button")
	public void i_press_the_two_button() {
		calculatorSession.findElementByName("2").click();
	}

	@When("I press the equals button")
	public void i_press_the_equals_button() {
		calculatorSession.findElementByName("Equals").click();
	}

	@Then("I expect the result pane to contain the output {string}")
	public void i_expect_the_result_pane_to_contain_the_output(String string) {
		String calcResult = calculatorSession.findElementByName("Result").getText().trim();
		assertEquals("3", calcResult);
		calculatorSession.quit();
	}
}

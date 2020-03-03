package tests;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.dougnoel.sentinel.pages.PageManager;
import com.dougnoel.sentinel.webdrivers.WebDriverFactory;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true
        , features = "src/test/java/features"
        , glue = { "stepdefinitions", "com.dougnoel.sentinel.steps" }
        , plugin = { "com.cucumber.listener.ExtentCucumberFormatter:reports/extent-cucumber-report.html" }
//      , tags = { "@19" }
)

public class TestRunner {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("env", "demo"); // Set the environment (dev/qa/stage/prod/etc)
        System.setProperty("org.freemarker.loggerLibrary", "none");
        WebDriverFactory.instantiateWebDriver();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	PageManager.quit();
        
        Reporter.loadXMLConfig(new File("conf/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", System.getProperty("os"));
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }

}

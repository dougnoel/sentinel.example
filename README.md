#com.dougnoel.sentinel.Example
Works with Sentinel 1.0.2

# Section 0: Installation

## 0.1 Prerequisites
You will need to have the following tools installed before creating a project:
 * Eclipse
 * Java (1.8)
 * Maven (2.5.4 or later)
 * Google Chrome (recommended)

## 0.2 Setting up the Project

These instructions assume you are using Eclipse.

**On the command line:**
Clone the project from git.

```
git clone https://github.com/dougnoel/sentinel.example.git
```
1. Open Eclipse
2. File -> Open Projects from File system...
3. Next to Import Source click the Directory button and browse to the installed location.
4. Click the Finish button.
1. Right-Click on the project in the Project Explorer.
2. Maven -> Update Project...
3. Wait for the status bar in the lower right-hand corner to finish before continuing.

## 0.3 Install the Sentinel Jar
>__NOTE:__ This is a temporary solution until we can get the Sentinel jar in the Maven repo.

On the command line, install Sentinel to your local Maven Repo from the root of your project:

```
mvn install:install-file -Dfile=lib/sentinel/sentinel-1.0.3.jar -DgroupId=com.dougnoel -DartifactId=sentinel -Dversion=1.0.3 -Dpackaging=jar -DgeneratePom=true

# Section 1: Creating A New Project

Follow these steps to setup your project from scratch. Alternately you can use the com.dougnoel.sentinel.example project and modify it. These instructions assume that you are using Eclipse, which is a free IDE. If you are familiar with another IDE, you can use that instead. This project will work on all major operating systems.

## 1.1 Create a New Project in Eclipse

1. In Eclipse: File -> New -> Other... (<kbd>__⌘N__</kbd>)
2. Open the __Maven__ folder and select __Maven Project__.
3. Click the __Next__ button.
4. Select a project folder.
5. Click the __Next__ button 2 times.
6. In the __Group ID__ field, enter com.<yourdomain>
7. In the __Artifact ID__ field, enter your project name (eg. my.project)
8. Click the __Finish__ button.

## 1.2 Create a .gitignore

1. Right-click on the project root in the Package Explorer. Select New -> File
2. Name the file __.gitignore__ - note the period at the beginning of the name.
2. The file will open in the editor. Paste the following text, then __Save__ the file.

```
# Ignore the compiled binaries folder
bin/

# Ignore Eclipse project settings
.DS_Store
.classpath
.project
.settings/

#Ignore logs
*.log

#Ignore the contents of the maven target/ folder
target/
```
_Note:_ If you look in the Project Explorer, the file will not appear. It is still there. If you want it to appear, you can [Edit Your Project Explorer Filter Settings](https://stackoverflow.com/questions/98610/how-can-i-get-eclipse-to-show-files).

## 1.3 Install the Sentinel Jar
>__NOTE:__ This is a temporary solution until we can get the Sentinel jar in the Maven repo.

1. Download the latest com.dougnoel.sentinel.jar OR create your own by cloning the [Sentinel repo](https://github.com/dougnoel/sentinel) and building it.
2. Create a __lib__ directory.
3. Inside the __lib__ directory create a __sentinel__ directory.
4. Copy the ``sentinel-1.0.0.jar`` file into the __lib/sentinel__ directory.
5. Install Sentinel to your local Maven Repo from the root of your project:

```
mvn install:install-file -Dfile=lib/sentinel/sentinel-1.0.0.jar -DgroupId=com.dougnoel -DartifactId=sentinel -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true
```

## 1.4 Configure your pom.xml

1. In the Eclipse Package Explorer double-click on the pom.xml to open it.
2. At the bottom of the pom.xml are a number of tabs.
3. Click the __Dependencies__ tab.
4. Select __junit__ in the __Dependencies__ list and click the __Properties...__ button to the right.
5. Change the __Version__ to __4.12__ and press the __OK__ button.
6. Click the __pom.xml__ tab.
7. Find the __dependencies__ section.
8. Paste the following lines, updated for the version of Sentinel you are using into that section. (Use <kbd>⌘⇧F</kbd> (Mac) or Ctrl+Shift+F (Win) to format the entry.)

```
		<!-- Sentinel -->
		<dependency>
			<groupId>com.dougnoel</groupId>
			<artifactId>sentinell</artifactId>
			<version>1.0.0</version>
		</dependency>
```
9. __Save__ the file.
10. In the __Package Explorer__ Right-click on the project and select __Maven -> Update Project...__
11. Make sure your Project is checked and click the __OK__ button.

## 1.5 Manage Packages
Maven creates some default files and packages we don't need, and we need to create a few that we will need. Specifically, we need to create a place to store page objects in the main section so that they can be compiled and shared between projects. While in our test section we need a place to store our Cucumber feature files and our test runner script.

### 1.5.1 Remove Extraneous Default Packages
1. In the __Package Explorer__ expand __src/main/java__.
2. Right-click on the __com.com.dougnoel.sentinel.<projectname>__ package and select __Delete__.
3. Click the __Ok__ button.
4. In the __Package Explorer__ expand __src/test/java__.
5. Expand the __com.com.dougnoel.sentinel.<projectname>__ package.
6. Right-click the __AppTest.java__ file and select __Delete__.
7. Click the __Ok__ button.

### 1.5.2 Create Starting Packages
1. In the __Package Explorer__ right-click on __src/main/java__ and select __New -> Package__.
2. In the name field enter __com.com.dougnoel.sentinel.<projectname>.pages__
3. Ensure ensure __Create package-info.java is checked.
4. Press the __Finish__ button.
5. In the __Package Explorer__ right-click on __src/test/java__ and select __New -> Folder__.
6. In the name field enter __features__
7. Ensure ensure __Create package-info.java is checked.
8. Press the __Finish__ button.

### 1.5.3 Copy Drivers and Configurations
> Note: These are things that will go away in the future and the framework will handle invisibly.

1. Copy the drivers folder from the Sentinel project to your project root (same level as src).
2. Copy the conf folder from the Sentinel project to your project root (same level as src).
3. Delete the log4j2.xml config file from the conf folder in your project.

### 1.5.4 Create a com.dougnoel.sentinel.yml configuration file

Create a file in the conf directory called 'com.dougnoel.sentinel.yml'. Here you will need to set values in order to run your tests. All configuration properties such as which browser and operating system to use during testing, saucelabs configuration, which page object packages you want to test, and other necessary values are to be set on an environment specific basis. 

##### **You must set browser, operating system (os) and pageObjectPackages values in order to run a test**

Here are all the properties you can set in the com.dougnoel.sentinel.yml file:

#### Commandline Only

| Property Name      | Possible Values                                                    | Required? |
| ------------------ | ------------------------------------------------------------------ | --------- |
| env                | any environment name                                               | *         |
| user.name          | The person running the test, NOT a test user                       |           |

#### Testing Properties

| Property Name      | Possible Values                                                    | Required? |
| ------------------ | ------------------------------------------------------------------ | --------- |
| browser            | Chrome, Firefox, IE, Safari                                        | *         |
| os                 | "OS X", Windows, Mac, Linux, Win                                   | *         |
| pageObjectPackages | a comma separated list of page object packages defined in sentinel | *         |
| timeout            | any number, defaults to 10                                         |           |
| timeunit           | any unit of time, defaults to seconds                              |           |
| download           | The download directory                                             |           |

#### Saucelabs Properties
These only need to be set if you want to use Saucelabs to execute tests.

| Property Name      | Possible Values                                                    | Required? |
| ------------------ | ------------------------------------------------------------------ | --------- |
| browser            | Chrome, Firefox, IE, Safari                                        | *         |
| version            | Browser version. Set to latest or do not set for latest browser.   |           |
| os                 | "Windows 10", Mac, Linux                                           | *         |  
| saucelabsUserName  | Saucelabs Username                                                 | *         |  
| saucelabsAccessKey | Saucelabs Access Key - Generated and downloaded from Saucelabs.    | *         |
| parent-tunnel      | Saucelabs tunneling information if necessary.                      |           |
| tunnelIdentifier   | Saucelabs tunneling information if necessary.                      |           | 
| name               | The project name.                                                  |           |
| build              | The build being tested.                                            |           |  
| tags               | Any tags you want associated with the execution.                   |           |
    
## 1.6 Create Your First Test
Refer to the files in this test project for examples.

### 1.6.1 Create a Page Object
1. In the __Package Explorer__ expand __src/main/java__.
2. Right-click on the __com.com.dougnoel.sentinel.<projectname>.pages__ package and select __New -> Class__.
3. Using [Pascal Case](https://en.wikipedia.org/wiki/Camel_case) name your page object something that would make sense to a business owner, ending in the word __Page__. Enter this into the __Name__ field.
4. In the __Superclass__ field, paste the following: `com.dougnoel.sentinel.pages.Page`
5. Click the __Finish__ button.
6. Your new class file will open with a .java extension.
__NOTE:__ If the word `Page` or `com.dougnoel.sentinel.pages.Page` is underlined in red, then you missed one of the steps in section 1.4 above.

### 1.6.2 Create a Page Element
Before we can create a Page Element, we need to find an element on a web page.
1. Open up your web page in Chrome.
2. Right-click on the element you want to use to create a Page Element and select __Inspect__. The Chrome debug console will appear.
3. Examine the element and determine how you want to identify it. Ideally, the element has an ID. If not, but it has display text, for example a login button that says "Login", we can identify it using TEXT. If neither of those options is available, use XPATH. (There are other options including CSS, NAME, PARTIALTEXT, INDEX and VALUE. For more information on these options, check out the Javadoc on com.dougnoel.sentinel.utils.SelectorType)

#### 1.6.2.1 Create a Page Element Using an ID
`new Textbox username_field() { return new Textbox(ID, "my_id"); }` 

#### 1.6.2.2 Create a Page Element Using XPATH

`new Textbox username_field() { return new Textbox(XPATH, "//div[@id='login_button_container']//form/input[1]"); }` 

#### 1.6.2.3 Create a Page Object Config File
>__NOTE:__ Vault server access has not been coded yet.

URLs and credentials can be read from a config file or a Vault server. To start, we will use a simple Yaml configuration file.

1. In the __Package Explorer__ expand __src/main/java__.
2. Right-click the page you made in __Section 1.5.1__ and select __Copy__.
3. Right-click on the __com.com.dougnoel.sentinel.<projectname>.pages__ package and select __New -> File__.
4. Paste the name you copied in the __File Name__ box and change the __.java__ extension to __.yml__ then click the __Finish__ button.
5. In the file that opens, type __urls:__ and hit the __RETURN__ key.
6. Hit the __Tab__ key.
7. Type __base:__, then a space and put the url you are going to use for testing.
8. __Save__ the file.

### 1.6.3 Create a Feature File
Feature file names should start with a Jira Story ticket number, then have the full text on the Summary field, followed by __.feature__ as the file extension. (NOTE: Any colons (:), forward slashes (/) or backward slashes (\) should be removed from the name of the file as they are not compatible across operating systems and can cause your tests to fail on other machines.)

1. In the __Package Explorer__ expand __src/test/java__.
2. Right-click on the __features__ folder and select __New -> File__.
3. Enter the Jira Ticket Number Story summary and .feature in the __File Name__ box.
4. Click the __Finish__ button.
5. Paste the following into the editor and save the file.

```
#Author: your.email@yourdomain.com

@StoryTicketNumber
Feature: StoryTicketNumber Subject of your Ticket
  Copy the Description field form the ticket here.
  
Scenario: TaskTicketNumber Loading a Page
Given I am on the Sauce Labs Demo Page
```

### 1.6.4 Create a Test Runner

1. In the __Package Explorer__ expand __src/test/java__.
2. Right-click on the __com.<yourdomain>.<projectname>__ package and select __New -> JUnit Test Case__.
3. at the top select the __New JUnit 4 Test Case__ radio button.
4. In the __Name__ field enter __ProjectNameTest__.
5. Make sure the __setUpBeforeClass()__ and the __tearDownAfterClass()__ check boxes are checked.
6. Make sure the __setUp()__ and the __tearDown()__ check boxes are _un_checked.
7. Click the __Finish__ button.
8. Paste the following into the editor and save the file.
9. Uncomment and set the PageObjectPackages, browser and OS lines for your computer.

Headers (insert after the package line and replace the current imports):

```
import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.dougnoel.com.dougnoel.sentinel.pages.PageManager;
import com.dougnoel.com.dougnoel.sentinel.utils.WebDriverFactory;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true
        , features = "src/test/java/features"
        , glue = { "stepdefinitions", "com.dougnoel.sentinel.steps" }
        , plugin = { "com.cucumber.listener.ExtentCucumberFormatter:reports/extent-cucumber-report.html" }
//      , tags = { "@MYTAG-1" }
)
```
Class Body (replace the current class body):

```
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("env", "prod");
        System.setProperty("pageObjectPackages","pages, apis");
//      System.setProperty("browser", "Chrome");
//      System.setProperty("os", "OS X"); // Choose "Windows" or "OS X" or "Linux"
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

```

### 1.6.5 Run your first test

1. Right-click on your Test runner file __ProjectNameTest__.java and select __Run As > JUnit Test__.

A browser should load and you should receive output similar to the following:

```
Starting ChromeDriver 2.42.591059 (a3d9684d10d61aa0c45f6723b327283be1ebaad8) on port 44671
Only local connections are allowed.
Jan 12, 2019 1:31:39 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: OSS

1 Scenarios (1 passed)
1 Steps (1 passed)
0m1.724s
```

## 1.7 Check Your Code Into a Repository

1. Follow the instructions for importing an existing project.

## 2.0 Creating Tests

Explain how to run the automated tests for this system

### 2.1 Creating Page Objects

A page object contains the location information for all the elements on the page. With a config file, you can configure URLs for environments, as well as user names and passwords per environment.

#### 2.1.1 Creating Page Objects

Page objects must be located in the pages package. Create one by inheriting the Page class. 

```
package pages;

public class MyNewPage extends Page {
}
```

#### 2.1.2 Add an element

You add an element by creating a function that returns an element type. For example:

```
package pages;

public class MyNewPage extends Page {
	public Div google_map() { return new Div(ID, "map"); }
}
```

### 2.2 Add a configuration file (YAML)

Create a file in the directory with the same name (including case) as your page object with a .yml extension.

```
urls:
  base: http://{env}.google.com
  prod: https://www.google.com
dev:
  username: devuser
  password: Test1234
qa:
  username: qauser
  password: Test1234
prod:
  username: produser
  password: Test1234
```

### 2.3 Create a feature file

Create a feature file using the [Gherkin Syntax](https://docs.cucumber.io/gherkin/step-organization/). 

```
#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |

```

### 2.4 Create a step definition file

If the generic steps in stepdefinitions/BaseSteps.java do not fit your needs, then you can create a new file in the stepdefinition package.

```
package stepdefinitions;

public class MySteps {
	private static final Logger log = LogManager.getLogger(BaseSteps.class.getName()); // Create a logger.

	@When("^I do stuff like (.*)$")
	public void i_do_stuff(String stuff) throws Throwable {
	    //Operate on the variable stuff
	}
}
```
## 3.0 Creating API Tests
Sentinel now supports API testing.

### 3.1 Creating API Objects
An API object contains all the information needed to connect to an API. In future versions, we will pull directly from a swagger file.

#### 3.1.1 Creating an API Object
API objects must be located in the pages package path. Create one by inheriting the API class. 

```
package pages;

public class MyNewAPI extends API {
}
```

#### 3.1.2 Add a URL
You add a URL by creating a constructor for your API class:

```
package apis;

import java.net.MalformedURLException;
import java.net.URL;

import com.dougnoel.com.dougnoel.sentinel.apis.API;

public class TestAPI extends API {
	
	public TestAPI() throws MalformedURLException {
		this.url = new URL("https://jsonplaceholder.typicode.com/");
	}
}
```

#### 3.1.3 Add an action
You add an action by creating a function that returns an action type with a designated endpoint. There are three kinds: GET, POST and PUT. For example if I had an endpoint of "todos" that used a GET action to retrieve a list of items I would use the following:

```
package apis;

import java.net.MalformedURLException;
import java.net.URL;

import com.dougnoel.com.dougnoel.sentinel.apis.API;
import com.dougnoel.com.dougnoel.sentinel.apis.GET;

public class TestAPI extends API {
	public GET to_do_list () { return new GET("todos"); }
	
	public TestAPI() throws MalformedURLException {
		this.url = new URL("https://jsonplaceholder.typicode.com/");
	}
}
```

## 4.0 Executing Tests
Tests can be executed either in side an editor using JUnit, or on the commandline using maven. The first option is good for
getting debug output while developing. The second is good for running in a CI/CD pipeline. Either way, you must setup a JUnit test to run.

### 4.1 Executing tests using JUnit

1. Create a package in src/test/java called "tests".
2. Create a java file in the packages with the name "Test" in it. (E.G. TestRun.java)

#### 4.1.1 Setting the Test Environment

Create a file in the conf directory called 'com.dougnoel.sentinel.yml'. Here you will need to set values in order to run your tests. All configuration properties such as which browser and operating system to use during testing, saucelabs configuration, which page object packages you want to test, and other necessary values are to be set on an environment specific basis. 

##### **You must set browser and operating system values in order to run a test**

 The below example is taken from the example configuration file in the conf directory called com.dougnoel.sentinel.example.yml.

```
---
configurations:
  default:
    pageObjectPackages: "pages,apis"
    os: "Windows 10"
    browser: "chrome"
    saucelabsUserName: "username"
    saucelabsAccessKey: "apikey"
    parenttunnel: "tunnelname"
    tunnelIdentifier: "tunnelID"
  stage:
    os: "Windows 10"
    browser: "firefox"
  qa:
    os: "Linux"
  prod:
    saucelabsUserName: "username"
    saucelabsAccessKey: "apikey"
...
```
Here are all the properties you can set in the com.dougnoel.sentinel.yml file:

```
| Property Name     |Possible Values                                                    |
| ------------------|-------------------------------------------------------------------|
| env               |any environment name                                               |
| browser           |Chrome, Firefox, IE, Safari                                        |
| browserVersion    |Version of the browser to use - used for Saucelabs testing only    |
| os                |"OS X", Windows, Mac, Linux, Win                                   |  
| ssltrust          |all, none                                                          |
| pageObjectPackages|a comma separated list of page object packages defined in sentinel |
| parenttunnel      |Saucelabs parent tunnel ID                                         |
| saucelabsUserName |Your Saucelabs Username                                            |
| suacelabsAccessKey|Your Saucelabs apikey                                              |
| timeout           |any number, defaults to 10                                         |
| timeunit          |any unit of time, defaults to seconds                              |
| tunnelIdentifier  |Saucelabs tunnel identifier                                        |
| user.name         |The person running the test, NOT a test user                       |  
| download          |The download directory                                             |
```

#### 4.1.2 Set Tags in Test Package

In the test setup file, add the tags you want to test. These should match the tags in the feature file you have created.

```
tags = { "@ABCD-1234" }
```

#### 4.1.3 Closing the tests
This is where you clean up. In the tearDownAfterClass() add code similar to the following:

```
WebDriver driver = WebDriverFactory.getWebDriverAndHandleErrors();
log.debug("Driver: " + driver);
driver.quit();
```
### 4.2 Executing Tests using Maven
You can execute the tests in the dev environment on the command line.

```
mvn test
```
#### 4.2.1 Using command line parameters
You can also set configuration properties from the command line. Simply enter:

```
mvn -Dproperty=value test
```

Note that only values with spaces require double quotes:

```
mvn -Dproperty="my value" test
```
If you want to use tags you can include them like so:

```
mvn -D"cucumber.options--tags @TAG-103,@TAG-449" test
```

You will only have to do this the first time you run a test with a certain set of configurations. Any property you can set in 
the config file, you can set on the command line. If you find yourself testing multiple configurations, please refer to Section 3.1.1.

# Section 5: Additional Features

Additional features that you can use.

## 5.1 Logging in as a user.

### 3.1.1 Editing the YAML
1. Open your PageName.yml file for the page you want to have users.
2. Add in default users.

# 6.0 Versioning

We use [Semantic Versioning](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/dougnoel/sentinel/tags). 

# 7.0 Authors

* **Doug Noël** - *Architect* - Initial work.

# 8.0 License

This project is licensed under the Apache Commons 2.0 License - see the [LICENSE.md](LICENSE.md) file for details
# Sentinel.Example 1.0.3
Works with ![Sentinel](https://img.shields.io/github/v/release/dougnoel/sentinel?sort=semver&style=plastic)

# Section 1: Getting Started (~30 minutes)
This section will get you up and running, executing the example tests in 30 minutes or less. Most of the time investment is installing Git, Java, and Maven. If you have all those tools installed, it takes less than 10 minutes to get a test running.

## 1.1 Prerequisites
You will need to have the following tools installed to use the project:
 * Git
 * Java (1.8)
 * Maven (2.5.4 or later)
 * Google Chrome (Recommended)
 * Eclipse (Recommnded)
 
You can find installation scripts for these tools and installation instructions below. **NOTE:** These instructions and the accompanying installation scripts are provided AS IS. You may log tickets to improve the efficacy of the instructions or script, but there is no support for the scripts. They are being provided to help users who are not developers install development tools. If you are having difficulty installing any of these tools, please refer to the makers of these tools. Links to the makers of these tools are provided in [MAC-INSTALL.md](MAC-INSTALL.md) and [WIN-INSTALL.md](WIN-INSTALL.md).

If you already have these tools installed, you can clone the sentinel.example project and move directly to Section 1.2. It is recommended that you use google chrome for initial setup. It is also suggested you use Eclipse as your IDE, as all the instructions are written for Eclipse. If you are familiar with IntelliJ or another editor, it is assumed you are knowledgeable enough to get the project working in your IDE without detailed instructions.

## 1.1.1 Mac Installation (5 - 20 minutes)
Navigate to [sentinel.examples's release page](https://github.com/dougnoel/sentinel.example/releases) and download the **mac-install.command** file. Double-click on the file and everything you need will be automatically installed.

You can check the installation by opening up a terminal window and typing the following:

```
cd ~/Projects/sentinel.example
mvn test
```

If chrome pops up and the tests run successfully, you are ready to move to Section 1.2.

If you have issues with installation, refer to [MAC-INSTALL.md](MAC-INSTALL.md) for manual installation instructions.

## 1.1.2 Windows Installation (10 - 20 minutes)
There is no easy way to create a batch file to install all the tools you will need on Windows. Refer to [WIN-INSTALL.md](WIN-INSTALL.md) for manual installation instructions.

You can check the installation by opening up a command window and typing the following:

```
cd %HOMEPATH%\Projects\sentinel.example
mvn test
```
If chrome pops up and the tests run successfully, you are ready to move to Section 1.2.

If you have issues with installation, 

## 1.1.3 Linux Installation (5 - 20 minutes)
There is no installation script for Linux as different flavors have different package managers. (You are encouraged to contribute a shell script for installing tools on you os.) After installing the appropriate tools, cd to the directory you want the project in and clone the repo.

```
git clone https://github.com/dougnoel/sentinel.example.git
cd sentinel.example
cp conf/sentinel.linux.example.yml conf/sentinel.yml
mvn test
```

If chrome pops up and the tests run successfully, you are ready to move to Section 1.2.

If you have issues with installation, refer to the individual tool manufacturers.

# 1.2 Setting up the Project in Eclipse (10 minutes)

1. Open Eclipse
2. File -> Open Projects from File system...
3. Next to Import Source, click the Directory button and browse to the installed location.
4. Click the Finish button.
5. Right-Click on the project in the Project Explorer.
6. Maven -> Update Project...
7. Wait for the status bar in the lower right-hand corner to finish before continuing.
8. In the Project Explorer Expand sentinel.example -> src/test/java -> tests
9. Right-click on TestRunner.java and select Run As -> JUnit Test

If a browser pops up and the tests run successfully, you have successfully imported the project and are ready to build tests.

# Section 2: Writing Your First Test (~2 hours)
Writing a test starts before any code is written. When a user story is created, a ticket should have Acceptance Criteria that describe what the product owner expects the feature to do. Writing good Acceptance Criteria is about communicating what you expect to happen when development on a user story is complete. Good Acceptance Criteria act as your discussion points for clarifying stories, your test cases for automated testing, and your bug reports. After Acceptance criteria are written by the product owner, they should be agreed upon by the product owners, development and QA *before* the ticket is accepted into a sprint. Once a ticket is in a sprint, you will tweak the Acceptance Criteria to match the Gherkin steps that are already defined so that you do not have to write new code.

It is important that the entire team be a part of this process. It is ok as the QA team member to write a few examples of acceptance criteria when convincing a team to adopt this tool. However, you must get the team on board with writing the criteria as a whole - as part of backlog grooming, *or the implementation of automation will ultimately fail.* **The entire team must be involved** in the creation of the steps so that the entire scope of testing is understood. The Acceptance Criteria are a QA Engineer's ticket description. Without them, the scope of the automation being written will change in Sprints, and you will ultimately find yourself falling behind as work piles up. Just like it is unreasonable to expect developers to have any accuracy in story estimates if the stories are not defined before starting a sprint, you cannot expect quality assurance automation developers to have accuracy in story estimates if the acceptance criteria are not defined before starting a sprint.

Acceptance criteria should be written as part of the ticket they are testing. Once you get used to using this tool, you will find that automating inside a sprint will be easy to do. Resist the urge to split stories or create testing stories that are different from development stories. If a story is too large to both develop and test in a single sprint, it is too large to finish in a sprint. This is either a problem of poorly defined stories, or poorly designed architecture. Both of these issues should be tackled as you encounter them. Pushing the problems off will prevent you from being successful and kill your automation effort. Additionally, acceptance criteria should be a part of the ticket you are testing so that the feature file can be tied to the same ticket number to which the code is tied. (Your developers *are* including ticket numbers when they check their code in, aren't they? If not, fix this now - it's an idea that's more than 20 years old.) Every testing scenario in a feature should have its own task ticket number, so that different people can code each task, but more importantly - every test can be run independently.

## 2.1 Creating A Story and Task Tickets
The first test of any web site is logging into the site. So for our first test, we will be creating a login feature. We will be using the [New Tours Login](https://github.com/dougnoel/sentinel.example/issues/16) as an example. Clicking [this link](https://github.com/dougnoel/sentinel.example/issues/16) will take you to the ticket we created for our example feature. The first thing to do will be to create a similar ticket in your ticketing system, but instead of for the New Tours web site, make it for the web site you are testing. We are going to make two initial tests - one for a [successful login](https://github.com/dougnoel/sentinel.example/issues/17), and one for a [failed login](https://github.com/dougnoel/sentinel.example/issues/18). Create two tasks on your login story to track these. (If your system doesn't have tasks, just create two additional tickets as we have done and reference them in your parent story.)

These tickets don't have to be perfect. Copy what you see and make your best guess to modify them for your own system. We can update the tickets as we refine the steps, so it isn't important to get them right the first time. In fact, most of the time you will be tweaking the tickets as you implement your automation. It's good to get used to that now. Later on we will be going into more detail about the specifics of the Gherkin language.

## 2.2 Creating a Cucumber Test
Now that we have a ticket created, we can creature our first feature file. It's important to note that we use what Cucumber calls a feature file to match what Agile typically calls a story. Depending on where you work, a story may roll up to an epic, or it may roll up to a feature, then an epic, or something else. For our purposes, a feature file contains one story and a number of test scenarios. The purpose of this is to keep our tests as small an atomic as possible. If we let our feature files cover too much, they tend to get too complex, these slow our tetsing down, and feature creep starts over running our tests.

Feature file names should start with a story ticket number, then have the full text on the Summary field, followed by __.feature__ as the file extension. (NOTE: Any colons (:), forward slashes (/) or backward slashes (\) should be removed from the name of the file as they are not compatible across operating systems and can cause your tests to fail on other machines even if they do not fail on your machine.)

1. In the __Package Explorer__ expand __src/test/java__.
2. Right-click on the __features__ folder and select __New -> File__.
3. Enter the Jira Ticket Number Story summary and .feature in the __File Name__ box.
4. Click the __Finish__ button.
5. Paste the following into the editor, replace everything in {} with the requested information, and save the file.

```
#Author: {your.email@yourdomain.com}

@{StoryTicketNumber}
Feature: {StoryTicketNumber} {Subject of your Ticket}
  {Copy the Description field form the ticket here.}
  
  Scenario: {Task1TicketNumber} Successful Login
    Given I am on the {Name of your App/Website} Login Page
    When I fill the account information for account RegularUser into the Username field and the Password field
      And I click the Login Button
    Then I am redirected to the {Name of your App/Website} Main Page
      And I verify the {element on your main page} exists

  Scenario: {Task1TicketNumber} Failed Login
    Given I am on the {Name of your App/Website} Login Page
    When I fill the account information for account BadUser into the Username field and the Password field
      And I click the Login Button
    Then I verify a Failure Message exists
```

### 2.1.2 Feature Section

### 2.1.3 Background Section

### 2.1.4 Scenario Section
All steps are equal

#### 2.1.4.1 Given Keyword
#### 2.1.4.2 And Keyword
#### 2.1.4.3 When Keyword
#### 2.1.4.4 Then Keyword
#### 2.1.4.5 But Keyword

### 2.1.5 Scenario Outlines

## 2.2 Creating a Page Object

1. In the __Package Explorer__ expand __src/main/java__.
2. Right-click on the __com.com.dougnoel.sentinel.<projectname>.pages__ package and select __New -> Class__.
3. Using [Pascal Case](https://en.wikipedia.org/wiki/Camel_case) name your page object something that would make sense to a business owner, ending in the word __Page__. Enter this into the __Name__ field.
4. In the __Superclass__ field, paste the following: `com.dougnoel.sentinel.pages.Page`
5. Click the __Finish__ button.
6. Your new class file will open with a .java extension.

```
package pages;

public class MyNewPage extends Page {
}
```

### 2.2.1 Inspecting a Web Page in Chrome
Before we can create a Page Element, we need to find an element on a web page.
1. Open up your web page in Chrome.
2. Right-click on the element you want to use to create a Page Element and select __Inspect__. The Chrome debug console will appear.
3. Examine the element and determine how you want to identify it. Ideally, the element has an ID. If not, but it has display text, for example a login button that says "Login", we can identify it using TEXT. If neither of those options is available, use XPATH. (There are other options including CSS, NAME, PARTIALTEXT, INDEX and VALUE. For more information on these options, check out the Javadoc on com.dougnoel.sentinel.utils.SelectorType)



### 2.2.2 Using an ID

```
package pages;

public class MyNewPage extends Page {
	public Div google_map() { return new Div(ID, "map"); }
}
```

`new Textbox username_field() { return new Textbox(ID, "my_id"); }` 

### 2.2.3 Using an Element Name

### 2.2.4 Using Text

### 2.2.5 Using Partial Text

### 2.2.6 Using an XPath
`new Textbox username_field() { return new Textbox(XPATH, "//div[@id='login_button_container']//form/input[1]"); }`

### 2.2.7 Using a Class Name

### 2.2.8 Using a CSS Identifier

## 2.3 Creating a Page Object Configuration File
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

### 2.3.1 Configuring A Page's URLs by Environment
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

### 2.3.2 Configuring Test Users by Environment

1. Open your PageName.yml file for the page you want to have users.
2. Add in default users.

## 2.4 Setting Your Test Environment

## 2.5 Running Your First Test
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

Tests can be executed either in side an editor using JUnit, or on the commandline using maven. The first option is good for
getting debug output while developing. The second is good for running in a CI/CD pipeline. Either way, you must setup a JUnit test to run.

### 2.5.1 Executing tests using JUnit

1. Create a package in src/test/java called "tests".
2. Create a java file in the packages with the name "Test" in it. (E.G. TestRun.java)

#### 2.5.2 Setting the Test Environment

Create a file in the conf directory called 'sentinel.yml'. Here you will need to set values in order to run your tests. All configuration properties such as which browser and operating system to use during testing, saucelabs configuration, which page object packages you want to test, and other necessary values are to be set on an environment specific basis. 

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

# Section 3: Setting Configuration Options
Create a file in the conf directory called 'sentinel.yml'. Here you will need to set values in order to run your tests. All configuration properties such as which browser and operating system to use during testing, saucelabs configuration, which page object packages you want to test, and other necessary values are to be set on an environment specific basis. 

## 3.1 The Configuration File (sentinel.yml)

##### **You must set browser, operating system (os) and pageObjectPackages values in order to run a test**

Here are all the properties you can set in the sentinel.yml file:

### 3.1.1 Commandline Only

| Property Name      | Possible Values                                                    | Required? |
| ------------------ | ------------------------------------------------------------------ | --------- |
| env                | any environment name                                               | *         |
| user.name          | The person running the test, NOT a test user                       |           |

### 3.1.2 Testing Properties

| Property Name      | Possible Values                                                    | Required? |
| ------------------ | ------------------------------------------------------------------ | --------- |
| browser            | Chrome, Firefox, IE, Safari                                        | *         |
| os                 | "OS X", Windows, Mac, Linux, Win                                   | *         |
| pageObjectPackages | a comma separated list of page object packages defined in sentinel | *         |
| timeout            | any number, defaults to 10                                         |           |
| timeunit           | any unit of time, defaults to seconds                              |           |
| download           | The download directory                                             |           |

### 3.1.3 Saucelabs Properties
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
    
## 3.2 The Test Runner (TestRunner.java)
In the test setup file, add the tags you want to test. These should match the tags in the feature file you have created.

```
tags = { "@ABCD-1234" }
```

#### 3.2.1 Closing the tests
This is where you clean up. In the tearDownAfterClass() add code similar to the following:

```
WebDriver driver = WebDriverFactory.getWebDriverAndHandleErrors();
log.debug("Driver: " + driver);
driver.quit();
```

## 3.3 Executing Test on the Command Line
You can execute the tests on the command line.

```
mvn test -Denv=dev
```
#### 3.3.1 Using command line parameters
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


# Section 4: Using Existing Cucumber Steps

# Section 5: Creating Custom Cucumber Steps
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

# Section 6: API Testing

## 6.1 Creating API Objects
An API object contains all the information needed to connect to an API. In future versions, we will pull directly from a swagger file.

### 6.1.1 Creating an API Object
API objects must be located in the pages package path. Create one by inheriting the API class. 

```
package pages;

public class MyNewAPI extends API {
}
```

### 6.1.2 Add a URL
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

### 6.1.3 Add an action
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

# Section 7: Additional Information

## 7.1 Web Drivers

The web drivers are stored in src/main/resources/drivers/[os] to make sure there is only one place to fix driver compatibility issues. Chrome auto updates, and so is the one that will go of date most often. While we could pull the driver from a path and let each implementation install the drivers, this can become problematic in CI/CD environments where we do not control the system. This also reduces the learning curve for using Sentinel.
NOTE: All drivers are 64-bit versions. If you need to test on an old 32-bit browser, you will need to replace the drivers provided with a 32-bit driver. See the driver creators for support.

* [Chromedriver](http://chromedriver.chromium.org/) 80.0.3987.106 (2020-02-13) - Driver for automating Google Chrome.
* [Geckodriver](https://github.com/mozilla/geckodriver/releases) v0.26.0 (Oct 11 2019) - Driver for automating Mozilla Firefox.
* [IE Driver](http://selenium-release.storage.googleapis.com/index.html) 3.9 (2018-02-05) - Driver for automating IE.
* [Safari](https://webkit.org/blog/6900/webdriver-support-in-safari-10/) - Safari driver is embedded in Safari.

# 7.2 Versioning

We use [Semantic Versioning](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/dougnoel/sentinel.example/tags). 

# 7.3 Authors

* **Doug Noël** - *Architect* - Initial work.

# 7.4 License

This project is licensed under the Apache Commons 2.0 License - see the [LICENSE.md](LICENSE.md) file for details
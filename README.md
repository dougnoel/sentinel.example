# Sentinel.Example 1.0.3
Works with ![Sentinel](https://img.shields.io/github/v/release/dougnoel/sentinel?sort=semver&style=plastic)

This project will walk you through setting up an automated testing framework using Sentinel which leverages Cucumber and Selenium without requiring programming knowledge. As this project has developed, more has been done to reduce the learning curve. The toll was initially meant to be used by Quality Assurance professionals wanting to learn how to program, but who also needed to get their job done. The approach was two-fold. First, make automation so easy that it can be written as quickly as manual testing, and run faster than manual testing. In doing so, freeing up your time to be able to learn. Second, it provides an entry point for coding by exposing some, but not all of the code in a manageable way, by encouraging you to create custom testing steps. As use of this project has grown, the importance of this example project has grown with it, as has the need for easier installation.

It is worth noting for experienced Java developers, the Sentinel jar file can be included in your project's pom.xml and everything that is done here can be done inside your code, triggered as part of the testing phase of your build. You will have to mock up or stand up a web server to test against, but this project is intended to be a fully self-contained testing tool.

A final note before you begin using this tool. A tool is only as useful as you make it. You can buy the best power drill on the market, but if your team insists everything be built with nails, the drill will be useless. Implementing this tool is about process and getting people to adopt both the tool and the process around it. I have spent 20 years implementing automated testing at companies. The lessons I have learned inform the writing of this tutorial. Pay attention to not only how to use this tool, but what I have written about how to get your team (both business and technical) to adopt it. If you implement this tool correctly, you will be a hero. Furthermore, you will be able to take this tool with you in your career. Once you start using this shiny new tool, you won't want it left on the shelf. Technical implementation isn't the hard part. Team adoption is the hard part.

# Section 1: Getting Started (~30 minutes)
This section will get you up and running, executing the example tests in 30 minutes or less. Most of the time investment is installing Git, Java, and Maven. If you have all those tools installed, it takes less than 10 minutes to get a test running. In that case, just skip to Section 1.2

## 1.1 Prerequisites
You will need to have the following tools installed to use the project:
 * Git
 * Java (1.8)
 * Maven (2.5.4 or later)
 * Google Chrome (Recommended)
 * Eclipse (Recommnded)
 
You can find installation scripts for these tools and installation instructions below. **NOTE:** These instructions and the accompanying installation scripts are provided AS IS. You may log tickets to improve the efficacy of the instructions or script, but there is no support for the scripts. They are being provided to help users who are not developers install development tools. If you are having difficulty installing any of these tools, please refer to the makers of these tools. Links to the makers of these tools are provided in [MAC-INSTALL.md](MAC-INSTALL.md) and [WIN-INSTALL.md](WIN-INSTALL.md).

If you already have these tools installed, you can clone the sentinel.example project and move directly to Section 1.2. It is recommended that you use google chrome for initial setup. It is also suggested you use Eclipse as your IDE, as all the instructions are written for Eclipse. If you are familiar with IntelliJ or another editor, it is assumed you are knowledgeable enough to get the project working in your IDE without detailed instructions.

### 1.1.1 Mac Installation (5 - 20 minutes)
You will need the following prerequisites installed:
- [Xcode](https://developer.apple.com/xcode/)
- [Homebrew](https://brew.sh/)
- [Git](https://git-scm.com/)
- [Chrome](https://www.google.com/chrome/)
- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](http://maven.apache.org/)
- [Eclipse](https://www.eclipse.org/)

Once they are installed, you can continue with Section 1.2. Alternately, you can follow the instructions below and then move on to Section 1.3.

**Refer to [MAC-INSTALL.md](MAC-INSTALL.md) for installation instructions.**

You can check the installation by opening up a terminal window and typing the following:

```
cd ~/Projects/sentinel.example
mvn test
```

If Google Chrome pops up and the tests run successfully, you are ready to move to Section 1.3.

### 1.1.2 Windows Installation (10 - 20 minutes)
You will need the following prerequisites installed:
- [Git](https://git-scm.com/)
- [Chrome](https://www.google.com/chrome/)
- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](http://maven.apache.org/)
- [Eclipse](https://www.eclipse.org/)

Once they are installed, you can continue with Section 1.2. Alternately, you can follow the instructions below and then move on to Section 1.3.

**Refer to [WIN-INSTALL.md](WIN-INSTALL.md) for installation instructions.**

You can check the installation by opening up a command window and typing the following:

```
cd %HOMEPATH%\Projects\sentinel.example
mvn test
```
If Internet Explorer pops up and the tests run successfully, you are ready to move to Section 1.3.

### 1.1.3 Linux Installation (5 - 20 minutes)
There is no installation script for Linux as different flavors have different package managers. (You are encouraged to contribute a shell script for installing tools on you os.) After installing the appropriate tools, cd to the directory you want the project in and clone the repo.

```
git clone https://github.com/dougnoel/sentinel.example.git
cd sentinel.example
cp conf/sentinel.linux.example.yml conf/sentinel.yml
mvn test
```

If the tests run successfully, you are ready to move to Section 1.3.

If you have issues with installation, refer to the individual tool manufacturers.

## 1.2 Running the Example Tests on the Command Line
If you already have all the tools installed (Git, Java, Maven), you can follow the following instructions on any operating system to get running quickly.

1. On the command line change to the directory you wish to check the project out in and type `git clone https://github.com/dougnoel/sentinel.example.git`
2. In the sentinel.example/conf directory there are a number of example configuration files. Copy the one for your operating system to a file titled `sentinel.yml`. Ensure the browser listed is one installed on your system.
3. Change to the project `cd sentinel.example` and run `mvn test`. Provided that the configuration file exists, the project will run.

## 1.3 Setting up the Project in Eclipse (10 minutes)

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

Finally, a note about functional versus data testing. Functional testing is testing the functionality of your code. Data testing is testing the data your clients/customers/users are pushing through your system. Data testing is often conflated with functional testing to bloat tests. An example of functional testing is making sure that special characters are allowed in a password. An example of data testing is making sure that special characters are allowed for normal users, admin users and super users. There is no functional difference between the way these three user types log in to a site. However a business owner may have once had trouble logging in, and they want tests for each type of user. Doing so does not improve testing. In fact, it does quite the opposite. It makes testing take longer, creates fragility in the framework (more tests to fail), and causes more noise when a feature fails. 
If you tested all three scenarios, if one fails, they will all fail. It will appear to anyone who sees the results that three bugs were found, instead of just one. The counter argument to this is, "What if?" "What if one of the user roles does fail when the others pass?" In this case you log the bug and you discuss with your team why it happened, and how to prevent it in the future. Creating a test to cover this scenario is a band aid fix. The problem is architectural and should be addressed at that level. When you create a test, it should be atomic (meaning it doesn't rely on data from other scenarios) and unique.

## 2.1 Creating A Story and Task Tickets
The first test of any web site is logging into the site. So for our first test, we will be creating a login feature. We will be using the [New Tours Login](https://github.com/dougnoel/sentinel.example/issues/16) as an example. Clicking [this link](https://github.com/dougnoel/sentinel.example/issues/16) will take you to the ticket we created for our example feature. The first thing to do will be to create a similar ticket in your ticketing system, but instead of for the New Tours web site, make it for the web site you are testing. We are going to make two initial tests - one for a [successful login](https://github.com/dougnoel/sentinel.example/issues/17), and one for a [failed login](https://github.com/dougnoel/sentinel.example/issues/18). Create two tasks on your login story to track these. (If your system doesn't have tasks, just create two additional tickets as we have done and reference them in your parent story.)

These tickets don't have to be perfect. Copy what you see and make your best guess to modify them for your own system. We can update the tickets as we refine the steps, so it isn't important to get them right the first time. In fact, most of the time you will be tweaking the tickets as you implement your automation. It's good to get used to that now. Later on we will be going into more detail about the specifics of the Gherkin language.

## 2.2 Creating a Cucumber Test
Now that we have a ticket created, we can creature our first feature file. It's important to note that we use what Cucumber calls a feature file to match what Agile typically calls a story. Depending on where you work, a story may roll up to an epic, or it may roll up to a feature, then an epic, or something else. For our purposes, a feature file contains one story and a number of test scenarios. The purpose of this is to keep our tests as small an atomic as possible. If we let our feature files cover too much, they tend to get too complex, these slow our tetsing down, and feature creep starts over running our tests.

Feature file names should start with a story ticket number, then have the full text on the Summary field, followed by __.feature__ as the file extension. (NOTE: Any colons (:), forward slashes (/) or backward slashes (\) should be removed from the name of the file as they are not compatible across operating systems and can cause your tests to fail on other machines even if they do not fail on your machine.)

1. In the __Project Explorer__ expand __src/test/java__.
2. Right-click on the __features__ folder and select __New -> Other...__.
3. In the dialog that appears, expand the __General__ folder and select __File__ then click the __Next__ button.
3. Enter the Jira Ticket Number Story summary and .feature in the __File Name__ box. (ex. `US1234 User Story Name.feature`) (_Make sure there are no spaces at the beginning or end of the feature file._)
4. Click the __Finish__ button.
5. Paste the following into the editor, replace everything in {} with the requested information, and save the file.

```
#Author: {your.email@yourdomain.com}

@{StoryTicketNumber}
Feature: {StoryTicketNumber} {Subject of your Ticket}
  {Copy the Description field form the ticket here.}
  
  @{Task1TicketNumber}
  Scenario: {Task1TicketNumber} Successful Login
    Given I am on the {Name of your App/Website} Login Page
    When I fill the account information for account RegularUser into the Username field and the Password field
      And I click the Login Button
    Then I am redirected to the {Name of your App/Website} Main Page
      And I verify the {element on your main page} exists
      But I verify the Login Button does not exist

  @{Task2TicketNumber}
  Scenario Outline: {Task2TicketNumber} Failed Login
    Given I am on the {Name of your App/Website} Login Page
    When I fill the account information for account <User> into the Username field and the Password field
      And I click the Login Button
    Then I verify a Failure Message exists
    
    Examples:
      | User        |
      | BadUsername |
      | BadPassword |
```

### 2.2.2 Feature Section
A feature is equal to an agile story. This equivalence is made to keep your feature files manageable. If your feature files are too large, this is an indication that either you are not using them correctly (multiple stories per story), your stories are too large (something to bring up with your team), or you are not pruning old tests. When adding a story that modifies an existing, story do not add in all the same tests again. Instead, use the power of tagging to tag the other features or scenarios affected with additional tags (see below about tags). If a feature is removed - remove the tests.

```
#Author: {your.email@yourdomain.com}

@{StoryTicketNumber}
Feature: {StoryTicketNumber} {Subject of your Ticket}
  {Copy the Description field form the ticket here.}
```

Each feature file starts with the keyword **Feature:**. For consistency, we use the same name as the feature file name, starting with the ticket number, and then using the story name. This accomplishes a number of things. First, when a feature fails, the ticket number is visible in the test results. Because the numbers match, it is easy to find the test file to edit. Furthermore, it is easy to find the original story in our ticketing system. The number is right there in our test results.

With a little pre-planning, the results can be even *more* useful! If the developers use the ticket number when checking in their code, it is much easier to determine what area of code might have been affected when hunting down the cause of an error. Additionally, if we **tag** the feature with the ticket number, when the developer fixes the issue, they can test it using the ticket number as a tag to test only that file, and quickly determine if it has been fixed. (Read more about this in Section 3.) To tag a feature, we add the tag we want to use with an @ in front of it on the line above the **Feature:** keyword, If we want to add multiple tags, we separate them with commas like so: `@tag1, @tag2`

In this section we also demonstrate a comment line at the beginning of a file. While it isn't necessary to add comments, they can be helpful to tell someone what you intended. They can be added to any line in a feature file and will be ignored by the code. In this case we are recording who made this file, just in case someone has a question about it later, we make it a little easier for them to reach out to us.

You can also paste in the description of the ticket. As long as none of the Cucumber keywords are at the beginning of lines. The text you put here can show up in test results and gives you context about what is supposed to happen without having to look up the original ticket. IF the description is more than a paragraph or two though, it might be better just to let people refer to the ticket and leave this section blank.

### 2.2.3 Background Section
```
  Background:
    Given I am on the {Name of your App/Website} Login Page
```
A background section is something you can add at the top of a feature file like a scenario. It will be run before every scenario in the file. We are not doing this here because it has limited utility. You can read more about the background keyword [here](https://cucumber.io/docs/gherkin/reference/)].

### 2.2.4 Scenario Section
A scenario is a use case, or test case, for a given story. It should be atomic and unique. This means that it should not rely on data being set up outside of itself, and it should not duplicate the steps of another test with slightly different results. A common mistake is in thinking that because automated testing can easily test every iteration of a data set, that it should.

A scenario is intended to be easily readable by humans - not just the automation. Taking care to write good looking tests makes them easily readable by people. 50% of the time, the person you and formatting it for is your future self. When you come back to read a test, you do not want to spend a lot of time figuring out what is going on. The indentation is intended to make your tests easy to understand. It is also intended to make them look professional to the business when they see the test results. You wouldn't send an email to someone in the business that had poor spelling and punctuation and no paragraph breaks. The formatting of your tests is a reflection on your own communication skills. This is especially important if your first language is not English. Formatting your tests well will make you look more professional. The steps themselves already enforce good grammar and spelling.

```
  @{Task1TicketNumber}
  Scenario: {Task1TicketNumber} Successful Login
    Given I am on the {Name of your App/Website} Login Page
    When I fill the account information for account RegularUser into the Username field and the Password field
      And I click the Login Button
    Then I am redirected to the {Name of your App/Website} Main Page
      And I verify the {element on your main page} exists
      But I verify the Login Button does not exist
```
      
A scenario starts with the keyword **Scenario:** and is indented from the Feature by one line. It is followed by a ticket number representing the task ticket created, and the name of that ticket, which should be the test performed. Just like with the feature section, we can add tags to a scenario. In this case we want to tag the task ticket number. In fact, beyond being able to track our work and/or divide it up with other people, the primary reason for creating a task ticket is so that we have a uniquely generated tag that has meaning to attach to the scenario. This makes it easy to look up in the ticketing system and tie to a story, and it allows us to re-run a specific test by using that task ticket number.

Just like with the feature section, the scenario section can have description test over multiple lines directly underneath the header. However the only description you need in your scenario task ticket are the acceptance criteria, so there is never a need to have anything here. As a best practice we will leave it out.

Each line after a scenario that starts with one of our cucumber step keywords is interpreted and tied to code to run. The allowable keywords are: Given, And, When, Then, But. We will discuss each of them individually. The first letter of each keyword is capitalized because it is the beginning of a sentence. Our sentences do not end in punctuation. This is a Cucumber convention that we follow. Functionally, these five keywords are to make our tests easier for *people* to read them. The interpreter makes no distinction between `Given I click the login button` and `When I click the login button` - it will attempt to click the button either way.

All the steps available are documented in the [Sentinel Javadocs](https://dougnoel.github.io/sentinel/). They can be found in the com.dougnoel.sentinel.steps section under BaseSteps and VerificationSteps.

#### 2.2.4.1 Given Keyword
The **Given** keyword indicates the setup for a test. Typically the first step for us will be opening up a web browser and navigating to our starting page. This is accomplished by saying something like: `Given I am on the MyApp Login Page`. This step does a number of things. It tells the Page Manager that we need a copy of the MyApp Login Page. The name of this page must match the capitalization and spelling of our page object (which we will define in Section 2.3). Any spaces in the name will be deleted, so that we can make this step look human readable. Again, the goal here is for these steps to make sense to someone reading them so that they can follow them to manually test.

The Page Manager takes the name given and finds the page object we have created. It then looks for a page object configuration file (which we will create in Section 2.4) and finds the page URL based on the test environment provided (see Section 2.5). The page manager calls the WebDriver manager and asks it to open up the browser requested (see Section 2.6) and navigate to the URL.

All this happens behind the scenes. A human reading that file would see the step and know that they need to go to that page in their browser. They would ask the questions about environment, get the correct URL and navigate to it without needing to be told to do all of those steps. So, we can safely [encapsulate](https://en.wikipedia.org/wiki/Object-oriented_programming#Encapsulation) all of those steps into one step definition.

If we had additional steps to complete our setup (say logging in on a more complex test, or navigating to a different page once logged in), these steps would be placed on subsequent lines using the **And** keyword.

#### 2.2.4.2 And Keyword
The **And** keyword is used when we chain multiple Cucumber steps together to create complex Given, When or Then blocks. It is always indented underneath the keyword it follows.

In our example above, we are using it to click an element: `And I click the Login Button` When we reference an element in a cucumber step, we rely on helper code. We call getElement() which takes the text "Login Button", makes it lower case and replaces the spaces with underscores. It then asks the Page Manager what page we are on and looks to see if that page defines the element we have requested and returns it. Then our step manipulates the element - in this case, clicking on it.

#### 2.2.4.3 When Keyword
The **When** keyword starts the tests steps themselves. In our example above, we used  `When I fill the account information for account RegularUser into the Username field and the Password field`. This is straightforward to any person reading it, though there is a lot of implementation details hiding under the surface. The code goes and asks the Page Manager if it has details for a user called RegularUser. The Page Manager calls the Configuration Manager which looks for a configuration file for the page (which we will set up in Section 2.4). The Configuration Manager finds the real username and the password associated with RegularUser to enter into the two elements, "Username field" and "Password field". Just like our button click above, we ask for these elements. This time we use getElementAsTextbox() because we want to type in them, something you cannot just do with any element. The automation types them into the two fields on the page for us.

This step may seem overly complex, but it solves a couple of problems. First, the actual user name and password we are using are not in the steps so that we do not accidentally give away login names or passwords to people by having them in test cases or test results. But the real power is that we can store a different user name and password for RegularUser for each of our environments. Additionally if a password changes for an account, we only have to change it in one place, and all the tests that log in as that user immediately get the change. This is an example of having [DRY](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself) code.

#### 2.2.4.4 Then Keyword
We use **Then** as a keyword to indicate the part of the test that contains validations. All the possible validations are contained in the [Sentinel Javadocs](com.dougnoel.sentinel.steps) in the VerificationSteps section. When this section of a test fails, it indicates that functionality is not working as expected. It could be a bug. It could be that the functionality has changed and the test needs to be updated. We are going to look at two validations.

The first validation is, `Then I am redirected to the MyApp Main Page`. This step tells the Page Manager that we have moved to a new page. If you do not use this step, and you are on a new page, *your test will fail.* It does not actually do any checking. (This will be changed in [Sentinel Issue #78](https://github.com/dougnoel/sentinel/issues/78)

The second validation reads something like, `And I verify the Header Div exists`. This step validates that an element we have defined as "Header Div" exists on the page.
      
#### 2.2.4.5 But Keyword
The **But** step is typically used for negative validations that follow a **Then** step. It is helpful in indicating expected [negative test cases](https://en.wikipedia.org/wiki/Negative_testing). Our example, `But I verify the Login Button does not exist` is a contrived example. It uses the same code as our `And I verify the Header Div exists`. When we use the words "does not exist" instead of "exists", we are asking to validate the opposite result. The code goes down a different track and calls a special method that quickly fails when an element doesn't exist instead of waiting 10 seconds or more to fail.

### 2.2.5 Scenario Outlines
A Scenario Outline allows us to pass variables into our test scenarios. They should be used sparingly because they can be used incorrectly to enable data testing instead of focusing on functional testing.

```
  @{Task2TicketNumber}
  Scenario Outline: {Task2TicketNumber} Failed Login
    Given I am on the {Name of your App/Website} Login Page
    When I fill the account information for account <User> into the Username field and the Password field
      And I click the Login Button
    Then I verify a Failure Message exists
    
    Examples:
      | User        |
      | BadUsername |
      | BadPassword |
```

In addition to using the keyword **Scenario Outline:** a Scenario Outline must have an **Examples:** Section which should be indented at the same level as the other keywords (Given, When, Then, And, But). The variables are indented another level. They are contained in a table made with pipes |. 

## 2.3 Creating a Page Object
A page object holds all of the information needed for the automation tool to locate the elements of a page on a web page. Each element is given a human readable name, and then it is linked to a way to find that element on a web page. Sentinel then utilizes the powerful Selenium Webdriver to find these elements. However, Sentinel then wraps those locators in code that solves a number of common problems people using Selenium typically encouner, such as needing to wait for a page to load, an element changing on the page, and optimizing this search so that it takes as little time as possible.

1. In the __Package Explorer__ expand __src/main/java__.
2. Right-click on the __com.com.dougnoel.sentinel.<projectname>.pages__ package and select __New -> Class__.
3. Using [Pascal Case](https://en.wikipedia.org/wiki/Camel_case) name your page object something that would make sense to a business owner, ending in the word __Page__. Enter this into the __Name__ field.
4. In the __Superclass__ field, paste the following: `com.dougnoel.sentinel.pages.Page`
5. Click the __Finish__ button.
6. Your new class file will open with a .java extension.

```
public class NewToursMenuPage extends Page {
	public Link register_menu_link() { return new Link(TEXT, "REGISTER"); }
}
```

### 2.3.1 Web Element Selectors
Sentinel supports all the web element selector options that Selenium supports.
https://www.browserstack.com/guide/findelement-in-selenium

#### 2.3.1.1 Inspecting a Web Page in Chrome
Before we can create a Page Element, we need to find an element on a web page.
1. Open up your web page in Chrome.
2. Right-click on the element you want to use to create a Page Element and select __Inspect__. The Chrome debug console will appear.
3. Examine the element and determine how you want to identify it. (See the next few sections for all the possible identifiers.)

### 2.3.1.2 Using an ID

```
package pages;

public class MyNewPage extends Page {
	public Div google_map() { return new Div(ID, "map"); }
}
```

`new Textbox username_field() { return new Textbox(ID, "my_id"); }` 

### 2.3.1.6 Using an XPath
`new Textbox username_field() { return new Textbox(XPATH, "//div[@id='login_button_container']//form/input[1]"); }`

## 2.4 Creating a Page Object Configuration File
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

### 2.4.1 Configuring A Page's URLs by Environment
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

### 2.4.2 Configuring Test Users by Environment

1. Open your PageName.yml file for the page you want to have users.
2. Add in default users.

## 2.5 Setting Your Test Environment

## 2.6 Running Your First Test
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

### 2.6.1 Executing tests using JUnit

1. Create a package in src/test/java called "tests".
2. Create a java file in the packages with the name "Test" in it. (E.G. TestRun.java)

#### 2.6.2 Setting the Test Environment

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

## 2.7 Using Object Inheritance to Create Page Parts

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

## 3.4 Debugging Tools

### 3.4.1 Running Specific Features or Scenarios

### 3.4.2 Running Tests Against a Local Dev Server

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
#language: en
#Author: ty.pixelplane@gmail.com

@239
Feature: 239 Implement WinAppDriver to automate windows
  As a user I want to be able to automate Windows 10 OS, 
  so that I can automate things that cannot be automated in the browser.
  
  @239A, @TextEntry  
  Scenario: 239A Use Notepad
  	Given that I open "C:\\Windows\\System32\\notepad.exe"
  	When I enter "test" into the "Text Editor" field
  	Then I expect that "Text Editor" contains "test"

  @239B, @ButtonInteraction
  Scenario: 239B Use Calculator
  	Given that I open "C:\\Windows\\System32\\win32calc.exe"
  	When I press the "1" button
  	  And I press the "Add" button
  	  And I press the "2" button
  	  And I press the "Equals" button
  	Then I expect that "Result" contains "3"
  	
  @239C
  Scenario: 239C Navigate to a curation set
  	Given that I open "C:\Users\tbouchard\AppData\Local\ManualCurationToolsAlpha\ManualCurationTools.App.exe"
  	When the window "Sample Set" opens
  	  And I enter "22793" into the "//*[@AutomationId=\"SampleSetIdTextBox\"]" xpath
  	  And I press the "//*[@AutomationId=\"SampleSetButton\"]" xpath button
  	  And the window "22793" opens
  	  And I press the "Peak Transformer" button
  	  And the "Ion Visualizer" button should exist
  	  And I press the "Ion Visualizer" button
  	Then the "Peak Transformer" button should exist
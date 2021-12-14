#Author: ty.pixelplane@gmail.com

@239
Feature: 239 Implement WinAppDriver to automate windows
  As a user I want to be able to automate Windows 10 OS, 
  so that I can automate things that cannot be automated in the browser.
  
  @239A, @TextEntry  
  Scenario: 239A Use Notepad
  	Given that I open Notepad.exe
  	When I enter "text" into the main window
  	Then I verify that the main window contains "text"

  @239B, @ButtonInteraction
  Scenario: 239B Use Calculator
  	Given that I open Calculator.exe
  	When I press the one button
  	  And I press the plus button
  	  And I press the two button
  	  And I press the equals button
  	Then I expect the result pane to contain the output "3"
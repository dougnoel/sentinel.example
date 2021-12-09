#language: en
#Author: Tyler Bouchard
@239
Feature: 239 Initial WinAppDriver Implementation
  
	@239A  
	Scenario: 239A Use Notepad
		Given that I open Notepad.exe
		When I enter "text" into the main window
		Then I verify that the main window contains "text"

	@239B
	Scenario: 239B Use Calculator
		Given that I open Calculator.exe
		When I press the 1 button
			And I press the + button
			And I press the 2 button
			And I press the = button
		Then I expect the result pane to contain the text "3"
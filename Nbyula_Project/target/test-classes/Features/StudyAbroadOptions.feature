@senario3

Feature: To get names of all the Options under Study Abroad Hover button.

Scenario Outline: get all options in Study Abroad
Given User navigates to " https://nbl.one" and clicks on signin button
And user logins with valid "polukurisrinivasreddy1998@gmail.com" and "Srinivas@1998" 
When user scrolls down and hovers on StudyAbroad
Then User retrives all options
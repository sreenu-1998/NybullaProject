@senario1
Feature: Verify atleast one quest is available

Scenario: one quest available
Given user is one homepage "https://nbl.one"
And hovers to explore button and clicks on quest
When atleast one quest found 
Then user closes website
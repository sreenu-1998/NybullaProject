@senario2

Feature: Book a Listing.

Scenario Outline: Book a Listing
Given user navigates to "https://nby.la/rdJuXp "
And cicks on signin button.
And user clicks on see other login options in the pop up
And user provides "srinivasreddy7411@gmail.com" and clicks on Continue
And user provides "Srinivas@1998" and clciks on Continue 
And user logs in to application succcessfully
And user is on booking page and clicks on book a seat
And user clicks on Proceed
And user clicks on Confirm free booking
When user provides "<mobileNo>" and clicks continue
Then Listing is booked successfuly

Examples:
|mobileNo|
|9999999998|


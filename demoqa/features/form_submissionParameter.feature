#As an automation tester
#I want to fill in and submit the form on the demoqa.com website with the details:
#First Name - Jane
#Last name - Smith
#Email address - automation-test@tester.com
#Phone number - 1234567891
#So that I can make sure the form is being completed and showing the correct user details

  Feature: Fill and submit the form in demoqa.com
    Scenario: Submit the form with the given details
      Given Open the browser
      And Click on Forms
      And Click on Practice Form
      And user enters the First Name, Last Name, Email and Phone number
      When Click on Submit button
      Then Confirmation window should be displayed

    Scenario Outline: Submit the form
      Given Open the browser
      And Click on Forms
      And Click on Practice Form
      And user enters <FirstName> and <LastName> and <Email> and <Phone>
      When Click on Submit button
      Then Confirmation window should be displayed
      Examples:
        | FirstName | LastName | Email                      | Phone      |
        | Jane      | Smith    | automation-test@tester.com | 1234567891 |
        | P         | Raju     | Joe_PRaju@tester.com       | 0011223344 |

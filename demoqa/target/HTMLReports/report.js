$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/form_submissionParameter.feature");
formatter.feature({
  "name": "Fill and submit the form in demoqa.com",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Submit the form with the given details",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Open the browser",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.FormSubmit.open_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Forms",
  "keyword": "And "
});
formatter.match({
  "location": "steps.FormSubmit.click_on_Forms()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Practice Form",
  "keyword": "And "
});
formatter.match({
  "location": "steps.FormSubmit.click_on_Practice_Form()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters the First Name, Last Name, Email and Phone number",
  "keyword": "And "
});
formatter.match({
  "location": "steps.FormSubmit.user_enters_the_First_Name_Last_Name_Email_and_Phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Submit button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.FormSubmit.click_on_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Confirmation window should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.FormSubmit.confirmation_window_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Submit the form",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Open the browser",
  "keyword": "Given "
});
formatter.step({
  "name": "Click on Forms",
  "keyword": "And "
});
formatter.step({
  "name": "Click on Practice Form",
  "keyword": "And "
});
formatter.step({
  "name": "user enters \u003cFirstName\u003e and \u003cLastName\u003e and \u003cEmail\u003e and \u003cPhone\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "Click on Submit button",
  "keyword": "When "
});
formatter.step({
  "name": "Confirmation window should be displayed",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "FirstName",
        "LastName",
        "Email",
        "Phone"
      ]
    },
    {
      "cells": [
        "Jane",
        "Smith",
        "automation-test@tester.com",
        "1234567891"
      ]
    },
    {
      "cells": [
        "P",
        "Raju",
        "Joe_PRaju@tester.com",
        "0011223344"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Submit the form",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Open the browser",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.FormSubmit.open_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Forms",
  "keyword": "And "
});
formatter.match({
  "location": "steps.FormSubmit.click_on_Forms()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Practice Form",
  "keyword": "And "
});
formatter.match({
  "location": "steps.FormSubmit.click_on_Practice_Form()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters Jane and Smith and automation-test@tester.com and 1234567891",
  "keyword": "And "
});
formatter.match({
  "location": "steps.FormSubmit.user_enters_FirstName_LastName_Email_Phone(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Submit button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.FormSubmit.click_on_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Confirmation window should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.FormSubmit.confirmation_window_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Submit the form",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Open the browser",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.FormSubmit.open_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Forms",
  "keyword": "And "
});
formatter.match({
  "location": "steps.FormSubmit.click_on_Forms()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Practice Form",
  "keyword": "And "
});
formatter.match({
  "location": "steps.FormSubmit.click_on_Practice_Form()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters P and Raju and Joe_PRaju@tester.com and 0011223344",
  "keyword": "And "
});
formatter.match({
  "location": "steps.FormSubmit.user_enters_FirstName_LastName_Email_Phone(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Submit button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.FormSubmit.click_on_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Confirmation window should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.FormSubmit.confirmation_window_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
});
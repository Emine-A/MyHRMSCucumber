
Feature: Delete Employee
Background:
Given user generates token

@SyntaxHRMSAPIEndToEnd22
Scenario:
Given User call DeleteEmployee API
When User retrieve response for delete
Then Status code is 200 for deleting
And User validates employee delete

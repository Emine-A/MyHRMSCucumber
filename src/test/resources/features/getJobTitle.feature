
Feature: Get allJobTitle
Background: 
Given user generates token

@GetJobTitle
Scenario: Get allJobTitle
Given User call for allJobTitle API
When User retrieve for allJobTitle
Then Status code is 200
And  Getting allJobTitle



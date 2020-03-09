Feature:
Background:
Given user generates token
@GetAllEmployee
Scenario: Get all employee
Given User call allEmployee API
When User retrive response for allEmployee
Then AllEmploye Status code is 200
And User validates get allEmployee   

#Feature: report
#
#Background:
#Given I am logged into HRMS
#And I navigated to the reports page
#
#Scenario Outline: Search for invalid report
 #When I enter invalid "<reportName>" report
#And I click search button
#Then I see "No Records Found" error message
#
#Examples:
#| reportName |
#| Smoke      |
#| Regression |
#
#
#Scenario: Search for valid report
#When I enter valid "Sample Report" report
#And I click search button
#Then I see the search "Sample Report" report is displayed
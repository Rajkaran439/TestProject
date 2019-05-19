
Feature: Testing amount on payment page and this page is equal
@bus
  Scenario: Validation amount from 2 pages
    Given User opens browser and url
    Then User enter "Mumbai(All locations)" in source 
    Then User enter "Nashik(All Locations)" in destination 
    Then user select the date
    Then user search for the buses
    Then user select time as After6pm
    Then user select bus type as NonAc
    Then user search for the seats
    Then User select the seats
    Then User select the boarding and dropping point
    Then user get the Fare value
    Then user navigate to proceed to book button 
    Then user will not opt for insurance
    Then user will verify fare on different pages
    
  
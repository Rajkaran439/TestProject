Feature: Verify hotel displayed are of Andheri location
@hotel
  Scenario: Location based hotel verification
  
    Given User opens browser and url
    When user click on hotel link
    Then user enter "Mumbai" in hotelarea searchbox
    Then user select Location as andheri
    Then user verify hotel displayed are of Andheri location
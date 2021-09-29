Feature: Cart
  I want to use this template for my feature


  
 
    Scenario: Test login with some credentials
    Given user open prospect application for "Env"
    When user Select Devices and Accessories
    And user Select Plans as "Plan" and Protection as "Protection" 
    Then user should land on shopping page
    

       Scenario: Test login with valid credentials
    Given user open prospect application for "Env"
    When user Select Devices and Accessories
    And user Select Plans as "Plan" and Protection as "Protection" 
    Then user should land on shopping page
    
   
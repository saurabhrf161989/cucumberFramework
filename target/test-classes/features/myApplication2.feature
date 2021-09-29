Feature: Cart2
  I want to use this template for my feature


  
 
    Scenario: User open prospect
    Given user open prospect application for "Env"
    When user Select Devices and Accessories
    And user Select Plans as "Plan" and Protection as "Protection" 
    Then user should land on shopping page
    

       Scenario: user add device
    Given user open prospect application for "Env"
    When user Select Devices and Accessories
    And user Select Plans as "Plan" and Protection as "Protection" 
    Then user should land on shopping page
    
   
Feature: Multiple windows features

  @Smoke
  Scenario Outline: Testing multiple windows functionality
    Given User is on A/B Test variation page
    When User clicks on Elemental Selenium link
    Then User should navigate to Elemental Selenium page
    Then User fills "<E-mail>" and select the language
    And Clicks on Send me Test Auotomation Pro tip button
    And Close the browser

    Examples: 
      | E-mail                 |
      | madhurajak17@gmail.com |

  @Regression
  Scenario: Testing a Demo Page with all types of functions
    Given User is on DemoPage
    When USer enter Text in Text input field and Text Area
    And User verify if Pre-Filled Text Field has the text or not
    Then User clicks on button
    And User clicks on Placeholder text field
    And User read the test from Read only Text filled
    Then user clicks on HTML SVG with rect
    And user slides the Input Slider Control
    Then User select option from Select dropdown
    And user clicks and checks radio button and checkBox
    Then user clicks on CheckBox in iFrame
    Then user clicks on URL Link and verify the page

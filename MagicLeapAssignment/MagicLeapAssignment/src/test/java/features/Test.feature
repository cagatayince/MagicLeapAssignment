#Author: Cagatay Ince (cagatayince@gmail.com)
@tag
Feature: Keep In Touch Feature
  Verify if user is able to subscribe to the MagicLeap

  Scenario: Subscribe Successfully
    Given User is on homepage
    And Magic Leap One Creation Edition is exist
    When User navigates to Keep In Touch Segment
    And User enters Email as "cagatayince@hotmail.com"
    And User enters Name as "Cagatay Ince"
    And User select the InterestedIn as "I'm a developer"
    And User Click Submit
    Then User should see the success message

  Scenario: Check the Subscription message is not wrong.
    Given User is on homepage
    When User navigates to Keep In Touch Segment
    And User enters Email as "cagatayince@hotmail.com"
    And User enters Name as "Cagatay Ince"
    And User select the InterestedIn as "I'm a developer"
    And User Click Submit
    Then User should not see the wrong success message

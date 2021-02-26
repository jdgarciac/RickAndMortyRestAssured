Feature: Get single character information
  As a user
  I want to know a character information

  @ServiceGet
  Scenario: get single character information
    Given that user wants to consult a character
    When he consults the API
    Then the response of the service shows the character information


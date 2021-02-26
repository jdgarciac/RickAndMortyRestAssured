Feature: Get single location information
  As a user
  I want to know a location information

  @ServiceGet
  Scenario: get single location information
    Given that user wants to consult a location
    When he consults the location
    Then the response of the service shows the location information


Feature: Get single episode information
  As a user
  I want to know a episode information

  @ServiceGet
  Scenario: get single episode information
    Given that user wants to consult a episode
    When he consults the episode
    Then the response of the service shows the episode information


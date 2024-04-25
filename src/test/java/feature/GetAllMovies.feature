@GetMovieDataNegativeTestCase
Feature: Get Movie Data without passing headers

  Scenario: Get All movies data without passing headers
    Given The endpoint is given for movies
    When Hit the API for movies
    Then Validate the status code for movies
    Then Validate for negative Test Case
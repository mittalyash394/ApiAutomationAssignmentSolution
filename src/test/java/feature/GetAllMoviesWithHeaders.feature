@GetMovieDataPositiveTestCase
Feature: Get Movie Data without passing headers

  Scenario: Get All movies data with passing headers
    Given The endpoint is given for movies with headers
    When Hit the API for movies with headers
    Then Validate the status code for movies with headers
    Then Validate for positive Test Case with headers
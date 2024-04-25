@MovieListAndQuote
Feature: Get Movie List

  Scenario: Get the movie list and the quote from a movie
    Given The endpoint is given for movies list with headers
    When Hit the API for single movie "5cd95395de30eff6ebccde5d" with headers
    Then Verify the status code for single movie "5cd95395de30eff6ebccde5d" with headers
    Then Validate the flow for single movie "5cd95395de30eff6ebccde5d" with headers
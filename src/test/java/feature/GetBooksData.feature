@GetBooksData
Feature: Get Books Data

Scenario:To get the books count as 3.
  Given The endpoint is given
  When Hit the API
  Then Validate the status code for books API
  Then Count the number of items
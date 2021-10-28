@wip1
Feature: Teknasyon Page

  Scenario: Navigate to Teknasyon Webpage

    Given the user is on the "google"
    When the user enters "Teknasyon" into search bar to get "https://teknasyon.com"
    Then the user is on the "Teknasyon" home page


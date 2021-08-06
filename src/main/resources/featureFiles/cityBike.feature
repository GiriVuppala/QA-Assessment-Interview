Feature: CityBikes
  As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude

  Scenario Outline: verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude
    Given As a user I prepare the "GET" request body
    When I trigger the endpoint
    Then validate 200 response code
    And validate the response with "<country>" and "<city>" and Verify "<Latitude>" and "<Longitude>"
    Examples:
      | country | city          |Latitude    |Longitude   |
      |  NL     |Wageningen     |51.974      |5.6671      |
      |  BR     |Ipaússu        |-23.0553    |-49.6237    |

  Scenario: verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude
    Given As a user I prepare the "GET" request body
    When I trigger the endpoint
    Then validate 200 response code
    And validate the response with "DE" and "Frankfurt" and Verify "50.1072" and "8.66375"


  Scenario Outline: verify invalid Latitude and Longitude values
    Given As a user I prepare the "GET" request body
    When I trigger the endpoint
    Then validate 200 response code
    And validate the invalid response with "<country>" and "<city>" and Verify "<Latitude>" and "<Longitude>"

    Examples:
      | country | city    |Latitude|Longitude|
      |  DE     |Frankfurt|50.107 |8.6637  |


Feature: Validationg place API's


  @Addplace @regression
  Scenario: Verify that place successfully added using AddplaceAPI
    Given Add place payload with "<name>" "<language>" "<address>"
    When User call "AddplaceAPI" using "POST" request
    Then The API run successfully and got status code 200
    And Verify "status" in response body is "OK"
    And Verify "scope" in response body is "APP"
    And Verify the place-id created with "<name>" and "getPlaceAPI" from response


    Examples: 
      | name       |language |address         |
      #| SuryaHouse |English  |234 middle east |
      | PranHouse  |Hindi    |101 south west  |

      
      
  @Deleteplace @regression
  Scenario: Verify that place successfully deleted
    Given Delete place payload with place_id
    When User call "deletePlaceAPI" using "POST" request
    Then The API run successfully and got status code 200
    And Verify "status" in response body is "OK"

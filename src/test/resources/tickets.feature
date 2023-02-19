Feature: Tickets reservation

  Scenario: Successful ticket reservation
    Given flight info:
      | departure   | RIX        |
      | destination | SVO        |
      | discount    | fg123gg    |
      | adults      | 1          |
      | children    | 2          |
      | bags        | 4          |
      | flight date | 14-05-2018 |
      | seat        | 27         |

    And passenger info is:
      | first_name | Barsjusha |
      | last_name  | Kotovski  |

    And home page opened

    When we are selecting airports
    Then selected airports appears on the next page

    When we are filling in passenger registration form
    And requesting price
    Then passenger name and airports appears
    And price is 500 EUR

    When we are pressing Book button
    And selecting seat
    Then correct seat number appears

    When we are booking selected ticket
    Then successful registration message appears

    When we are requesting reservations data
    Then current reservation is in the list
    And all reservation data is correct


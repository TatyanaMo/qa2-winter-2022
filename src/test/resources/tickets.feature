Feature: Flight tickets

  Scenario: Reservation ticket
    Given the website: www.qaguru.lv:8089/tickets/
    When we are filling all necessary information about route:
      | airport from | MEL |
      | airport to   | CPT |
    Then airports should be selected and passenger info page opens

    When we are filling all necessary information about passenger:
      | first name      | Barsjusha |
      | second name     | Kotovski  |
      | discount number | fg123gg   |
      | adults          | 1         |
      | children        | 0         |
      | bags            | 1         |
      | flight date     | 13        |
    Then passenger information saved and seat selection page opens

    When we are filling all necessary information about seat in a plane:
      | seat number | 6 |
    Then confirmation about successful reservation apears
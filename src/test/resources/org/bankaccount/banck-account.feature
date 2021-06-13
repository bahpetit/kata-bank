Feature: Bank Account

  Scenario: Deposit 20 euros and ask the statement balance
    Given I deposit 20 euros
    When I ask the statement
    Then My balance should be 20

  Scenario Outline: Deposit / Withdraw
    Given I deposit <deposit> euros
    When I withdraw <withdraw> euros
    And I ask the statement
    Then My balance should be <balance>

    Examples:
      | deposit | withdraw | balance |
      | 12 | 5 | 7 |
      | 5 | 10 | -5 |

  Scenario: Multiple Deposit / Withdraw and ask the statement balance
    Given I deposit 20 euros on "12/06/2021"
    And I deposit 10 euros on "13/06/2021"
    And I withdraw 5 euros on "14/06/2021"
    When I see the history of my operations
    Then The history should be
      | operation | date | amount | balance |
      | Deposit | 12/06/2021 | 20 | 20 |
      | Deposit | 13/06/2021 | 10 | 30 |
      | Withdraw | 14/06/2021 | 5 | 25 |
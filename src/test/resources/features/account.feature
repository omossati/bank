Feature: Account operations

  Scenario: Deposit money into account
    Given I have a new bank account
    When I deposit 1000 into the account
    Then the balance should be 1000

  Scenario: Withdraw money from account
    Given I have a new bank account
    And I deposit 500
    When I withdraw 200
    Then the balance should be 300

  Scenario: Attempt to withdraw more than balance
    Given I have a new bank account
    And I deposit 100
    When I try to withdraw 200
    Then I should get an error "Insufficient balance"

  Scenario: Attempt to deposit a negative amount
    Given I have a new bank account
    When I try to deposit -500
    Then I should get an error "Amount must be positive"

  Scenario: Attempt to withdraw a negative amount
    Given I have a new bank account
    When I try to withdraw -100
    Then I should get an error "Amount must be positive"

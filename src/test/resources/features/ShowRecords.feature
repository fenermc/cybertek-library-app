Feature: show records functionality

  @librarianUser
  Scenario: verifying default value in users page when I click pn "users" link
    Given I am the login page
    And I login as a librarian
    When I click  on "Users" link
    Then show records default value should be 10
    And show records should have following options:
      | 5  |
      | 10 |
      | 15 |
      | 50 |
      | 100 |
      | 200 |
      | 500 |
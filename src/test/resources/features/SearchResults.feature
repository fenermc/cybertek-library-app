Feature:
  As a user, when I  login as librarian and  I go to Users page, table should have following columns:
@followingColumns
  Scenario: Table columns names
    Given I am the login page
    And I login as a librarian
    When I click  on "Users" link
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |
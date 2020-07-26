Feature: login with parameters

@librarianParam
  Scenario: Login as librarian 43
    Given I am the login page
    When I enter username "librarian43@library"
    And I enter password 'np6AxVIh'
    And click the sign in button
    Then dashboard should be displayed
    And there should be "705" users

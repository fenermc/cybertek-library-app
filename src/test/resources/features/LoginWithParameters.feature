Feature: login with parameters

  @librarianParam
  Scenario: Login as librarian 43
    Given I am the login page
    When I enter username "librarian43@library"
    And I enter password 'np6AxVIh'
    And click the sign in button
    And there should be 705 users
    Then dashboard should be displayed

  @studentParam
  Scenario: Login as student 10
    Given I am the login page
    When I enter username "student108@library"
    And I enter password 'uFg5d3nH'
    And click the sign in button
    Then books  should be displayed

@wip
  Scenario: Login as librarian same line
    Given I am the login page
    When I login using "librarian12@library" and "AOYKYTMJ"
    Then dashboard should be displayed
      #number can be whatever you have there

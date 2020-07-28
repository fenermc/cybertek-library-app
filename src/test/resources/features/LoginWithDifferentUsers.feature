Feature:
  As a user, I should be able to login with different users using their correct emails
  and passwords. When I login,I should be able to see username in the account username section.

  Scenario Outline: Verify user information <email>
    Given I am the login page
    When I login using "<email>" and "<password>"
    Then account holder name should be "<name>"
    Examples:
      | email             | password | name            |
      | student27@library | kkMksO2i | Test Student 27 |
      | student28@library | 19Ceq2sT | Test Student 28 |
      | student29@library | WyIUNpDI | Test Student 29 |
      | student30@library | IaT9YI0I | Test Student 30 |
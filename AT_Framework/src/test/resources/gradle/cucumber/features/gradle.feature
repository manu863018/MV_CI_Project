Feature: Gradle-Cucumber integration
  Scenario: Just a failing scenario
    Given A failing scenario
    When I run a failing step
    Then I got a failing step

  Scenario: Second Test
    Given A passing scenario
    When I run a passing step
    Then I got a passing step



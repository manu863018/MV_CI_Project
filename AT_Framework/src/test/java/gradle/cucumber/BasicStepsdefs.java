package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;

public class BasicStepsdefs {
	@Given("A failing scenario")
	public void a_failing_scenario() {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();
	}

	@When("I run a failing step")
	public void i_run_a_failing_step() {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();
	}

	@Then("I got a failing step")
	public void i_got_a_failing_step() {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();
	}

	@Given("A passing scenario")
	public void a_passing_scenario() {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();
	}

	@When("I run a passing step")
	public void i_run_a_passing_step() {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();
	}

	@Then("I got a passing step")
	public void i_got_a_passing_step() {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();
	}	
}

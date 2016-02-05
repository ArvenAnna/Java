/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.testfinance.steps;

import anna.testfinance.steps.serenity.ExchangeRateUserSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ExchangeRateSteps {
    
    @Steps
    ExchangeRateUserSteps exchangeRateUser;
    

    @Given("the user is on the Finance home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        exchangeRateUser.is_the_home_page();
    }

    @When("the user clickes '$currency'")
    public void whenTheUserLooksUpTheDefinitionOf(String currency) {
        exchangeRateUser.starts_choose(currency);
    }

    @Then("he should see that $extreme exchange rate in '$operationtype' table-column is equal to calculated value")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String extreme, String operationtype) {
        exchangeRateUser.should_be_equal_to_column_calculations(extreme, operationtype);
    }
}

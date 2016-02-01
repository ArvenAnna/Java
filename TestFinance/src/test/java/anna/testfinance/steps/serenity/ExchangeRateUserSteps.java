/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.testfinance.steps.serenity;

import anna.testfinance.pages.FinanceExchangeRatePage;
import static junit.framework.Assert.assertEquals;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 *
 * @author Alex
 */
public class ExchangeRateUserSteps extends ScenarioSteps{
    
    FinanceExchangeRatePage financeExchangeRatePage;

    @Step
    public void starts_choose(String currency) {
        financeExchangeRatePage.currency_choose(currency);
    }

    @Step
    public void is_the_home_page() {
        financeExchangeRatePage.open();
    }

    @Step
    public void should_be_equal_to_column_calculations(String extreme, String operationtype) {
        Integer valueFromPage = financeExchangeRatePage.getExtremeValueFromPage(extreme, operationtype);
        Integer calculated = financeExchangeRatePage.calculateExtremeValue(extreme, operationtype);
        assertEquals(calculated, valueFromPage);
    }
    
}

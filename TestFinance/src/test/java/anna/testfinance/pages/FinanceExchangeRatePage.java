/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.testfinance.pages;

import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Alex
 */
@DefaultUrl("http://finance.i.ua")
public class FinanceExchangeRatePage extends PageObject {

    @FindBy(css = ".navigation_tabs_rounded>li:nth-child(2)")
    private WebElement currency;

    public void currency_choose(String currency) {

        String currencyNumber = null;

        if (currency.equals("usd")) {
            currencyNumber = "1";
        }
        if (currency.equals("eur")) {
            currencyNumber = "2";
        }
        if (currency.equals("rub")) {
            currencyNumber = "3";
        }
        this.currency = find(By.cssSelector(".navigation_tabs_rounded>li:nth-child(" + currencyNumber + ")"));
        this.currency.click();
    }

    public Integer getExtremeValueFromPage(String extreme, String operationtype) {
        
        
        List<WebElementFacade> columnLabel = findAll(By.cssSelector("#feMain2>.local_table>tbody>tr>td:nth-child(1)"));
        List<WebElementFacade> column = chooseOperationType(operationtype);

        int extremeValue = 0;
        
        System.out.println(columnLabel.get(columnLabel.size()-4).getText());
        System.out.println(columnLabel.get(columnLabel.size()-3).getText());
        System.out.println(columnLabel.get(columnLabel.size()-2).getText());
        System.out.println(columnLabel.get(columnLabel.size()-1).getText());
        
        for(int i = 4; i>0; i--){
                if((columnLabel.get(columnLabel.size()-i).getText().equals("Максимальний"))
                        && (extreme.equals("maximal"))){
                    extremeValue = (int) (Double.parseDouble(column.get((column.size() - i)).getText()) * 10000);
                }
                if((columnLabel.get(columnLabel.size()-i).getText().equals("Мінімальний"))
                        && (extreme.equals("minimal"))){
                    extremeValue = (int) (Double.parseDouble(column.get((column.size() - i)).getText()) * 10000);
                }
                if((columnLabel.get(columnLabel.size()-i).getText().equals("Середній"))
                        && (extreme.equals("avarage"))){
                    extremeValue = (int) (Double.parseDouble(column.get((column.size() - i)).getText()) * 10000);
                }
                if((columnLabel.get(columnLabel.size()-i).getText().equals("Оптимальний"))
                        && (extreme.equals("optimal"))){
                    extremeValue = (int) (Double.parseDouble(column.get((column.size() - i)).getText()) * 10000);
                }
            }
        System.out.println(extreme + extremeValue);
        return extremeValue;
    }

    public Integer calculateExtremeValue(String extreme, String operationtype) {
        
        List<WebElementFacade> column = chooseOperationType(operationtype);
        int extremeValue = 0;
        
        int max = (int) (Double.parseDouble(column.get(0).getText()) * 10000);
        int min = (int) (Double.parseDouble(column.get(0).getText()) * 10000);
        int sum = 0;
                
        for (int i = 0; i < column.size(); i++) {
            int next = (int) (Double.parseDouble(column.get(i).getText()) * 10000);
            System.out.println(next);
            if (i < (column.size() - 4)) {
                sum = sum + next;
                if (next > max) {
                    max = next;
                }
                if (next < min) {
                    min = next;
                }
            }
        }
        if (extreme.equals("maximal")) {
            extremeValue = max;
        }
        if (extreme.equals("minimal")) {
            extremeValue = min;
        }
        if (extreme.equals("avarage")) {
            extremeValue = sum / (column.size() - 4);
        }
        if (extreme.equals("optimal")) {
            if(operationtype.equals("buy")){
                extremeValue = max;
            }
            if(operationtype.equals("sell")){
                extremeValue = min;
            }
        }
        System.out.println("Rozrahovane " + extremeValue);
        return extremeValue;
    }

    public List<WebElementFacade> chooseOperationType(String operationtype) {

        List<WebElementFacade> column = null;

        if (operationtype.equals("buy")) {
            column = findAll(By.cssSelector("#feMain2>.local_table>tbody>tr>td:nth-child(2)"));
        }
        if (operationtype.equals("sell")) {
            column = findAll(By.cssSelector("#feMain2>.local_table>tbody>tr>td:nth-child(3)"));
        }
        return column;
    }

}

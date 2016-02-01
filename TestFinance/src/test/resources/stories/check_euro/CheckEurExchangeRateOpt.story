Check euro exchange rate
Narrative:
In order to sell euro
As an user
I want to check correctness of exchange rates calculation

Scenario: Checking euro exchange rate 'optimal'
Given the user is on the Finance home page
When the user clickes 'eur'
Then he should see that optimal exchange rate in 'buy' table-column is equal to calculated value

Scenario: Checking euro exchange rate 'optimal'
Given the user is on the Finance home page
When the user clickes 'eur'
Then he should see that optimal exchange rate in 'sell' table-column is equal to calculated value


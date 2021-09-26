Feature: Validate the shopping cart and proceed to the Sign in section
    Scenario: Validate shopping cart
        Given Launch Application
        When search for summer dresses
        And Click on summer dresses result
        When Click on Add to cart button
        And Click on Processed to checkout button
        And Click on Processed to checkout button on Shopping Cart Summary page
        When User enters <username> and Password as <password> on Authentication Page
        And Click on Sign in button
        Then verify user can successfully sign in and lands on Address page to confirm the address


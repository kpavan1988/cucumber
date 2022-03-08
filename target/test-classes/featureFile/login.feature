
Feature: Regression
  I want to use this template for my feature file


  Scenario Outline: Login
    Given 	initailize the browser 
    And by using link "https://www.flipkart.com/"
    When CLick on login button 
    And Enter <username> and <password> submit
    And search the product and select the product
    And add to the cart and plac the order 
    Then user should go to home page
    
    Examples: 
       | username                | password    |
       |    pavanscoool@gmail.com| kpavan1988  |
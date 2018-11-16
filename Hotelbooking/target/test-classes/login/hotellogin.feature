#Author: your.email@your.domain.com

Feature: Login

  
  Scenario: check the heading of the login page
    Given User is on the login page
    Then check the heading of the page
    

  Scenario: successful login with valid data
  Given User is on the login page
    When user enters valid username,valid password
    Then navigate to hotel booking
  
  
  Scenario: Prompt user to enter the data when he leaves the login fields empty
  Given User is on the login page
  When user doesnot enter username or password
  And Clicks the login button
  Then display appropriate message
  
   Scenario: Unsuccesfull login due to incorrect username or password
  Given User is on the login page
  When user enters incorrect username or password
    Then displaylogin failed message
   
 
  

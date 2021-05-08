CONTORION TASK
----------
###### Cengiz Ucar May 8,2021



#### _SECTION 2: Automation_
The task includes two scenarios of login. 
One from homepage and the other from the login page.<br/> 
Steps can be further parameterized.Tags are also added.
                                    They can be used to run specific test scenarios.<br/><br/>
Credentials and other data are in a properties file and reached by a custom
``ConfigurationReader`` class.<br/><br/>

For reporting, ``cucumber-reports`` is used but built-in ``Cucumber Reports``
service is also available.<br/><br/>

##### _RUNNING THE TASK_
* Build the project using `mvn verify`
* To get _html test report_ after execution, task must be run through `mvn verify` command.
* Report is under ``/target/cucumber-html-reports``<br/><br/>
<br/><br/>

##### _Feature File Preview_

```gherkin
   Feature: Login Function
     @wip
     #first login method
     Scenario: Login after navigating to login page
       Given the user is on the homepage
       And user navigates to "login page"
       When user enters credentials and clicks Jetzt anmelden
       Then user should succesfully login
   
     #second login method
     Scenario: Login from the homepage
       Given the user is on the homepage
       When the user hovers on "anmelden"
       And user enters credentials and clicks Jetzt anmelden
       Then user should succesfully login
```          

_#1 scenario methods are parameterized for versatility and reusability._\
_#2 only "search" page is available. future page adding is possible._\
_#3 any year(string) and "ab" or "bis" can be selected._\
_#4 other sort options also can be entered ex:"Niedrigster Preis"._\
_#5 any year(int) together with "newer" and "older" options are selectable._\
_#6 "ascending" or "descending" options are available for verifying._

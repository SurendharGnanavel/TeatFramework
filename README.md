# TestFramework
Framework  to Automate  web UI Applications

Pre-requisites:
1.	Maven should be installed

About the framework:
1.	This Framework use Maven as a Build tool so it becomes platform independent
2.	I have used WebDriverManager so no need to setup for the Chromedriver locations every time and no need to update the chromedriver.
3.	Used Testng and leveraging Testng ItestResult variable and capturing the Screenshot if the 
ItestResult is Fail.

4.	Used Extent reports and its placed in Results folder with runtime_foldername
5.	Created a interface for the UIActions reusable method implementation done in UiactionsImp.java


Steps to runt eh framework:
To runt the framework we need to have maven in our system as pre-requisites. Then
Open Terminal/cmd run mvn clean install test

		

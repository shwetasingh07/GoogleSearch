# GoogleSearch
A Test NG Selenium Project to write tests for Google Search Page

## Test Scenarios covered
1. Do a search by typing in a keyword, and verify that keyword appears on the results page
2. Do a search by using the mouse to click letters inside the keyboard input tool and verify that the keyword appears on the results page

## Pre-requisites
1. Java 8 ( JDK)
2. Maven 3.x.x

## Used tools and frameworks
1. TestNG
2. Maven Repository
3. Maven Surefire Plugin
4. Extend Report http://extentreports.com/docs/versions/4/net/avent-reporter.html

## How to Install
Git:
```
$ git clone https://github.com/shwetasingh07/GoogleSearch.git
```
Or download a ZIP of master and expand the contents in a folder on your system

## How to Run Tests
## Maven Command
1. Open Command Prompt
2. Navigate to the project folder
3. Type "mvn clean test" OR "mvn -DBROWSER="chrome" -DSEARCH_TERM="Rockall Technologies" clean test" to run all tests 
## Run Parameters
1. The tests can be run in multiple browers by using run time maven parameter -DBROWSER. Support is there for chrome, firefox,ie
2. User can give any search term as input to the test by using run time mvn parameter -DSEARCH_TERM="Accenture Global Services Dublin"

## Using INTELLIJ OR ECLIPSE
1. Open IDE
2. Navigate from File --> New --> Project from Existing Sources
3. Select pom.xml file from Folder location where repo was cloned 
4. Select JDK and Click Next
5. Once Project is opened in Intellij
6. Right Click on pom.xml --> maven --> reimport
7. Right Click on "TestNG.xml" and Run
## Run Parameters
1. Go to file LOCALCONFIG.JAVA in project folder
2. Run time paramaters can be edited and passed from here
```
private String browser = System.getProperty("BROWSER") == null ? "chrome" : System.getProperty("BROWSER");
    private String url = System.getProperty("URL") == null ? "http://google.com" : System.getProperty("URL");
    private String searchTerm = System.getProperty("SEARCH_TERM") == null ? "888 Holdings" : System.getProperty("SEARCH_TERM");
    ```
    
    


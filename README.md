
***
## Getting Started
The following section detail the steps required to build and run tests.

***
### Prerequisites

1. Java 1.8

   OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_265-b01) was used for development.
After installing , make sure java is in your environment

2. Maven

   Apache Maven 3.6.2.After installing , make sure java is in your environment

3. Chrome

4. Firefox

***
## Run tests

1. Install all dependencies for a project:

       Note that a working internet connection is required  as maven will download
       all required java libraries that are not yet available on the system.
    ```
    $ mvn clean test -Dtestng='Chrome.xml' . This is also command line when integrate with CI/CD
    ```
   $ mvn clean test -Dtestng='Browsers.xml' for running tests parallel on both chrome and firefox at same machine
    ```
2. All of testng files are located at ${ProjectFolder}/src/test/resources . To make other testng configuration you also have to put the file at this folder. 

3. All of feature files are located at ${ProjectFolder}/src/test/resources/features

4. Cucumber HTML report is located at ${ProjectFolder}/target/cucumber-html-reports/

## Cloud Integration 
We can integrate with AWS by changing code as following instructions : https://docs.aws.amazon.com/devicefarm/latest/testgrid/testing-frameworks-java.html

## Test appoarch 
Located in ${ProjectFolder}/1_TEST_APPROACH

## Test cases
Located in ${ProjectFolder}/2_TEST_CASES

## Bug report
Located in ${ProjectFolder}/3_BUG_REPORT

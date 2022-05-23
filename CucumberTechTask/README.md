# LUXOFT API Automation automation framework

Overview:
We know that any automation project starting with a good test architecture. This project can be your initial test architecture for a faster start. 

This framework is built on below technology stack.
1. CUCUMBER BDD Framework
2. REST-ASSURED
3. MAVEN
4. JAVA
5. Eclipse
6. JSON

Below technical terms used:

1. DATA DRIVEN TESTING
2. Singletone Patterns to handle JSON and Config file handling
3. JSON Path and POJO for JSON serialization and Deserialization


Belows are the Structure of Site:
src\main\java
                api.com.constants -> Single location for all hard coded values in suite
                api.com.dataProvider-> To handle data inthe form of JSON and cofigartion
                api.com.manager-> Handling the instances of JSON , config files
                api.com.myRunner-> Cucumber TestNG Runner for suite
                api.com.utility-> JSON Path utility for JSON extraction
                api.com.testData-> POJO class for JSON
                feature -> Gherkin file to run suite
                stepDefination-> Step defination for feature files


src\test\resources
        config -> Configuration management file
        testDataRsource -> Test data files in the form of JSON







Feature: As a user, I can verify the proper respose from API

Background: I have valid NACE details present in system

Scenario Outline: As a user,I can retrive Nace Details by using order details
Given API is ready and I can fetch data from application
When get NaceDetails by using  "<order>"
Then verify NaceDetails are as per "<order>"
Examples:
|order|
|398481|
|398482|
|398483|
|398484|
|398485|



		
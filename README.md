# PyramidCheck - Fetch Rewards Assessment - Suraj Nair
Simple spring boot application to check if a word is pyramid word

![Fetch Rewards](https://media-exp1.licdn.com/dms/image/C4D1BAQFZCIS6HyhMCA/company-background_10000/0?e=2159024400&v=beta&t=Fq9lAIHCQN17wQBLBiycTXp-Gm23UGE3li6WOqMRczA)

## Goal
Accept a string as input and return a response indicating whether a word is a pyramid word. 
A word is a pyramid word if you can arrange the letters in increasing frequency, starting with 1 and continuing without gaps and without duplicates.

> "banana" is a pyramid word because you have 1 'b', 2 'n's, and 3 'a's.

> "bandana" is not a pyramid word because you have 1 'b' and 1 'd'.

## Assumptions

> Basic validations are performed within the controller, another approach could split the validations into seperate Service for scalability options OR the input could be taken as a DTO(Data Transfer Object) where the Java class could utilize @Valid for the same purpose

> Empty string is not a pyramid (Assumed due to logically no occurence of characters)

> "This is test string"/String array is not a pyramid word (Assumed since it is a sentence,collection of words)

> String **cannot contain special characters/digits** (Assumed due to nature of service)

> The comparison is case **insensitive**, ie BanaNa and banana are both pyramids

> The number of characters should be strictly increasing, ie we will not have 1 'b', 3 'a', 5 'n' or 1 'b', 3 'a', 3 'n'


## Approach

We count the occurrences of each character and sort them in ascending order
If a string is pyramid, the occurence of characters will differ by 1

## Running the application locally

Open the project in [Eclipse IDE](https://www.eclipse.org/downloads/) 

To ensure a clean build, also install the [Spring Tool Suite plugin](https://download.springsource.com/release/STS/3.9.8.RELEASE/dist/e4.11/spring-tool-suite-3.9.8.RELEASE-e4.11.0-win32-x86_64.zip) 

1) Clone the repository to a local folder
2) Open the project in [Eclipse IDE](https://www.eclipse.org/downloads/)
3) You may change the port for accessing web service at ..\FetchRewardsAssesment\src\main\resources changing the application properties (you may have to rebuild the application)
4) Open class file FRAssessmentApplication.java and Run as Java Application                   OR
   Navigate to ..\FetchRewardsAssesment\target\frassessment-0.0.1-SNAPSHOT.jar and run the following command in terminal/command prompt
  ```
  java -jar frassessment-0.0.1-SNAPSHOT.jar
  ```
5) Once the application is running, open a web browser or any web api testing tool such as [Postman](https://www.postman.com/downloads/) and access(use GET method for Postman) via http://localhost:8081/assess?word=your_input

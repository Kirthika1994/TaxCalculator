Assumptions
1.	Company has many type of shares and each share will have a unique ID & share Name.
2.	A trade can have only 1 share type (To make the project simple).
3.	Motive is to compute the tax and display where necessary.

Solution formulation
Steps I've thought of and executed for calculating the tax due:
1.	Get the list of shares the company holds with it's price and determined tax rate
2.	A provision for the company to add new shares into market
3.	List of all trades with it's computed tax and price 
4.	A provision to add a trade when a purchase is done - obtaining using minimal input from 	user.
5.	Search for a particular trade to view it's tax due & price.
6.	Code to be written with high code quality & unit testing covering all scenarios.

Tools used:
1.	Spring Boot
2.	JAVA
3.	H2 Database
4.	Jpa Repository
5.	Junit testing
6.	Swagger - UI Testing

 
Decisions and tradeoffs:
1.	Understood the requirement and decided to keep it simple due to time constrain.
2.	I have chosen more of a functional/procedural path with more pure functions than object 	oriented pattern. I think it is better in this small problem space than trying to model or 	use a design pattern like composition design pattern where a user will have a role object.
3.	I was focused more on getting the result and testing the code with a high code coverage.
4.	There are places to improve & enhance like using logger and  more libraries.


Since this is a coding test project, the scope is quite small. If it was a bigger real project, doing the following things would be better:
1.	More focus on architecture and software design would be necessary.
2.	Package structure & Layers should be determined as a team. 
3. 'javaMoney' API should be used while dealing with currency & prices.
4.	More Test scenarios for Exception handling should be used to throw appropriate error message
5.	Entities on the input & output requirement should be documented with Mock test data.
6.	Persistent database (SQL/Cloud should be used)
7.	Code quality check integrated Git pipeline to validate the code coverage.
8.	Peer code review & Demo before code check-in


How to set up and run:
1.	Download the Executable jar from (src/)
2.	Open command prompt and navigate to the path where the jar is placed
3.	Run the command 'java -jar jarname', for this project its java -jar demo-0.0.1-SNAPSHOT.jar
4.	Use the End point to test API in swagger - http://localhost:8080/swagger-ui/index.html#/


Junit Testing:

Number of Test cases: 13
Cases passed: 13


End points & test results:

GET - http://localhost:8080/shareslist
[
  {
    "shareId": 1,
    "shareName": "ABC",
    "sharePrice": 100,
    "taxRate": 10
  }
]

GET - http://localhost:8080/tradeslist
[
  {
    "tradeId": 1,
    "shareName": "ABC",
    "quantity": 20,
    "computedTax": 200,
    "totalPrice": 2200
  }
]

GET - http://localhost:8080/trade/1
{
  "tradeId": 1,
  "shareName": "ABC",
  "quantity": 20,
  "computedTax": 200,
  "totalPrice": 2200
}

POST - http://localhost:8080/addtrade/1/20
{
  "tradeId": 1,
  "shareName": "ABC",
  "quantity": 20,
  "computedTax": 200,
  "totalPrice": 2200
}
POST - http://localhost:8080/addshare
1


Swagger: http://localhost:8080/swagger-ui/index.html#/


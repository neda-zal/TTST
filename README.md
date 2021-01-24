# TTST2021 - Assignment project

Preliminary Step: Create a GitLab project in the group TTST2021, and download and extract the master project in your newly cloned repository.

## Assignment 1 - Fitnesse

**Goal**: a black-box test of System Under Test (SUT) - Auction System

* Step 1: Create User Stories for the SUT
* Step 2: Create an Acceptance Test per US
* Step 3: Select the USs and ATs that concern the method _getNextPrice_, and create a Fitnesse decision table per AT, with the associated Fitnesse fixtures

## Assignment 2 - Java Unit Tests

**Goal**: Implement Unit tests for the selected ATs with JUnit 5.

* Step 1: Create Unit tests for each  method that is connected with the method _getNextPrice_, starting from the ATs and the fitnesse decision tables (Hint: create and maintain a list of methods you plan to test); 
* Step 2: Complete the Unit tests gradually until you cover all methods you have identified in Step 1.

### Step 1:

* Start by creating a JUnit test for one method that you think has greatest priority (it can be _getNextPrice_ or one related to it);
* Identify the input values according the partition strategy, the boundary strategy and the default or typical values as you have done for the ATs and Fitnesse decision tables;

### Step 2:
* Repeat for all methods. 

Tag your code as version 1.0. 

## Assignment 3 - Regression/Integration tests and Issue Tracking

**Goal**: integrate an external code to the existing version using Test Driven Development and Regression testing

### Preliminary step: 
Setup maven to automatically compile, build, and test.
Include all needed dependeciesin Maven POM: at least JUnit, surefire, JaCoCo
Use a different branch for step 1, as it might stall (and not be merged to master).

### Step 1: 
1. Create a new brach for this assignment
2. Activate the CD/CI feature in gitlab; 
3. Design your pipeline: write a yml file to define the stages of the continuous integration: at least clean compile; test with profiles (UnitTest; Integration test);
4. Check the coverage of the current code and report it in the README file 
5. Inspect the behaviour of the method searchHighestBid() in the code's binary file AuctionSystemPublic.jar 

### Step 2:
0. At each of the following steps commit your code using the pipeline you desinged in step 1
1. Modify your code to integrate the method that computes the highest price for a Bid that is contained in the code you received in Step 1;
Integration: Use the method searchHighestBid() in the code's binary file AuctionSystemPublic.jar instead of the getNextPrize() method in the original code and test the resulting code; gradually implement it, using TDD and the old test suite; for ex. if the old test suite does not pass, create a new test case with or modify an existing one with TDD.
2. Create issues for encountered problems and tackle them step by step by assigning them to the more suitable member of your group
3. Check the coverage of your tests with JaCoCo and report it in the README file
4. Check out your branch to the master when you are done and assign it a new version index


Watch out: You might need to do Step 1 and step 2 together (not sequentially).
 
## Explanation for Continuous Integration

In this last assignment, we will use GitLab CI to maximize automation.

**Goal**: Setup continuous integration for your project. Configure the pipeline for build and test. Use code coverage tools and testing coverage to drive the pipeline.

Step 1: Setup continuous integration for your project. Configure the pipeline for build, test, and coverage.

Step 2: Gradually extend unit tests until a suitable test coverage is reached.

## Bonus

- 1 point over the mean of the assignemnt marks is all assignemnts have been delivered withing their respective dealines
- 0.5 point if all assignemnts are delivered within the last course day (midnight 09.12.2020). 

**Assignment 3 report**:

Code coverage before integration testing: 50%
Code coverage after implemented integration testing with TDD:



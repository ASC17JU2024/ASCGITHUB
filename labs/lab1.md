:keyboard: **LAB 1**  

1) Implement the following methods in a class. 
```
public void add (int a, int b)      	
  ``` 
  <br> Invoke these methods by passing appropriate parameters and display the output in the main method.
  <br> Hint: To call `add(short a, short b)` method, you may need to use `add((short)5,(short)6)`
  <br>Implement appropriate versions of the `add()` method in a class so that 
  - `add(10,20)` returns 30
  - `add(10,20,30)` returns 60
  - `add(10.5, 20.1)` returns 30.6
  - `add(“Hello”,20)` returns “Hello 20”

2) Define a class Student with the following attributes
  - studentId of type integer
  - studentName of type String
  - city of type String
  - marks1 of type integer
  - marks2 of type integer
  - marks3 of type integer
  - feePerMonth of type float
  - isEligibleForScholarship of type boolean
  Implement the following methods in addition to the setter and getter methods for the various attributes
  - getAnualFee() which returns the product of feePerMonth and 12
  - getTotalmarks() which returns the sum of marks1, marks2 and marks3
  - getAverage() which returns the average of marks1, marks2 and marks3
  - getResult() which returns “pass” if the person has scored more than 60 in each subject, or returns “fail” otherwise
  Create another class TestMain with the main() method which performs the following actions
  - Creates three Student objects
  - Populates the objects using the setter methods
  - Displays the name of the Student who has the highest total marks
  - Prints the name and fee of the Student who pays the least monthly fee
  - Prints the name, total marks , average marks , result, and “Scholarship available” or “Scholarship not available” based on the student’s eligibility for every student.

For the following assignments create an exclusive class called Tester which contains the main method. Create objects of other classes, make calls to the methods, and test your code using this Class’s main method.

3) Write a method that accepts an integer as parameter and displays its multiplication table using for loop, as shown below. Implement 2 other methods which perform the same action but using a while and do-while loop respectively. E.g. if the input parameter is 2, then these methods must output the multiplication table as follows:
<br> 2 x 1 = 2 
<br> 2 x 2 = 4 
<br> ...
<br> 2 x 10 = 20

4) Write a method which accepts a string as parameter and returns the number of words in it. For example, if the string is "Sum of 12 and 20 is 32", the method should return 4.

5) Create a program with methods to test the functionality of the various methods of the String class
  - charAt
  - contains
  - length
  - indexOf
  - equals
  - equalsIgnoreCase
  - join
  - lastIndexOf
  - substring
  - tolowercase
  - touppercase
  - trim
 
6) Define a class ArrayStore which contains an integer array as its instance variable. Create necessary methods for the following operations.
  - Accept 10 integers and store them into the array.
  - Display the elements of the array using while & for loops
  - Sort the array
  - Accept a number and return the number of times it occurs in the array
  - Insert a number into the array at a specified position
  - Return array that excludes duplicate elements in the original array. E.g. if the elements of the original array are [9,2,2,9,10,9] then return [9,2,10]








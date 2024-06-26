:keyboard: **LAB 3**  

Note: All classes should be organized into packages that follow a well-defined hierarchy.

1) Create a class Movie with attributes - movie name, produced by, directed by, duration, year, category (comedy/action/..). Write necessary methods that accept and display the information. Create the constructors based on the below rules.
  - Movie name and produced by are mandatory fields and should be supplied at the time of creating the object
  - Compiler should raise an error when you try to create Movie object without passing any parameters.
  - Write a constructor which accepts all the attributes as parameters while creating the object. From this constructor call the constructor (mentioned at point a) to initialize mandatory fields

2) In the above class create a static variable moviesCount. Write necessary methods to get the values. Every time an object of Movie is created, increment the value of moviesCount variable.

3) Create a movieId field. Make this variable as a readOnly variable (i.e. make it private and write only a getter method). Generate movieId value by using the below formula
<br> `movieId=”movieName”+”_”+moviesCount`
<br> eg. if the Movie name is “Hello” and the value of moviesCount variable is 31, then store Hello_31

4) Define a new class SpecialMovie which contains all the attributes of Movie and other attributes to store the technology used for soundEffects and visualEffects. Define another class InternationalMovie which contains all attributes of Movie class and other attributes to store country and language.
  - Write necessary classes, constructors and methods for storing and displaying additional information. Hint: use super keyword to call the methods/constructor of super class.

5) In the Movie class write a method called showDetails() which concatenates the value of all the attributes and returns it as a String
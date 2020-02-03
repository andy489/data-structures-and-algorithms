https://www.hackerrank.com/challenges/30-inheritance/editorial

## Day 12: Inheritance

Objective
Today, we're delving into Inheritance. Check out the [tutorial](https://www.hackerrank.com/challenges/30-inheritance/tutorial) for learning materials and an instructional video!

#### Task
You are given two classes, Person and Student, where Person is the base class and Student is the derived class. Completed code for Person and a declaration for Student are provided for you in the editor. Observe that Student inherits all the properties of Person.

Complete the Student class by writing the following:<br>

- A Student class constructor, which has <img src="https://latex.codecogs.com/svg.latex?\Large&space;4">parameters:
  - A string, <img src="https://latex.codecogs.com/svg.latex?\Large&space;firstName">.
  - A string, <img src="https://latex.codecogs.com/svg.latex?\Large&space;lastName">.
  - An integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;id">.
  - An integer array (or vector) of test scores, <img src="https://latex.codecogs.com/svg.latex?\Large&space;scores">.
- A char calculate() method that calculates a Student object's average and returns the grade character representative of their calculated average:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Grading%2001.png)

#### Input Format

The locked stub code in your editor calls your Student class constructor and passes it the necessary arguments. It also calls the calculate method (which takes no arguments).

You are not responsible for reading the following input from stdin:
The first line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;firstName,lastName">, and <img src="https://latex.codecogs.com/svg.latex?\Large&space;id">, respectively. The second line contains the number of test scores. The third line of space-separated integers describes <img src="https://latex.codecogs.com/svg.latex?\Large&space;scores">.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{|firstName|,|lastName|}\le{10}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;|id|\equiv{7}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{score,average\le{100}}">
#### Output Format

This is handled by the locked stub code in your editor. Your output will be correct if your Student class constructor and calculate() method are properly implemented.

#### Sample Input
```
Heraldo Memelli 8135627
2
100 80
```
#### Sample Output
```
 Name: Memelli, Heraldo
 ID: 8135627
 Grade: O
```
#### Explanation

This student had <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> scores to average: <img src="https://latex.codecogs.com/svg.latex?\Large&space;100"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;80">. The student's average grade is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{(100+80)}{2}=90">. An average grade of <img src="https://latex.codecogs.com/svg.latex?\Large&space;90"> corresponds to the letter grade <img src="https://latex.codecogs.com/svg.latex?\Large&space;O">, so our calculate() method should return the character'O'.

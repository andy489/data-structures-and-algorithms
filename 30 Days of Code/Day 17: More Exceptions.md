https://www.hackerrank.com/challenges/30-more-exceptions/problem

## Day 17: More Exceptions

#### Objective
Yesterday's challenge taught you to manage exceptional situations by using try and catch blocks. In today's challenge, you're going to practice throwing and propagating an exception. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-more-exceptions/tutorial) tab for learning materials and an instructional video!

#### Task
Write a Calculator class with a single method: int power(int,int). The power method takes two integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">and <img src="https://latex.codecogs.com/svg.latex?\Large&space;p">, as parameters and returns the integer result of <img src="https://latex.codecogs.com/svg.latex?\Large&space;n^p">. If either or <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;p"> is negative, then the method must throw an exception with the message: *n and p should be non-negative*.

**Note:** Do not use an access modifier (e.g.: public) in the declaration for your Calculator class.

#### Input Format

Input from stdin is handled for you by the locked stub code in your editor. The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;T">, the number of test cases. Each of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> subsequent lines describes a test case in <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> space-separated integers denoting <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;p">, respectively.

#### Constraints

- No Test Case will result in overflow for correctly written code.

#### Output Format

Output to stdout is handled for you by the locked stub code in your editor. There are <img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> lines of output, where each line contains the result of <img src="https://latex.codecogs.com/svg.latex?\Large&space;n^p"> as calculated by your Calculator class' power method.

#### Sample Input
```
4
3 5
2 4
-1 -2
-1 3
```
#### Sample Output
```
243
16
n and p should be non-negative
n and p should be non-negative
```
#### Explanation
<img src="https://latex.codecogs.com/svg.latex?\Large&space;T=4"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;T_0:3"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> are positive, so power returns the result of <img src="https://latex.codecogs.com/svg.latex?\Large&space;3^5">, which is <img src="https://latex.codecogs.com/svg.latex?\Large&space;243">.<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;T_1:2">: and <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> are positive, so power returns the result of <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^4=">, which is <img src="https://latex.codecogs.com/svg.latex?\Large&space;16">.<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;T_2">: Both inputs (<img src="https://latex.codecogs.com/svg.latex?\Large&space;-1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;-2">) are negative, so power throws an exception and *n and p should be non-negative* is printed.<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;T_3">: One of the inputs (<img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">) is negative, so power throws an exception and *n and p should be non-negative* is printed.

https://www.hackerrank.com/challenges/30-exceptions-string-to-integer/problem

## Day 16: Exceptions - String to Integer

#### Objective
Today, we're getting started with Exceptions by learning how to parse an integer from a string and print a custom error message. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-exceptions-string-to-integer/tutorial) tab for learning materials and an instructional video!

#### Task
Read a string, <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">, and print its integer value; if <img src="https://latex.codecogs.com/svg.latex?\Large&space;S"> cannot be converted to an integer, print *Bad String*.

**Note:** You must use the String-to-Integer and exception handling constructs built into your submission language. If you attempt to use loops/conditional statements, you will get a <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> score.

#### Input Format

A single string, <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{|S|}\le{6}">, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;|S|"> is the length of string <img src="https://latex.codecogs.com/svg.latex?\Large&space;|S|">.
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;S"> is composed of either lowercase letters (<img src="https://latex.codecogs.com/svg.latex?\Large&space;a-z">) or decimal digits (<img src="https://latex.codecogs.com/svg.latex?\Large&space;0-9">).

#### Output Format

Print the parsed integer value of <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">, or *Bad String* if <img src="https://latex.codecogs.com/svg.latex?\Large&space;S"> cannot be converted to an integer.

#### Sample Input 0
```
3
```
#### Sample Output 0
```
3
```
#### Sample Input 1
```
za
```
#### Sample Output 1
```
Bad String
```
#### Explanation

Sample Case <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> contains an integer, so it should not raise an exception when we attempt to convert it to an integer. Thus, we print the <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">.<br>
Sample Case <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> does not contain any integers, so an attempt to convert it to an integer will raise an exception. Thus, our exception handler prints *Bad String*.

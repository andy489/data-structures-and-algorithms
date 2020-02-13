https://www.hackerrank.com/challenges/30-recursion/problem

## Day 9: Recursion 3

#### Objective
Today, we're learning and practicing an algorithmic concept called Recursion. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-recursion/tutorial) tab for learning materials and an instructional video!

#### Recursive Method for Calculating Factorial

<img src="https://latex.codecogs.com/svg.latex?\Large&space;factorial(N)=\begin{cases}1{\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;\;N\le{1}}\\N\times{factorial(N-1){\;}otherwise}\end{cases}">

#### Task
Write a factorial function that takes a positive integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">
as a parameter and prints the result of <img src="https://latex.codecogs.com/svg.latex?\Large&space;N!"> (<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> factorial).

**Note:** If you fail to use recursion or fail to name your recursive function factorial or Factorial, you will get a score of <img src="https://latex.codecogs.com/svg.latex?\Large&space;0">.

#### Input Format

A single integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> (the argument to pass to factorial).

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{N}\le{12}">
- Your submission must contain a recursive function named factorial.

#### Output Format

Print a single integer denoting <img src="https://latex.codecogs.com/svg.latex?\Large&space;N!">.

#### Sample Input
```
3
```
#### Sample Output
```
6
```
#### Explanation

Consider the following steps:
1. <img src="https://latex.codecogs.com/svg.latex?\Large&space;factorial(3)=3\times{factorial(2)}"><br>
2. <img src="https://latex.codecogs.com/svg.latex?\Large&space;factorial(2)=2\times{factorial(1)}"><br>
3. <img src="https://latex.codecogs.com/svg.latex?\Large&space;factorial(1)=1">
From steps <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">, we can say <img src="https://latex.codecogs.com/svg.latex?\Large&space;factorial(2)=2\times{1}=2">; then when we apply the value from <img src="https://latex.codecogs.com/svg.latex?\Large&space;factorial(2)"> to step <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">, we get <img src="https://latex.codecogs.com/svg.latex?\Large&space;factorial(3)=3\times{2}\times{1}=6">. Thus, we print <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> as our answer.

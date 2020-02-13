## Is Fibo

[Judge System](https://www.hackerrank.com/challenges/is-fibo/problem)

You are given an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">. Write a program to determine if <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> is an element of the Fibonacci sequence.

The first few elements of the Fibonacci sequence are <img src="https://latex.codecogs.com/svg.latex?\Large&space;0,1,1,2,3,5,8,13,...">. A Fibonacci sequence is one where every element is a sum of the previous two elements in the sequence. The first two elements are <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">.

Formally:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;fib_0=0\\fib_1=1\\...\\fib_n=fin_{n-1}+fib_{n-2}{\;}\forall{n}>1">

#### Format
The first line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;T">, number of test cases.<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> lines follow. Each line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">.

#### Output Format
Display *IsFibo* if <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> is a Fibonacci number and *IsNotFibo* if it is not. The output for each test case should be displayed in a new line.

#### Constraints

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{T}\le{10^5}">
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^{10}}">

#### Sample Input

```
3
5
7
8
```
#### Sample Output

```
IsFibo
IsNotFibo
IsFibo
```
#### Explanation

<img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> is a Fibonacci number given by <img src="https://latex.codecogs.com/svg.latex?\Large&space;fib_5=3+2"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;7"> not a Fibonacci number<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;8"> is a Fibonacci number given by <img src="https://latex.codecogs.com/svg.latex?\Large&space;fib_6=5+3"><be> 

#### Time Limit
Time limit for this challenge is given [here](https://www.hackerrank.com/environment).

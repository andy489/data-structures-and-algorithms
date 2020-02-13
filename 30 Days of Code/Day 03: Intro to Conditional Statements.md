https://www.hackerrank.com/challenges/30-conditional-statements/problem

## Day 3: Introduction to Conditional Statements

#### Objective
In this challenge, we're getting started with conditional statements. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-conditional-statements/tutorial) tab for learning materials and an instructional video!

#### Task
Given an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, perform the following conditional actions:

- If <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> is odd, print *Wierd*
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> is even and in the inclusive range of <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;5">, print *Not Weird*
- If <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> is even and in the inclusive range of <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;20">, print *Weird*
- If <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> is even and greater than <img src="https://latex.codecogs.com/svg.latex?\Large&space;20">, print *Not Weird*

Complete the stub code provided in your editor to print whether or not <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> is weird.

#### Input Format

A single line containing a positive integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">.

#### Constraints

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{100}">

#### Output Format

Print *Weird* if the number is weird; otherwise, print *Not Weird*.

Sample Input 0|Sample Output 0
-|-
3|Weird

Sample Input 1|Sample Output 1
-|-
24|Not Weird

#### Explanation

Sample Case 0: <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=3">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> is odd and odd numbers are weird, so we print *Weird*.

Sample Case 1: <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=24">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;n>20"> and is even, so it isn't weird. Thus, we print *Not Weird*.

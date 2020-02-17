[Link](https://www.hackerrank.com/challenges/30-scope/problem)

## Day 14: Scope

#### Objective
Today we're discussing scope. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-scope/tutorial) tab for learning materials and an instructional video!

The absolute difference between two integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;a"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;b">, is written as <img src="https://latex.codecogs.com/svg.latex?\Large&space;|a-b|">. The maximum absolute difference between two integers in a set of positive integers,<img src="https://latex.codecogs.com/svg.latex?\Large&space;elements">, is the largest absolute difference between any two integers in <img src="https://latex.codecogs.com/svg.latex?\Large&space;elements">.

The Difference class is started for you in the editor. It has a private integer array (<img src="https://latex.codecogs.com/svg.latex?\Large&space;elements">) for storing <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> non-negative integers, and a public integer (<img src="https://latex.codecogs.com/svg.latex?\Large&space;maximumDifference">) for storing the maximum absolute difference.

#### Task
Complete the Difference class by writing the following:

- A class constructor that takes an array of integers as a parameter and saves it to the <img src="https://latex.codecogs.com/svg.latex?\Large&space;elements"> instance variable.
- A computeDifference method that finds the maximum absolute difference between any <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> numbers in <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> and stores it in the
<img src="https://latex.codecogs.com/svg.latex?\Large&space;maximumDifference"> instance variable.

#### Input Format

You are not responsible for reading any input from stdin. The locked Solution class in your editor reads in <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> lines of input; the first line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">, and the second line describes the <img src="https://latex.codecogs.com/svg.latex?\Large&space;elements"> array.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{elements[i]}\le{100}">, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{i}\le{N-1}">

#### Output Format

You are not responsible for printing any output; the Solution class will print the value of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;maximumDifference"> instance variable.

#### Sample Input
```
3
1 2 5
```
#### Sample Output
```
4
```
#### Explanation

The scope of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;elements"> array and <img src="https://latex.codecogs.com/svg.latex?\Large&space;maximumDifference"> integer is the entire class instance. The class constructor saves the argument passed to the constructor as the <img src="https://latex.codecogs.com/svg.latex?\Large&space;elements"> instance variable (where the computeDifference method can access it).

To find the maximum difference, computeDifference checks each element in the array and finds the maximum difference between any <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> elements:<br><img src="https://latex.codecogs.com/svg.latex?\Large&space;|1-2|=1"><br><img src="https://latex.codecogs.com/svg.latex?\Large&space;|1-5|=4"><br><img src="https://latex.codecogs.com/svg.latex?\Large&space;|2-5|=3">

The maximum of these differences is <img src="https://latex.codecogs.com/svg.latex?\Large&space;4">, so it saves the value <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> as the <img src="https://latex.codecogs.com/svg.latex?\Large&space;maximumDifference"> instance variable. The locked stub code in the editor then prints the value stored as <img src="https://latex.codecogs.com/svg.latex?\Large&space;maximumDifference"> , which is <img src="https://latex.codecogs.com/svg.latex?\Large&space;4">.

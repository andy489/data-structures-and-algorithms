https://www.hackerrank.com/challenges/30-interfaces/problem

#### Objective
Today, we're learning about Interfaces. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-interfaces/tutorial) tab for learning materials and an instructional video!

#### Task
The *AdvancedArithmetic* interface and the method declaration for the abstract *divisorSum(n)* method are provided for you in the editor below.

Complete the implementation of *Calculator* class, which implements the AdvancedArithmetic interface. The implementation for the *divisorSum(n)* method must return the sum of all divisors of <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">.

#### Input Format

A single line containing an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{1000}">
#### Output Format

You are not responsible for printing anything to stdout. The locked template code in the editor below will call your code and print the necessary output.

#### Sample Input
```
6
```
#### Sample Output
```
I implemented: AdvancedArithmetic
12
```
#### Explanation

The integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> is evenly divisible by <img src="https://latex.codecogs.com/svg.latex?\Large&space;1,2,3">, and <img src="https://latex.codecogs.com/svg.latex?\Large&space;6">. Our divisorSum method should return the sum of these numbers, which is <img src="https://latex.codecogs.com/svg.latex?\Large&space;1+2+3+6=12">. The Solution class then prints *I implemented: AdvancedArithmetic* on the first line, followed by the sum returned by divisorSum (which is <img src="https://latex.codecogs.com/svg.latex?\Large&space;12">) on the second line.

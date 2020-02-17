[Link](https://www.hackerrank.com/challenges/30-nested-logic/problem)

## Day 26: Nested Logic

#### Objective
Today's challenge puts your understanding of nested conditional statements to the test. You already have the knowledge to complete this challenge, but check out the [Tutorial](https://www.hackerrank.com/challenges/30-nested-logic/tutorial) tab for a video on testing!

#### Task
Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:

1. If the book is returned on or before the expected return date, no fine will be charged (i.e.: <img src="https://latex.codecogs.com/svg.latex?\Large&space;fine=0">).<br>
2. If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, <img src="https://latex.codecogs.com/svg.latex?\Large&space;fine=15{\;}{Hackos}\times{(the{\;}number{\;}of{\;}days{\;}late)}">.
3. If the book is returned after the expected return month but still within the same calendar year as the expected return date, the <img src="https://latex.codecogs.com/svg.latex?\Large&space;fine=400{\;}Hackos\times{(the{\;}number{\;}of{\;}months{\;}late)}">.<br>
4. If the book is returned after the calendar year in which it was expected, there is a fixed fine of <img src="https://latex.codecogs.com/svg.latex?\Large&space;10000{\;}Hackos">.

#### Input Format

The first line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> space-separated integers denoting the respective <img src="https://latex.codecogs.com/svg.latex?\Large&space;day">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;month">, and <img src="https://latex.codecogs.com/svg.latex?\Large&space;year"> on which the book was actually returned.<br>
The second line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> space-separated integers denoting the respective <img src="https://latex.codecogs.com/svg.latex?\Large&space;day">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;month"> , and <img src="https://latex.codecogs.com/svg.latex?\Large&space;year"> on which the book was expected to be returned (due date).

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{D}\le{31}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{M}\le{12}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{Y}\le{3000}">
- It is guaranteed that the dates will be valid Georgian calendar dates.

#### Output Format

Print a single integer denoting the library fine for the book received as input.

#### Sample Input
```
9 6 2015
6 6 2015
```
#### Sample Output
```
45
```
#### Explanation

Given the following return dates:<br>
Actual: <img src="https://latex.codecogs.com/svg.latex?\Large&space;D_a=9,M_a=6,Y_a=2015"><br>
Expected: <img src="https://latex.codecogs.com/svg.latex?\Large&space;D_e=6,M_e=6,Y_e=2015"><br>
Because <img src="https://latex.codecogs.com/svg.latex?\Large&space;Y_e\equiv{Y_a}">, we know it is less than a year late.<br>
Because <img src="https://latex.codecogs.com/svg.latex?\Large&space;M_e\equiv{M_a}">, we know it's less than a month late.<br>
Because <img src="https://latex.codecogs.com/svg.latex?\Large&space;D_e<D_a">, we know that it was returned late (but still within the same month and year).

Per the library's fee structure, we know that our fine will be <img src="https://latex.codecogs.com/svg.latex?\Large&space;15{\;}Hackos\times{(days{\;}late)}">. We then print the result of <img src="https://latex.codecogs.com/svg.latex?\Large&space;15\times{(D_a-D_e)}=15\times{(9-6)}=45"> as our output.

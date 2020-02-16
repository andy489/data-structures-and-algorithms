https://www.hackerrank.com/challenges/30-running-time-and-complexity/copy-from/143047512

## Day 25: Running Time and Complexity

#### Objective
Today we're learning about running time! Check out the [Tutorial](https://www.hackerrank.com/challenges/30-running-time-and-complexity/tutorial) tab for learning materials and an instructional video!

#### Task
A prime is a natural number greater than <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> that has no positive divisors other than <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> and itself. Given a number, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> , determine and print whether it's <img src="https://latex.codecogs.com/svg.latex?\Large&space;Prime"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;Not{\;}prime">.

**Note:** If possible, try to come up with a <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(\sqrt{n})"> primality algorithm, or see what sort of optimizations you come up with for an <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n)"> algorithm. Be sure to check out the Editorial after submitting your code!

#### Input Format

The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;T">, the number of test cases.<br>
Each of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> subsequent lines contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, to be tested for primality.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{T}\le{30}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{2\times{10^9}}">

#### Output Format

For each test case, print whether <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> is <img src="https://latex.codecogs.com/svg.latex?\Large&space;Prime"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;Not prime"> on a new line.

#### Sample Input
```
3
12
5
7
```
#### Sample Output
```
Not prime
Prime
Prime
```
#### Explanation

Test Case 0: <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=12">.<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;12"> is divisible by numbers other than <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> and itself (i.e.: <img src="https://latex.codecogs.com/svg.latex?\Large&space;2,3,6">), so we print <img src="https://latex.codecogs.com/svg.latex?\Large&space;Not{\;}prime"> on a new line.

Test Case 1: <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=5">.<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> is only divisible <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> and itself, so we print <img src="https://latex.codecogs.com/svg.latex?\Large&space;Prime"> on a new line.

Test Case 2: <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=7">.<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;7"> is only divisible <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> and itself, so we print <img src="https://latex.codecogs.com/svg.latex?\Large&space;Prime"> on a new line.

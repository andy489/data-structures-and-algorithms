## Task 7.

Find the number of ways that a given integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> , can be expressed as the sum of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;N^{th}"> powers of unique, natural numbers.

For example, if <img src="https://latex.codecogs.com/svg.latex?\Large&space;X=13"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;N=2">, we have to find all combinations of unique squares adding up to <img src="https://latex.codecogs.com/svg.latex?\Large&space;13">. The only solution is <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^2+3^2">.

#### Function Description

Write a *powerSum* function. It should return an integer that represents the number of possible combinations.

*powerSum* has the following parameter(s):

    X: the integer to sum to
    N: the integer power to raise numbers to

#### Input Format

The first line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;X">.
The second line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">.

#### Constraints

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{X}\le{1000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10}">

#### Output Format

Output a single integer, the number of possible combinations caclulated.

Example input|Expected output|Explanation
-|-|-
10<br>2|1|If <img src="https://latex.codecogs.com/svg.latex?\Large&space;X=10"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;N=2">, we need to find the number of ways that <img src="https://latex.codecogs.com/svg.latex?\Large&space;10"> can be represented as the sum of squares of unique numbers.<br><img src="https://latex.codecogs.com/svg.latex?\Large&space;10=1^2+3^2"><br>This is the only way in which <img src="https://latex.codecogs.com/svg.latex?\Large&space;10"> can be expressed as the sum of unique squares.
100<br>2|1|<img src="https://latex.codecogs.com/svg.latex?\Large&space;100=(10^2)=(6^2+8^2)=(1^2+3^2+4^2+5^2+7^2)">
100<br>3|1|<img src="https://latex.codecogs.com/svg.latex?\Large&space;100"> can be expressed as the sum of the cubes of <img src="https://latex.codecogs.com/svg.latex?\Large&space;1,2,3,4">.<br><img src="https://latex.codecogs.com/svg.latex?\Large&space;(1+8+27+64)">. There is no other way to express <img src="https://latex.codecogs.com/svg.latex?\Large&space;100"> v as the sum of cubes. 

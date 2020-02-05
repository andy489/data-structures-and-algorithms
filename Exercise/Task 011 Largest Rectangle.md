## Largest rectangle

[Judge System](https://www.hackerrank.com/challenges/largest-rectangle/problem)

*Skyline Real Estate Developers* is planning to demolish a number of old, unoccupied buildings and construct a shopping mall in their place. Your task is to find the largest solid area in which the mall can be constructed.

There are a number of buildings in a certain two-dimensional landscape. Each building has a height, given by <img src="https://latex.codecogs.com/svg.latex?\Large&space;h[i],{\;}where{\;}i\in{[1,n]}">. If you join <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> djacent buildings, they will form a solid rectangle of area <img src="https://latex.codecogs.com/svg.latex?\Large&space;k\times{min}(h[i
,h[i+1],...,h[i+k-1])">.

For example, the heights array <img src="https://latex.codecogs.com/svg.latex?\Large&space;h=[3,2,3]">. A rectangle of height <img src="https://latex.codecogs.com/svg.latex?\Large&space;h=2"> and length <img src="https://latex.codecogs.com/svg.latex?\Large&space;k=3"> can be constructed within the boundaries. The area formed is <img src="https://latex.codecogs.com/svg.latex?\Large&space;h\cdot{k}=2\cdot{3}=6">.

#### Function Description

Complete the function largestRectangle int the editor below. It should return an integer representing the largest rectangle that can be formed within the bounds of consecutive buildings.

largestRectangle has the following parameter(s):

- h: an array of integers representing building heights

#### Input Format

The first line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, the number of buildings.<br>
The second line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> space-separated integers, each representing the height of a building.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{h[i]}\le{10^6}">

#### Output Format

Print a long integer representing the maximum area of rectangle formed.

#### Sample Input
```
5
1 2 3 4 5
```
#### Sample Output
```
9
```
#### Explanation

An illustration of the test case follows.

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Largest%20Rectangle%2001.svg)

## Lower Bound

You are given <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> integers in sorted order. Also, you are given <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> queries. In each query, you will be given an integer and you have to tell whether that integer is present in the array. If so, you have to tell at which index it is present and if it is not present, you have to tell the index at which the smallest integer that is just greater than the given number is present.

Lower bound is a function that can be used with a sorted vector. Learn how to use lower bound to solve this problem by [Clicking Here](http://www.cplusplus.com/reference/algorithm/lower_bound/).

#### Input Format

The first line of the input contains the number of integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">. The next line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> integers in sorted order. The next line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q">, the number of queries. Then <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> lines follow each containing a single integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;Y">.

Note that if the same number is present multiple times, you have to print the first index at which it occurs. Also, the input is such that you always have an answer for each query.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{X_i}\le{10^9}">, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_i"> is <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> element in the array.
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{Q}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{Y}\le{10^9}">

#### Output Format

For each query you have to print "Yes" (without the quotes) if the number is present and at which index(1-based) it is present separated by a space.

If the number is not present you have to print "No" (without the quotes) followed by the index of the next smallest number just greater than that number.

You have to output each query in a new line.

#### Sample Input
```
 8
 1 1 2 2 6 9 9 15
 4
 1
 4
 9
 15
```
#### Sample Output
```
 Yes 1
 No 5
 Yes 6
 Yes 8
```

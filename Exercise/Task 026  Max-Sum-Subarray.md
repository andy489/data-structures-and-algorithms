## Max-Sum-Subarray

[Judge System](https://www.hackerrank.com/contests/101hack33/challenges/max-sum-subarray/problem)

You are given an array <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> of <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> integers.
You need to find the contiguous subarray of the maximum sum in <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">. The subarray should not contain the number <img src="https://latex.codecogs.com/svg.latex?\Large&space;0">. Please find the maximum sum that is possible.

**Note 1:** The subarray can also be empty.
**Note 2:** The answer will fit in 32 bit-signed integer.

#### Input Format

The first line contains the integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">. The next line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> integers representing the numbers in the array.

#### Constraints
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^5}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;-10^6\le{A_i}\le{10^6}">

#### Output Format

Output a single line representing the maximum sum that can be obtained.

#### Sample Input
```
5   
3 4 0 1 2
```
#### Sample Output
```
7
```
#### Explanation

The subarray with the maximum sum that doesn't contain a <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> is <img src="https://latex.codecogs.com/svg.latex?\Large&space;3,4">.<br>
Hence, the sum is <img src="https://latex.codecogs.com/svg.latex?\Large&space;7">.

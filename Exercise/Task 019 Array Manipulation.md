## Array Manipulation

[Judge System](https://www.hackerrank.com/challenges/crush/problem)

Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.

For example, the length of your array of zeros <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=10">. Your list of queries is as follows:
```
    a b k
    1 5 3
    4 8 7
    6 9 1
```
Add the values of <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> between the indices <img src="https://latex.codecogs.com/svg.latex?\Large&space;a"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;b"> inclusive:
```
index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
```
The largest value is <img src="https://latex.codecogs.com/svg.latex?\Large&space;10"> after all operations are performed.

#### Function Description

Complete the function arrayManipulation in the editor below. It must return an integer, the maximum value in the resulting array.

arrayManipulation has the following parameters:

- n - the number of elements in your array
- queries - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.

#### Input Format

The first line contains two space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;m">, the size of the array and the number of operations.<br>
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> lines contains three space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;a">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;b"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">, the left index, right index and summand.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;3\le{n}\le{10^7}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{m}\le{2*10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{a}\le{b}\le{n}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{k}\le{10^9}">

#### Output Format

Return the integer maximum value in the finished array.

#### Sample Input
```
5 3
1 2 100
2 5 100
3 4 100
```
#### Sample Output
```
200
```
#### Explanation

After the first update list will be *100 100 0 0 0*.<br>
After the second update list will be *100 200 100 100 100*.<br>
After the third update list will be *100 200 200 200 100*.<br>
The required answer will be <img src="https://latex.codecogs.com/svg.latex?\Large&space;200">. 

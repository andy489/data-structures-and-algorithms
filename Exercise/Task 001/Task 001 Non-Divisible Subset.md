## Non-Divisible Subset

[Judge System](https://www.hackerrank.com/challenges/non-divisible-subset/problem)

Given a set of distinct integers, print the size of a maximal subset of <img src="https://latex.codecogs.com/svg.latex?\Large&space;S"> where the sum of any <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> numbers in <img src="https://latex.codecogs.com/svg.latex?\Large&space;S'"> is not evenly divisible by <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">.

For example, the array <img src="https://latex.codecogs.com/svg.latex?\Large&space;S=[19,10,12,10,24,25,22]"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;k=4">. One of the arrays that can be created is <img src="https://latex.codecogs.com/svg.latex?\Large&space;S'[0]=[10,12,25]">. Another is <img src="https://latex.codecogs.com/svg.latex?\Large&space;S'[1]=[19,22,24]"> . After testing all permutations, the maximum length solution array has <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> elements.

#### Input Format

The first line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> space-separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">, the number of values in <img src="https://latex.codecogs.com/svg.latex?\Large&space;S"> and the non factor.

The second line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> space-separated integers describing <img src="https://latex.codecogs.com/svg.latex?\Large&space;S[i]">, the unique values of the set.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{k}\le{100}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{S[i]}\le{10^9}">
- All of the given numbers are distinct.

#### Output Format

Print the size of the largest possible subset <img src="https://latex.codecogs.com/svg.latex?\Large&space;(S')">.

Sample Input|Sample Output
-|-
4 3<br>1 7 2 4|3

#### Explanation

The sums of all permutations of two elements from <img src="https://latex.codecogs.com/svg.latex?\Large&space;S=\{1,7,2,4\}"> are:
```
1 + 7 = 8
1 + 2 = 3
1 + 4 = 5
7 + 2 = 9
7 + 4 = 11
2 + 4 = 6
```
We see that only <img src="https://latex.codecogs.com/svg.latex?\Large&space;S=\{1,7,4\}"> will not ever sum to a multiple of <img src="https://latex.codecogs.com/svg.latex?\Large&space;k=3">.

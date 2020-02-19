## Candies

[Judge System](https://www.hackerrank.com/challenges/candies/problem)

Alice is a kindergarten teacher. She wants to give some candies to the children in her class.  All the children sit in a line and each of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to minimize the total number of candies she must buy.

For example, assume her students' ratings are [4, 6, 4, 5, 6, 2]. She gives the students candy in the following minimal amounts: [1, 2, 1, 2, 3, 1]. She must buy a minimum of 10 candies.

#### Input Format

The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, the size of <img src="https://latex.codecogs.com/svg.latex?\Large&space;arr">.<br>
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> lines contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;arr[i]"> indicating the rating of the student at position <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{arr[i]\le{10^5}}">

#### Output Format

Output a single line containing the minimum number of candies Alice must buy.

#### Sample Input 0
```
3
1
2
2
```
#### Sample Output 0
```
4
```
#### Explanation 0

Here 1, 2, 2 is the rating. Note that when two children have equal rating, they are allowed to have different number of candies. Hence optimal distribution will be 1, 2, 1.

#### Sample Input 1
```
10
2
4
2
6
1
7
8
9
2
1
```
#### Sample Output 1
```
19
```
#### Explanation 1

Optimal distribution will be <img src="https://latex.codecogs.com/svg.latex?\Large&space;1,2,1,2,1,2,3,4,2,1">

#### Sample Input 2
```
8
2
4
3
5
2
6
4
5
```
#### Sample Output 2
```
12
```
#### Explanation 2

Optimal distribution will be <img src="https://latex.codecogs.com/svg.latex?\Large&space;1,2,1,2,1,2,1,2">.

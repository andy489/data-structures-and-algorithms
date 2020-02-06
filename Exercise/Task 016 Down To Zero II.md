## Down To Zero II

[Judge System](https://www.hackerrank.com/challenges/down-to-zero-ii/problem?h_r=internal-search)

You are given queries. Each query consists of a single number . You can perform any of the operations on

in each move:

1: If we take 2 integers
and where , , then we can change 2: Decrease the value of by

.

Determine the minimum number of moves required to reduce the value of
to

.

#### Input Format

The first line contains the integer
.
The next lines each contain an integer,

.

#### Constraints


#### Output Format

Output
lines. Each line containing the minimum number of moves required to reduce the value of to

.

#### Sample Input
```
2
3
4
```
####v Sample Output
```
3
3
```
#### Explanation

For test case 1, We only have one option that gives the minimum number of moves.
Follow
-> -> -> . Hence,

moves.

For the case 2, we can either go
-> -> -> -> or -> -> -> . The 2nd option is more optimal. Hence, moves.

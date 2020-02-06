## Find Maximum Index Product

[Judge System](https://www.hackerrank.com/challenges/find-maximum-index-product/problem)

You are given a list of <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> numbers <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_1,a_2,...,a_n">. For each element at position <img src="https://latex.codecogs.com/svg.latex?\Large&space;i(1\le{i}\le{N})">, we define <img src="https://latex.codecogs.com/svg.latex?\Large&space;Left(i)"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;Right(i)"> as:<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;Left(i)">= closest index j such that j < i and <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_j>a_k">. If no such j exists then <img src="https://latex.codecogs.com/svg.latex?\Large&space;Left(i)=0">.<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;Right(i)">= closest index k such that k > i and <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_k>a_i">. If no such k exists then <img src="https://latex.codecogs.com/svg.latex?\Large&space;Right(i)=0">.

We define <img src="https://latex.codecogs.com/svg.latex?\Large&space;IndexProduct(i)=Left(i)*Right(i)">. You need to find out the maximum <img src="https://latex.codecogs.com/svg.latex?\Large&space;IndexProduct(i)"> among all <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">.

#### Input Format

The first line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">, the number of integers. The next line contains the <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> integers describing the list <img src="https://latex.codecogs.com/svg.latex?\Large&space;a[1..N]">.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{a_i}\le{10^9}">

#### Output Format

Output the maximum <img src="https://latex.codecogs.com/svg.latex?\Large&space;IndexProduct"> among all indices from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">.

#### Sample Input
```
5
5 4 3 4 5
```
#### Sample Output
```
8
```
#### Explanation

We can compute the following:<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;IndexProduct(1)=0"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;IndexProduct(2)=1\times{5}=5"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;IndexProduct(3)=2\times{4}=8"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;IndexProduct(4)=1\times{5}=5"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;IndexProduct(5)=0"><br>

The largest of these is <img src="https://latex.codecogs.com/svg.latex?\Large&space;8">, so it is the answer.

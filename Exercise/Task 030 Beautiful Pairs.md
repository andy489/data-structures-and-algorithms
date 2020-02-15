## Beautiful pairs

[Judge System](https://www.hackerrank.com/contests/101hack34/challenges/beautiful-pairs)

You are given two arrays, <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">, both containing <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> integers.

A pair of indices <img src="https://latex.codecogs.com/svg.latex?\Large&space;(i,j)"> is beautiful if <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> element of array <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> is equal to the <img src="https://latex.codecogs.com/svg.latex?\Large&space;j^{th}"> element of array <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">. In other words, pair <img src="https://latex.codecogs.com/svg.latex?\Large&space;(i,j)"> is beautiful if and only if <img src="https://latex.codecogs.com/svg.latex?\Large&space;A[i]=B[j]">. A set containing beautiful pairs is called a *beautiful set*.

A beautiful set is called *pairwise disjoint* if for every pair <img src="https://latex.codecogs.com/svg.latex?\Large&space;(l[i],r[i])"> belonging to the set there is no repetition of either <img src="https://latex.codecogs.com/svg.latex?\Large&space;l[i]"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;r[i]"> values. For instance, if <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=[10,11,12,5,14]"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B=[8,9,11,11,5]"> the beautiful set <img src="https://latex.codecogs.com/svg.latex?\Large&space;[(1,2),(1,3),(3,4)]"> is not pairwise disjoint as there is a repetition of <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">, that is <img src="https://latex.codecogs.com/svg.latex?\Large&space;l[0][0]=l[1][0]">.

Your task is to change exactly **exactly 1** element in <img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> so that the size of the pairwise disjoint beautiful set is maximum.

#### Input Format

The first line contains a single integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, the number of elements in <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> and .<img src="https://latex.codecogs.com/svg.latex?\Large&space;B">.
The second line contains space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;A[i]">.<br>
The third line contains space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;B[i]">.<br>

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{10^3}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{A[i],B[i]}\le{10^3}">

#### Output Format

Determine and print the maximum possible number of pairwise disjoint beautiful pairs.

**Note:** You must first change <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> element in <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">, and your choice of element must be optimal.

#### Sample Input 0
```
4
1 2 3 4
1 2 3 3
```
#### Sample Output 0
```
4
```
#### Explanation 0

You are given <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=[1,2,3,4]"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B=[1,2,3,3]">.<br>
The beautiful set is <img src="https://latex.codecogs.com/svg.latex?\Large&space;[(0,0),(1,1),(2,2),(3,3)]"> and maximum sized pairwise disjoint beautiful set is either <img src="https://latex.codecogs.com/svg.latex?\Large&space;[(0,0),(1,1),(2,2)]"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;[(0,0),(1,1),(2,3)]">.<br>
We can do better. We change the <img src="https://latex.codecogs.com/svg.latex?\Large&space;3^{rd}"> element of array <img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> from <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;4">. Now new B array is: <img src="https://latex.codecogs.com/svg.latex?\Large&space;B=[1,2,3,4]"> and the pairwise disjoint beautiful set is <img src="https://latex.codecogs.com/svg.latex?\Large&space;[(0,0),(1,1),(2,3),(3,2)]">. So, the answer is 4.<br>
Note that we could have also selected index 3 instead of index 2 but it would have yeilded the same result. Any other choice of index is not optimal.

#### Sample Input 1
```
6
3 5 7 11 5 8
5 7 11 10 5 8
```
#### Sample Output 1
```
6
```

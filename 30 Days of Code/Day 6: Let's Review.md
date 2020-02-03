https://www.hackerrank.com/challenges/30-review-loop/problem

## Day 6: Let's Review

#### Objective
Today we're expanding our knowledge of Strings and combining it with what we've already learned about loops. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-review-loop/tutorial) tab for learning materials and an instructional video!

#### Task
Given a string, <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">, of length <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> that is indexed from <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;N-1">, print its even-indexed and odd-indexed characters as <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> space-separated strings on a single line (see the Sample below for more detail).

**Note:** <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> is considered to be an even index.

#### Input Format

The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;T">(the number of test cases).<br>
Each line <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> subsequent lines contain a String, <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{T}\le{10}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{length{\;}of{\;}S\le{10000}}">

#### Output Format

For each String <img src="https://latex.codecogs.com/svg.latex?\Large&space;S_j">(where <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{j}\le{T-1}">), print <img src="https://latex.codecogs.com/svg.latex?\Large&space;S_j">'s even-indexed characters, followed by a space, followed by <img src="https://latex.codecogs.com/svg.latex?\Large&space;S_j">'s odd-indexed characters.

#### Sample Input
```
2
Hacker
Rank
```
#### Sample Output
```
Hce akr
Rn ak
```
#### Explanation

Test Case 0:**S="Hacker"<br>
**S[0]="H"<br>
**S[1]="a"<br>
**S[2]="c"<br>
**S[3]="k"<br>
**S[4]="e"<br>
**S[5]="r"<br>

The even indices are **0,2**,and **4**, and the odd indices are **1,3** and **5**. We then print a single line of space-separated strings; the first string contains the ordered characters from **S**'s even indices (**Hce**), and the second string contains the ordered characters from **S**'s odd indices (**ark**).

Test Case 1:**S="Rank"**<br>
**S[0]="R"<br>
**S[1]="a"<br>
**S[2]="n"<br>
**S[3]="k"<br>

The even indices are **0** and **2** , and the odd indices are **1** and **3**. We then print a single line of **2** space-separated strings; the first string contains the ordered characters from **S**'s even indices (**Rn**), and the second string contains the ordered characters from **S**'s odd indices (**ak**).

## DFS: Connected Cell in a Grid

[Judge System](https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem)

Consider a matrix where each cell contains either a or a and any cell containing a <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> or a <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> and any cell containing <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. In the diagram below, the two colored regions show cells connected to the filled cells. Black on white are not connected.

Cells adjacent to filled cells: ![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Connected%20Cell%20in%20a%20Grid%2001.png)

If one or more filled cells are also connected, they form a region. Note that each cell in a region is connected to at least one other cell in the region but is not necessarily directly connected to all the other cells in the region.

Regions: ![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Connected%20Cell%20in%20a%20Grid%2002.png)

Given an <img src="https://latex.codecogs.com/svg.latex?\Large&space;n\times{m}"> matrix, find and print the number of cells in the largest region in the matrix.

#### Function Description

Complete the function maxRegion in the editor below. It must return an integer value, the size of the largest region.

maxRegion has the following parameter(s):

- grid: a two dimensional array of integers

#### Input Format

The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, the number of rows in the matrix, <img src="https://latex.codecogs.com/svg.latex?\Large&space;grid">.<br>
The second line contains an integer,<img src="https://latex.codecogs.com/svg.latex?\Large&space;m">, the number of columns in the matrix.<br>Each of the following <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> lines contains a row of <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> space-separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;grid[i][j]">.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0<{n,m}<10"> 
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;grid[i][j]\in{0,1}">

#### Output Format

Print the number of cells in the largest region in the given matrix.

Sample Input|Sample Output
-|-
4<br>4<br>1 1 0 0<br>0 1 1 0<br>0 0 1 0<br>1 0 0 0|5

#### Explanation

The diagram below depicts two regions of the matrix:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Connected%20Cell%20in%20a%20Grid%2003.png)

The first region has five cells and the second region has one cell. We choose the larger region.

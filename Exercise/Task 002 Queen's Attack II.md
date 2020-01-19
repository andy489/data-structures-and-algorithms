## Queen's Attack II

[Judge System](https://www.hackerrank.com/challenges/queens-attack-2/problem)

You will be given a square chess board with one queen and a number of obstacles placed on it. Determine how many squares the queen can attack.

A [queen](https://en.wikipedia.org/wiki/Queen_%28chess%29) is standing on an <img src="https://latex.codecogs.com/svg.latex?\Large&space;n\times{n}"> [chessboard](https://en.wikipedia.org/wiki/Chess). The chess board's rows are numbered from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, going from bottom to top. Its columns are numbered from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, going from left to right. Each square is referenced by a tuple, <img src="https://latex.codecogs.com/svg.latex?\Large&space;(r,c)"> , describing the row, <img src="https://latex.codecogs.com/svg.latex?\Large&space;r">, and column, <img src="https://latex.codecogs.com/svg.latex?\Large&space;c">, where the square is located.

The queen is standing at position <img src="https://latex.codecogs.com/svg.latex?\Large&space;r_q,c_q">. In a single move, she can attack any square in any of the eight directions (left, right, up, down, and the four diagonals). In the diagram below, the green circles denote all the cells the queen can attack from <img src="https://latex.codecogs.com/svg.latex?\Large&space;(4,4)">:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Queen's%20Attack%20II%2001.png)

There are obstacles on the chessboard, each preventing the queen from attacking any square beyond it on that path. For example, an obstacle at location <img src="https://latex.codecogs.com/svg.latex?\Large&space;(3,5)"> in the diagram above prevents the queen from attacking cells <img src="https://latex.codecogs.com/svg.latex?\Large&space;(3,5)">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;(2,6)">, and <img src="https://latex.codecogs.com/svg.latex?\Large&space;(1,7)">:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Queen's%20Attack%20II%2002.png)

Given the queen's position and the locations of all the obstacles, find and print the number of squares the queen can attack from her position at <img src="https://latex.codecogs.com/svg.latex?\Large&space;(r_q,r_c)">. In the board above, there are <img src="https://latex.codecogs.com/svg.latex?\Large&space;24"> such squares.

#### Input Format

The first line contains two space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">, the length of the board's sides and the number of obstacles.<br>
The next line contains two space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;r_q"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_q">, the queen's row and column position.
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> lines contains two space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;r[i]"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;c[i]">, the row and column position of <img src="https://latex.codecogs.com/svg.latex?\Large&space;obstacle[i]">.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{n}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{k}\le{10^5}">
- A single cell may contain more than one obstacle.
- There will never be an obstacle at the position where the queen is located.

#### Subtasks

For <img src="https://latex.codecogs.com/svg.latex?\Large&space;30%"> of the maximum score:

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0<n\le{100}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{k}\le{100}">

For <img src="https://latex.codecogs.com/svg.latex?\Large&space;55%"> of the maximum score:

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0<n\le{1000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{k}\le{10^5}">

#### Output Format

Print the number of squares that the queen can attack from position <img src="https://latex.codecogs.com/svg.latex?\Large&space;(r_q,c_q)">.

Sample Input 0|Sample Output 0
-|-
4 0<br>4 4|9

**Explanation 0**

The queen is standing at position <img src="https://latex.codecogs.com/svg.latex?\Large&space;(4,4)"> on a <img src="https://latex.codecogs.com/svg.latex?\Large&space;4\times{4}"> chessboard with no obstacles:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Queen's%20Attack%20II%2003.png)

Sample Input 1|Sample Output 1
-|-
5 3<br>4 3<br>5 5<br>4 2<br>2 3|10

**Explanation 1**

The queen is standing at position <img src="https://latex.codecogs.com/svg.latex?\Large&space;(4,3)"> on a <img src="https://latex.codecogs.com/svg.latex?\Large&space;5\times{5}"> chessboard with <img src="https://latex.codecogs.com/svg.latex?\Large&space;k=3"> obstacles:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Queen's%20Attack%20II%2004.png)

The number of squares she can attack from that position is <img src="https://latex.codecogs.com/svg.latex?\Large&space;10">.

Sample Input 2|Sample Output 2
-|-
1 0<br>1 1|0

**Explanation 2**

Since there is only one square, and the queen is on it, the queen can move 0 squares.

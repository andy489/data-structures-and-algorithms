## Castle on the Grid

[Judge System](https://www.hackerrank.com/challenges/castle-on-the-grid/problem)

You are given a square grid with some cells open (**.**) and some blocked (**X**). Your playing piece can move along any row or column until it reaches the edge of the grid or a blocked cell. Given a grid, a start and an end position, determine the number of moves it will take to get to the end position.

For example, you are given a grid with sides <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=3"> described as follows:
```
...
.X.
...
```
Your starting position <img src="https://latex.codecogs.com/svg.latex?\Large&space;(startX,startY)=(0,0)"> so you start in the top left corner. The ending position is <img src="https://latex.codecogs.com/svg.latex?\Large&space;(goalX,goalY)=(1,2)">. The path is <img src="https://latex.codecogs.com/svg.latex?\Large&space;(0,0)\rightarrow{(0,2)}\rightarrow{(1,2)}">. It takes <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> moves to get to the goal.

#### Function Description
Complete the minimumMoves function in the editor. It must print an integer denoting the minimum moves required to get from the starting position to the goal.

minimumMoves has the following parameter(s):

- grid: an array of strings representing the rows of the grid
- startX: an integer
- startY: an integer
- goalX: an integer
- goalY: an integer

#### Input Format

The first line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, the size of the array grid.<br>
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> lines contains a string of length <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">.<br>
The last line contains four space-separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;startX,startY,goalX,goalY">

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{100}"><br>
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{startX,startY.goalX,goalY}<n">

#### Output Format

Print an integer denoting the minimum number of steps required to move the castle to the goal position.

Sample Input|Sample Output
-|-
3<br>.X.<br>.X.<br>...<br>0 0 0 2|3

Explanation

Here is a path that one could follow in order to reach the destination in <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> steps:
<img src="https://latex.codecogs.com/svg.latex?\Large&space;(0,0)\rightarrow{(2,0)}\rightarrow{(2,2)}\rightarrow{(0,2)}">.

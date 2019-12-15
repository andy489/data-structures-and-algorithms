## Castle on the Grid

[Judge System](https://www.hackerrank.com/challenges/castle-on-the-grid/problem)

You are given a square grid with some cells open (.) and some blocked (X). Your playing piece can move along any row or column until it reaches the edge of the grid or a blocked cell. Given a grid, a start and an end position, determine the number of moves it will take to get to the end position.

For example, you are given a grid with sides

described as follows:

...
.X.
...

Your starting position
so you start in the top left corner. The ending position is . The path is . It takes

moves to get to the goal.

Function Description
Complete the minimumMoves function in the editor. It must print an integer denoting the minimum moves required to get from the starting position to the goal.

minimumMoves has the following parameter(s):

    grid: an array of strings representing the rows of the grid
    startX: an integer
    startY: an integer
    goalX: an integer
    goalY: an integer

Input Format

The first line contains an integer
, the size of the array grid.
Each of the next lines contains a string of length .
The last line contains four space-separated integers,

Constraints

Output Format

Print an integer denoting the minimum number of steps required to move the castle to the goal position.

Sample Input

3
.X.
.X.
...
0 0 0 2

Sample Output

3

Explanation

Here is a path that one could follow in order to reach the destination in

steps:

.

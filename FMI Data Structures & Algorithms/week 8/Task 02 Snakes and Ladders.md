## Snakes and Ladders: The Quickest Way Up

[Judge System](https://www.hackerrank.com/challenges/the-quickest-way-up/)

Markov takes out his [Snakes and Ladders](https://en.wikipedia.org/wiki/Snakes_and_Ladders) game, stares at the board and wonders: "If I can always roll the die to whatever number I want, what would be the least number of rolls to reach the destination?"

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Snakes%20and%20Ladders%2001.png)

**Rules** The game is played with a cubic die of <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> faces numbered <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;6">.

1. Starting from square <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">, land on square <img src="https://latex.codecogs.com/svg.latex?\Large&space;100"> with the exact roll of the die. If moving the number rolled would place the player beyond square <img src="https://latex.codecogs.com/svg.latex?\Large&space;100">, no move is made.

2. If a player lands at the base of a ladder, the player must climb the ladder. Ladders go up only.

3. If a player lands at the mouth of a snake, the player must go down the snake and come out through the tail. Snakes go down only.

#### Function Description

Complete the quickestWayUp function in the editor below. It should return an integer that represents the minimum number of moves required.

quickestWayUp has the following parameter(s):
- ladders: a 2D integer array where each <img src="https://latex.codecogs.com/svg.latex?\Large&space;ladders[i]"> contains the start and end cell numbers of a ladder
- snakes: a 2D integer array where each <img src="https://latex.codecogs.com/svg.latex?\Large&space;snakes[i]"> contains the start and end cell numbers of a snake

#### Input Format

The first line contains the number of tests, <img src="https://latex.codecogs.com/svg.latex?\Large&space;t">.

For each testcase:
- The first line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, the number of ladders.
- Each of the next lines contains two space-separated integers, the start and end of a ladder.
- The next line contains the integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;m">, the number of snakes.
- Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> lines contains two space-separated integers, the start and end of a snake.

#### Constraints

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{t}\le{10}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n,m}\le{15}">

The board is always <img src="https://latex.codecogs.com/svg.latex?\Large&space;10\times{10}"> with squares numbered <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;100">.

Neither square <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> nor square <img src="https://latex.codecogs.com/svg.latex?\Large&space;100"> will be the starting point of a ladder or snake.<br>
A square will have at most one endpoint from either a snake or a ladder.

#### Output Format

For each of the t test cases, print the least number of rolls to move from start to finish on a separate line. If there is no solution, print -1.

Sample Input|Sample Output|Explanation
-|-|-
2<br>3<br>32 62<br>42 68<br>12 98<br>7<br>95 13<br>97 25<br>93 37<br>79 27<br>75 19<br>49 47<br>67 17<br>4<br>8 52<br>6 80<br>26 42<br>2 72<br>9<br>51 19<br>39 11<br>37 29<br>81 3<br>59 5<br>79 23<br>53 7<br>43 33<br>77 21|3<br>5|*For the first test:*<br><br>The player can roll a <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> and a <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> to land at square <img src="https://latex.codecogs.com/svg.latex?\Large&space;12">. There is a ladder to square <img src="https://latex.codecogs.com/svg.latex?\Large&space;98">. A roll of <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> ends the traverse in <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> rolls.<br>*For the second test:*<br><br>The player first rolls <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> and climbs the ladder to square <img src="https://latex.codecogs.com/svg.latex?\Large&space;80">. Three rolls of <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> get to square <img src="https://latex.codecogs.com/svg.latex?\Large&space;98">. A final roll of <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> lands on the target square in <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> total rolls. 

## Mr. X and His Shots

[Judge System](https://www.hackerrank.com/challenges/x-and-his-shots/problem)

A cricket match is going to be held. The field is represented by a 1D plane. A cricketer, Mr. X has <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> favorite shots. Each shot has a particular range. The range of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> shot is from <img src="https://latex.codecogs.com/svg.latex?\Large&space;A_i"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;B_i">. That means his favorite shot can be anywhere in this range. Each player on the opposite team can field only in a particular range. Player <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> can field from <img src="https://latex.codecogs.com/svg.latex?\Large&space;C_i"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;D_i">. You are given the <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> favorite shots of Mr. X and the range of <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> players.

<img src="https://latex.codecogs.com/svg.latex?\Large&space;S_i"> represents the strength of each player i.e. the number of shots player <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> can stop.

Your task is to find: <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sum_{i=1}^{m}S_i">.

**Game Rules:** A player can stop the <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> shot if the range overlaps with the player's fielding range.

For more clarity about overlapping, study the following figure:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Mr.X%20and%20His%20Shots%2001.png)

#### Input Format

The first line consists of two space separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;N}"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;M">.<br>
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> lines contains two space separated integers. The <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;A_i"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;B_i">.<br>
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> lines contains two integers. The <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> line contains integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;C_i"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;D_i">.

#### Output Format

You need to print the sum of the strengths of all the players: <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sum_{i=1}^{m}S_i">.

#### Constraints:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N,M}\le{10^5}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{A_i,B_i,C_i,D_i}\le{10^8}">

#### Sample Input
```
4 4                
1 2 
2 3
4 5
6 7
1 5
2 3
4 7
5 7   
```
#### Sample Output
```
9
```
#### Explanation

*Player 1* can stop the 1st, 2nd and 3rd shot so the strength is <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">.<br>
*Player 2* can stop the 1st and 2nd shot so the strength is <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">.<br>
*Player 3* can stop the 3rd and 4th shot so the strength is <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">.<br>
*Player 4* can stop the 3rd and 4th shot so the strength is <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">.<br>

The sum of the strengths of all the players is <img src="https://latex.codecogs.com/svg.latex?\Large&space;3+2+2+2=9">.

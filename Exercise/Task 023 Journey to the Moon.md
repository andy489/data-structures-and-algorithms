## Journey to the Moon

[Judge System](https://www.hackerrank.com/challenges/journey-to-the-moon/problem)

The member states of the UN are planning to send <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> people to the moon. They want them to be from different countries. You will be given a list of pairs of astronaut ID's. Each pair is made of astronauts from the same country. Determine how many pairs of astronauts from different countries they can choose from.

For example, we have the following data on 2 pairs of astronauts, and 4 astronauts total, numbered <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> through <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">.
```
1   2
2   3
```
Astronauts by country are <img src="https://latex.codecogs.com/svg.latex?\Large&space;[0]"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;[1,2,3]">. There are <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> pairs to choose from: <img src="https://latex.codecogs.com/svg.latex?\Large&space;[0,1],[0,2]"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;[0,3]">.

#### Function Description

Complete the journeyToMoon function in the editor below. It should return an integer that represents the number of valid pairs that can be formed.

journeyToMoon has the following parameter(s):

- n: an integer that denotes the number of astronauts
- astronaut: a 2D array where each element  <img src="https://latex.codecogs.com/svg.latex?\Large&space;astronaut[i]"> is a <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> element integer array that represents the ID's of two astronauts from the same country

#### Input Format

The first line contains two integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;p">, the number of astronauts and the number of pairs.<br>
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;p"> lines contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> space-separated integers denoting astronaut ID's of two who share the same nationality.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{p}\le{10^4}">

#### Output Format

An integer that denotes the number of ways to choose a pair of astronauts from different coutries.

#### Sample Input 0
```
5 3
0 1
2 3
0 4
```
#### Sample Output 0
```
6
```
#### Explanation 0

Persons numbered <img src="https://latex.codecogs.com/svg.latex?\Large&space;[0,1,4]"> belong to one country, and those numbered <img src="https://latex.codecogs.com/svg.latex?\Large&space;[2,3]"> belong to another. The UN has <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> ways of choosing a pair:<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;[0,2],[0,3],[1,2],[1,3],[4,2],[4,3]">

#### Sample Input 1
```
4 1
0 2
```
#### Sample Output 1
```
5
```
#### Explanation 1

Persons numbered <img src="https://latex.codecogs.com/svg.latex?\Large&space;[0,2]"> belong to the same country, but persons <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> don't share countries with anyone else. The UN has <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> ways of choosing a pair:<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;[0,1],[0,3],[1,2],[1,3],[2,3]">


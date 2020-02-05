## Game of Two Stacks

[Judge System](https://www.hackerrank.com/challenges/game-of-two-stacks/problem)

Alexa has two stacks of non-negative integers, stack <img src="https://latex.codecogs.com/svg.latex?\Large&space;A=[a_0,a_1,...a_{n-1}]"> and stack <img src="https://latex.codecogs.com/svg.latex?\Large&space;B=[b_0,b_1,...,b_{n-1}]"> where index <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> denotes the top of the stack. Alexa challenges Nick to play the following game:

- In each move, Nick can remove one integer from the top of either stack <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> or stack <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">.
- Nick keeps a running sum of the integers he removes from the two stacks.
- Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;x"> given at the beginning of the game.
- Nick's final score is the total number of integers he has removed from the two stacks.

Given <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">, and <img src="https://latex.codecogs.com/svg.latex?\Large&space;x"> for <img src="https://latex.codecogs.com/svg.latex?\Large&space;g"> games, find the maximum possible score Nick can achieve (i.e., the maximum number of integers he can remove without being disqualified) during each game and print it on a new line.

#### Input Format

The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;g">(the number of games). The <img src="https://latex.codecogs.com/svg.latex?\Large&space;3\cdot{g}"> subsequent lines describe each game in the following format:

1. The first line contains three space-separated integers describing the respective values of <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> (the number of integers in stack <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">), (the number of integers in stack <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">), and <img src="https://latex.codecogs.com/svg.latex?\Large&space;x">(the number that the sum of the integers removed from the two stacks cannot exceed).
2. The second line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> space-separated integers describing the respective values of <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_0,a_1,...,a_{n-1}">.
The third line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> space-separated integers describing the respective values of <img src="https://latex.codecogs.com/svg.latex?\Large&space;b_0,b_1,...,b_{m-1}">.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{g}\le{50}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n,m}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{a_i,b_j}\le{10^6}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{x}\le{10^9}">
#### Subtasks
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n,m}\le{100}"> for <img src="https://latex.codecogs.com/svg.latex?\Large&space;50%"> of the maximum score.

#### Output Format

For each of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;g"> games, print an integer on a new line denoting the maximum possible score Nick can achieve without being disqualified.

#### Sample Input 0
```
1
5 4 10
4 2 4 6 1
2 1 8 5
```
#### Sample Output 0
```
4
```
#### Explanation 0

The two stacks initially look like this:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Game%20of%20Two%20Stacks%2001.png)

The image below depicts the integers Nick should choose to remove from the stacks. We print <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> as our answer, because that is the maximum number of integers that can be removed from the two stacks without the sum exceeding <img src="https://latex.codecogs.com/svg.latex?\Large&space;x=10">.

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Game%20of%20Two%20Stacks%2002.png)

(There can be multiple ways to remove the integers from the stack, the image shows just one of them.)

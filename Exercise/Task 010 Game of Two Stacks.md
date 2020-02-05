## Game of Two Stacks

[Judge System](https://www.hackerrank.com/challenges/game-of-two-stacks/problem)

Alexa has two stacks of non-negative integers, stack <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"=[a_0,a_1,...a_{n-1}]"> and stack where index

denotes the top of the stack. Alexa challenges Nick to play the following game:

    In each move, Nick can remove one integer from the top of either stack 

or stack
.
Nick keeps a running sum of the integers he removes from the two stacks.
Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer

    given at the beginning of the game.
    Nick's final score is the total number of integers he has removed from the two stacks.

Given
, , and for

games, find the maximum possible score Nick can achieve (i.e., the maximum number of integers he can remove without being disqualified) during each game and print it on a new line.

Input Format

The first line contains an integer,
(the number of games). The

subsequent lines describe each game in the following format:

    The first line contains three space-separated integers describing the respective values of 

(the number of integers in stack ), (the number of integers in stack ), and
(the number that the sum of the integers removed from the two stacks cannot exceed).
The second line contains
space-separated integers describing the respective values of
.
The third line contains
space-separated integers describing the respective values of

    .

Constraints

Subtasks

for

    of the maximum score.

Output Format

For each of the

games, print an integer on a new line denoting the maximum possible score Nick can achieve without being disqualified.

Sample Input 0

1
5 4 10
4 2 4 6 1
2 1 8 5

Sample Output 0

4

Explanation 0

The two stacks initially look like this:

image

The image below depicts the integers Nick should choose to remove from the stacks. We print
as our answer, because that is the maximum number of integers that can be removed from the two stacks without the sum exceeding

.

image

(There can be multiple ways to remove the integers from the stack, the image shows just one of them.)

## Equal Stacks

[Judge System](https://www.hackerrank.com/challenges/equal-stacks/problem)

You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're all the same height, then print the height. The removals must be performed in such a way as to maximize the height.

**Note:** An empty stack is still a stack.

#### Input Format

The first line contains three space-separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n_1">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n_2"> , and <img src="https://latex.codecogs.com/svg.latex?\Large&space;n_3">, describing the respective number of cylinders in stacks <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> , and <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">. The subsequent lines describe the respective heights of each cylinder in a stack *from top to bottom*:

- The second line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n_1"> space-separated integers describing the cylinder heights in stack <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">. The first element is the top of the stack.
- The third line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n_2"> space-separated integers describing the cylinder heights in stack <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">. The first element is the top of the stack.
- The fourth line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n_3"> space-separated integers describing the cylinder heights in stack <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">. The first element is the top of the stack.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0<n_1,n_2,n_3\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0<height_of_any_cylinder\le{100}">

#### Output Format

Print a single integer denoting the maximum height at which all stacks will be of equal height.

#### Sample Input
```
5 3 4
3 2 1 1 1
4 3 2
1 1 4 1
```
#### Sample Output
```
5
```
#### Explanation

Initially, the stacks look like this:

![]()

Observe that the three stacks are not all the same height. To make all stacks of equal height, we remove the first cylinder from stacks <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">, and then remove the top two cylinders from stack <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">(shown below).

![]()

As a result, the stacks undergo the following change in height:

1. <img src="https://latex.codecogs.com/svg.latex?\Large&space;8-3=5"><br>
2. <img src="https://latex.codecogs.com/svg.latex?\Large&space;9-4=5"><br>
3. <img src="https://latex.codecogs.com/svg.latex?\Large&space;7-1-1=5">

All three stacks now have <img src="https://latex.codecogs.com/svg.latex?\Large&space;height=5">. Thus, we print <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> as our answer.

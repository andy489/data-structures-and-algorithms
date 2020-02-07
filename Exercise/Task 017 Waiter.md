## Waiter

[Judge System](https://www.hackerrank.com/challenges/waiter/problem)

You are a waiter at a party. There are <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> stacked plates on pile <img src="https://latex.codecogs.com/svg.latex?\Large&space;A_0">. Each plate has a number written on it. Then there will be <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> iterations. In <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> iteration, you start picking up the plates in <img src="https://latex.codecogs.com/svg.latex?\Large&space;A_{i-1}"> from the top one by one and check whether the number written on the plate is divisible by the <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> prime. If the number is divisible, you stack that plate on pile <img src="https://latex.codecogs.com/svg.latex?\Large&space;B_i">. Otherwise, you stack that plate on pile <img src="https://latex.codecogs.com/svg.latex?\Large&space;A_i">. After <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> iterations, plates can only be on pile <img src="https://latex.codecogs.com/svg.latex?\Large&space;B_1,B_2,...,B_Q,A_Q">. Output numbers on these plates from top to bottom of each piles in order of <img src="https://latex.codecogs.com/svg.latex?\Large&space;B_1,B_2,...,B_Q,A_Q">.

#### Input Format

The first line contains two space separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q">.<br>
The next line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> space separated integers representing the initial pile of plates, i.e., <img src="https://latex.codecogs.com/svg.latex?\Large&space;A_0">. The leftmost value represents the bottom plate of the pile.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{5\times{10^4}}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{number_i}\le{5\times{10^4}}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{Q}\le{5\times{1200}}">

#### Output Format

Output <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> lines. Each line contains a number written on the plate. Printing should be done in the order defined above.

#### Sample Input 0
```
5 1
3 4 7 6 5
```
#### Sample Output 0
```
4
6
3
7
5
```
#### Explanation 0

Initially:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;A_0=[3,4,7,6,5]\leftarrow{top}">

After 1 iteration:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;A_0=\varnothing"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;B_1=[6,4]\leftarrow{top}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;A_1=[5,7,3]\leftarrow{top}">

We should output numbers in <img src="https://latex.codecogs.com/svg.latex?\Large&space;B_1"> first from top to bottom, and then output numbers in <img src="https://latex.codecogs.com/svg.latex?\Large&space;A_1"> from top to bottom.

#### Sample Input 1
```
5 2
3 3 4 4 9
```
#### Sample Output 1
```
4
4
9
3
3
```
#### Explanation 1

Initially:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;A_0=[3,3,4,4,9]\leftarrow{top}">

After <img src="https://latex.codecogs.com/svg.latex?\Large&space;1^{st}"> iteration:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;A_0=\varnothing"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;B_1=[4,4]\leftarrow{top}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;B_1=[3,3,9]\leftarrow{top}"><br>

After <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^{nd}"> iteration:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;A_1=\varnothing"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;B_1=[4,4]\leftarrow{top}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;B_2=[3,3,9]\leftarrow{top}"><br>

We should output numbers in <img src="https://latex.codecogs.com/svg.latex?\Large&space;B_1"> first from top to bottom, and then output numbers in <img src="https://latex.codecogs.com/svg.latex?\Large&space;B_2"> from top to bottom.

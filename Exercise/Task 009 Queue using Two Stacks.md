## Queue using Two Stacks

![Judge System](https://www.hackerrank.com/challenges/queue-using-two-stacks/problem)

A [queue](https://en.wikipedia.org/wiki/Queue_%28abstract_data_type%29) is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.

A basic queue has the following operations:

- Enqueue: add a new element to the end of the queue.
- Dequeue: remove the element from the front of the queue and return it.

In this challenge, you must first implement a queue using two stacks. Then process <img src="https://latex.codecogs.com/svg.latex?\Large&space;q"> queries, where each query is one of the following <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> types:

- 1 x: Enqueue element <img src="https://latex.codecogs.com/svg.latex?\Large&space;x"> into the end of the queue.
- 2: Dequeue the element at the front of the queue.
- 3: Print the element at the front of the queue.

#### Input Format

The first line contains a single integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;q">, denoting the number of queries.<br>
Each line <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;q"> subsequent lines contains a single query in the form described in the problem statement above. All three queries start with an integer denoting the query <img src="https://latex.codecogs.com/svg.latex?\Large&space;type">, but only <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> query is followed by an additional space-separated value, <img src="https://latex.codecogs.com/svg.latex?\Large&space;x">, denoting the value to be enqueued.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{q}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{type}\le{3}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{|x|}\le{10^9}">
- It is guaranteed that a valid answer always exists for each query of type <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">.

#### Output Format

For each query of type <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">, print the value of the element at the front of the queue on a new line.

#### Sample Input
```
10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2
```
#### Sample Output
```
14
14
```
#### Explanation

We perform the following sequence of actions:<br>
1.Enqueue <img src="https://latex.codecogs.com/svg.latex?\Large&space;42;queue=\{42\}">.<br>
3.Enqueue <img src="https://latex.codecogs.com/svg.latex?\Large&space;14;queue=\{14\}">.<br>
4.Print the value at the head of the queue,<img src="https://latex.codecogs.com/svg.latex?\Large&space;14;queue=\{\14}"><br>
5.Enqueue <img src="https://latex.codecogs.com/svg.latex?\Large&space;28;queue=\{14,28\}">.<br>
6.Print the value at the head of the queue,<img src="https://latex.codecogs.com/svg.latex?\Large&space;14;queue=\{14,28\}">.<br>
7.Enqueue <img src="https://latex.codecogs.com/svg.latex?\Large&space;60;queue=\{14,28,60\}">.<br>
8.Enqueue <img src="https://latex.codecogs.com/svg.latex?\Large&space;78;queue=\{14,28,60,78\}">.<br>
9.Dequeue the value at the head of the queue, <img src="https://latex.codecogs.com/svg.latex?\Large&space;14;queue=\{28,60,78">.<br>
10.Dequeue the value at the head of the queue,<img src="https://latex.codecogs.com/svg.latex?\Large&space;28;queue=\{60,78\}">.

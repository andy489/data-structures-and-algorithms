[Link](https://www.hackerrank.com/challenges/30-linked-list/problem)

## Day 15: Linked List

#### Objective
Today we're working with Linked Lists. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-linked-list/tutorial) tab for learning materials and an instructional video!

A Node class is provided for you in the editor. A Node object has an integer data field, <img src="https://latex.codecogs.com/svg.latex?\Large&space;data">, and a Node instance pointer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;next">, pointing to another node (i.e.: the next node in a list).

A Node insert function is also declared in your editor. It has two parameters: a pointer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;head">, pointing to the first node of a linked list, and an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;data"> value that must be added to the end of the list as a new Node object.

#### Task
Complete the insert function in your editor so that it creates a new Node (pass <img src="https://latex.codecogs.com/svg.latex?\Large&space;data"> as the Node constructor argument) and inserts it at the tail of the linked list referenced by the <img src="https://latex.codecogs.com/svg.latex?\Large&space;head"> parameter. Once the new node is added, return the reference to the <img src="https://latex.codecogs.com/svg.latex?\Large&space;head"> node.

**Note:** If the <img src="https://latex.codecogs.com/svg.latex?\Large&space;head"> argument passed to the insert function is null, then the initial list is empty.

#### Input Format

The insert function has <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> parameters: a pointer to a Node named <img src="https://latex.codecogs.com/svg.latex?\Large&space;head">, and an integer value, <img src="https://latex.codecogs.com/svg.latex?\Large&space;data">. The constructor for Node has <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> parameter: an integer value for the <img src="https://latex.codecogs.com/svg.latex?\Large&space;data"> field.

You do not need to read anything from stdin.

#### Output Format

Your insert function should return a reference to the <img src="https://latex.codecogs.com/svg.latex?\Large&space;head"> node of the linked list.

#### Sample Input

The following input is handled for you by the locked code in the editor:<br>
The first line contains T, the number of test cases.<br>
The <img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> subsequent lines of test cases each contain an integer to be inserted at the list's tail.
```
4
2
3
4
1
```
### Sample Output

The locked code in your editor prints the ordered data values for each element in your list as a single line of space-separated integers:
```
2 3 4 1
```
#### Explanation

<img src="https://latex.codecogs.com/svg.latex?\Large&space;T=4">, so the locked code in the editor will be inserting <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> nodes.<br>
The list is initially empty, so <img src="https://latex.codecogs.com/svg.latex?\Large&space;head"> is null; accounting for this, our code returns a new node containing the data value <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> as the <img src="https://latex.codecogs.com/svg.latex?\Large&space;head"> of our list. We then create and insert nodes <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> , and <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> at the tail of our list. The resulting list returned by the last call to is , so the printed output is 2 3 4 1.

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Linked%20List%2001.png)

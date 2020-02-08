## Inserting a Node Into a Sorted Doubly Linked List

[Judge System](https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem)

Given a reference to the head of a doubly-linked list and an integer,<img src="https://latex.codecogs.com/svg.latex?\Large&space;data"> , create a new *DoublyLinkedListNode* object having data value <img src="https://latex.codecogs.com/svg.latex?\Large&space;data"> and insert it into a sorted linked list while maintaining the sort.

#### Function Description

Complete the *sortedInsert* function in the editor below. It must return a reference to the head of your modified DoublyLinkedList.

sortedInsert has two parameters:
1. head: A reference to the head of a doubly-linked list of DoublyLinkedListNode objects.<br>
2. data: An integer denoting the value of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;data"> field for the DoublyLinkedListNode you must insert into the list.

**Note:** Recall that an empty list (i.e., where <img src="https://latex.codecogs.com/svg.latex?\Large&space;head=null">) and a list with one element are sorted lists.

#### Input Format

The first line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;t">, the number of test cases.

Each of the test case is in the following format:

- The first line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, the number of elements in the linked list.
- Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> lines contains an integer, the data for each node of the linked list.
- The last line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;data"> which needs to be inserted into the sorted doubly-linked list.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{t}\le{10}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{1000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{DoublyLinkedListNode.data}\le{1000}">

#### Output Format

**Do not print anything to stdout.** Your method must return a reference to the <img src="https://latex.codecogs.com/svg.latex?\Large&space;head"> of the same list that was passed to it as a parameter.

The ouput is handled by the code in the editor and is as follows:<br>
For each test case, print the elements of the sorted doubly-linked list separated by spaces on a new line.

#### Sample Input
```
1
4
1
3
4
10
5
```
#### Sample Output
```
1 3 4 5 10
```
#### Explanation

The initial doubly linked list is: <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\leftrightarrow{3}\leftrightarrow{4}\leftrightarrow{10\rightarrow{NULL}}">.

The doubly linked list after insertion is: <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\leftrightarrow{3}\leftrightarrow{4}\leftrightarrow{5}\leftrightarrow{10}\rightarrow{NULL}">.

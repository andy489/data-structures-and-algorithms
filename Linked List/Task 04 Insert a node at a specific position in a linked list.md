## Insert a node at a specific position in a linked list

[Judge System](https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem)

This challenge is part of a tutorial track by [MyCodeSchool](https://www.youtube.com/user/mycodeschool) and is accompanied by a video lesson.

You’re given the pointer to the head node of a linked list, an integer to add to the list and the position at which the integer must be inserted. Create a new node with the given integer, insert this node at the desired position and return the head node.

A position of 0 indicates head, a position of 1 indicates one node away from the head and so on. The head pointer given may be null meaning that the initial list is empty.

As an example, if your list starts as <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\rightarrow{2}\rightarrow{3}"> and you want to insert a node at position <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> with <img src="https://latex.codecogs.com/svg.latex?\Large&space;data=4">, your new list should be <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\rightarrow{2}\rightarrow{4}\rightarrow{3}">

**Function Description** Complete the function insertNodeAtPosition in the editor below. It must return a reference to the head node of your finished list.

*insertNodeAtPosition* has the following parameters:

- head: a SinglyLinkedListNode pointer to the head of the list
- data: an integer value to insert as data in your new node
- position: an integer position to insert the new node, zero based indexing

#### Input Format

The first line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, the number of elements in the linked list.<br>
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> lines contains an integer SinglyLinkedListNode[i].data.<br>
The next line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;data"> denoting the data of the node that is to be inserted.<br>
The last line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;position">.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{1000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{SinglyLinkedListNode[i].data}\le{1000}">, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;SinglyLinkedListNode[i]"> is the <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> element of the linked list.<br>
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{position}\le{n}">.

#### Output Format

Return a reference to the list head. Locked code prints the list for you.

#### Sample Input
```
3
16
13
7
1
2
```
#### Sample Output
```
16 13 1 7
```
#### Explanation

The initial linked list is 16 13 7. We have to insert <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> at the position <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> which currently has <img src="https://latex.codecogs.com/svg.latex?\Large&space;7"> in it. The updated linked list will be 16 13 1 7

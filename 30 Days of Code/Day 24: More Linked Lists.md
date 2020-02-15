https://www.hackerrank.com/challenges/30-linked-list-deletion/problem

## Day 24: More Linked Lists

#### Objective
Check out the [Tutorial](https://www.hackerrank.com/challenges/30-linked-list-deletion/tutorial) tab for learning materials and an instructional video!

#### Task
A Node class is provided for you in the editor. A Node object has an integer data field, <img src="https://latex.codecogs.com/svg.latex?\Large&space;data">, and a Node instance pointer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;next">, pointing to another node (i.e.: the next node in a list).

A removeDuplicates function is declared in your editor, which takes a pointer to the <img src="https://latex.codecogs.com/svg.latex?\Large&space;head"> node of a linked list as a parameter. Complete removeDuplicates so that it deletes any duplicate nodes from the list and returns the head of the updated list.

**Note:** The <img src="https://latex.codecogs.com/svg.latex?\Large&space;head"> pointer may be null, indicating that the list is empty. Be sure to reset your <img src="https://latex.codecogs.com/svg.latex?\Large&space;next"> pointer when performing deletions to avoid breaking the list.

#### Input Format

You do not need to read any input from stdin. The following input is handled by the locked stub code and passed to the removeDuplicates function:<br>
The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">, the number of nodes to be inserted.<br>
The <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> subsequent lines each contain an integer describing the <img src="https://latex.codecogs.com/svg.latex?\Large&space;data"> value of a node being inserted at the list's tail.

#### Constraints

- The data elements of the linked list argument will always be in non-decreasing order.

#### Output Format

Your removeDuplicates function should return the head of the updated linked list. The locked stub code in your editor will print the returned list to stdout.

#### Sample Input
```
6
1
2
2
3
3
4
```
#### Sample Output
```
1 2 3 4 
```
#### Explanation

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N=6">, and our non-decreasing list is <img src="https://latex.codecogs.com/svg.latex?\Large&space;3\{1,2,2,3,3,4\}">. The values <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> both occur twice in the list, so we remove the two duplicate nodes. We then return our updated (ascending) list, which is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\{1,2,3,4\}">.

## Inserting a Node Into a Sorted Doubly Linked List

[Judge System](https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem)

Given a reference to the head of a doubly-linked list and an integer, , create a new DoublyLinkedListNode object having data value

and insert it into a sorted linked list while maintaining the sort.

Function Description

Complete the sortedInsert function in the editor below. It must return a reference to the head of your modified DoublyLinkedList.

sortedInsert has two parameters:

    head: A reference to the head of a doubly-linked list of DoublyLinkedListNode objects.
    data: An integer denoting the value of the 

    field for the DoublyLinkedListNode you must insert into the list.

Note: Recall that an empty list (i.e., where

) and a list with one element are sorted lists.

Input Format

The first line contains an integer

, the number of test cases.

Each of the test case is in the following format:

    The first line contains an integer 

, the number of elements in the linked list.
Each of the next
lines contains an integer, the data for each node of the linked list.
The last line contains an integer

    which needs to be inserted into the sorted doubly-linked list.

Constraints

Output Format

Do not print anything to stdout. Your method must return a reference to the

of the same list that was passed to it as a parameter.

The ouput is handled by the code in the editor and is as follows:
For each test case, print the elements of the sorted doubly-linked list separated by spaces on a new line.

Sample Input

1
4
1
3
4
10
5

Sample Output

1 3 4 5 10

Explanation

The initial doubly linked list is:

.

The doubly linked list after insertion is: 

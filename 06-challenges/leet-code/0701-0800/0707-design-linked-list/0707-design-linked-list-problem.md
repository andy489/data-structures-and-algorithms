# 707. Design Linked List

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-linked-list/

---

## Problem Statement

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: `val` and `next`. A node in a doubly linked list should have an additional attribute `prev`.

Implement the `MyLinkedList` class:
- `MyLinkedList()` Initializes the `MyLinkedList` object.
- `int get(int index)` Get the value of the `index`th node in the linked list. Return `-1` if invalid.
- `void addAtHead(int val)` Add a node of value `val` before the first element of the linked list.
- `void addAtTail(int val)` Append a node of value `val` as the last element.
- `void addAtIndex(int index, int val)` Add a node of value `val` before the `index`th node. If `index` equals the length, append. If `index` is greater than the length, do not insert.
- `void deleteAtIndex(int index)` Delete the `index`th node.

---

## Examples

**Example 1:**
```
Input:  ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        [[],[1],[3],[1,2],[1],[1],[1]]
Output: [null,null,null,null,2,null,3]
```

---

## Constraints

- `0 <= index, val <= 1000`
- Please do not use the built-in LinkedList library.
- At most `2000` calls will be made to `get`, `addAtHead`, `addAtTail`, `addAtIndex`, and `deleteAtIndex`.

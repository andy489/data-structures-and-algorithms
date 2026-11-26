# 138. Copy List with Random Pointer

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/copy-list-with-random-pointer/

---

## Problem Statement

A linked list of length `n` is given such that each node contains an additional **random pointer**, which could point to any node in the list, or `null`.

Construct a **deep copy** of the list. The deep copy should consist of exactly `n` brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the `next` and `random` pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and the copied list represent the same list state. **None of the pointers in the new list should point to nodes in the original list.**

---

## Examples

**Example 1:**

```
Input:  head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output:         [[7,null],[13,0],[11,4],[10,2],[1,0]]
```

**Example 2:**

```
Input:  head = [[1,1],[2,1]]
Output:         [[1,1],[2,1]]
```

**Example 3:**

```
Input:  head = [[3,null],[3,0],[3,null]]
Output:         [[3,null],[3,0],[3,null]]
```

---

## Constraints

- `0 <= n <= 1000`
- `-10⁴ <= Node.val <= 10⁴`
- `Node.random` is `null` or points to some node in the linked list

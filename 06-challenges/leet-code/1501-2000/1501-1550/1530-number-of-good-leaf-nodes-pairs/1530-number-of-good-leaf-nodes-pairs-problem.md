# 1530. Number of Good Leaf Nodes Pairs

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/

---

## Problem Statement

You are given the `root` of a binary tree and an integer `distance`. A pair of two different leaf nodes of a binary tree is said to be good if the length of the shortest path between them is less than or equal to `distance`.

Return the number of good leaf node pairs in the tree.

---

## Examples

**Example 1:**
```
Input: root = [1,2,3,null,4], distance = 3
Output: 1
Explanation: The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3.
```

**Example 2:**
```
Input: root = [1,2,3,4,5,6,7], distance = 3
Output: 2
Explanation: The good pairs are [4,5] and [6,7] with shortest path = 2.
```

---

## Constraints
- The number of nodes in the tree is in the range `[1, 2^10]`.
- `1 <= Node.val <= 100`
- `1 <= distance <= 10`

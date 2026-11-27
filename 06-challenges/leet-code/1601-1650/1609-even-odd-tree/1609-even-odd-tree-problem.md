# 1609. Even Odd Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/even-odd-tree/

---

## Problem Statement

A binary tree is named **Even-Odd** if it meets the following conditions:

- The root of the binary tree is at level index `0`, its children are at level index `1`, their children are at level index `2`, etc.
- For every **even-indexed** level, all nodes at the level have **odd** integer values in **strictly increasing** order (from left to right).
- For every **odd-indexed** level, all nodes at the level have **even** integer values in **strictly decreasing** order (from left to right).

Given the `root` of a binary tree, return `true` if the binary tree is **Even-Odd**, otherwise return `false`.

---

## Examples

**Example 1:**
```
Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
Output: true
Explanation:
  Level 0: [1]       — odd values, trivially sorted
  Level 1: [10,4]    — even values, strictly decreasing ✓
  Level 2: [3,7,9]   — odd values, strictly increasing ✓
  Level 3: [12,8,6,2]— even values, strictly decreasing ✓
```

**Example 2:**
```
Input: root = [5,4,2,3,3,7]
Output: false
Explanation: Level 2: [3,3] — not strictly increasing.
```

---

## Constraints

- The number of nodes in the tree is in the range `[1, 10^5]`
- `1 <= Node.val <= 10^6`

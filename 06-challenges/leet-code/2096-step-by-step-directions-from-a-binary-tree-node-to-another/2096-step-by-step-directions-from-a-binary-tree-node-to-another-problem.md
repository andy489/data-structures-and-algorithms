# 2096. Step-By-Step Directions From a Binary Tree Node to Another

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

---

## Problem Statement

Given a binary tree with unique values and two node values `startValue` and `destValue`, return the **shortest path** directions as a string of 'L' (go left), 'R' (go right), 'U' (go up).

---

## Examples

**Example 1:**
```
Input:  root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
Output: "UURL"
```

**Example 2:**
```
Input:  root = [2,1], startValue = 2, destValue = 1
Output: "L"
```

---

## Constraints

- `The number of nodes in the tree is n.`
- `2 <= n <= 10^5`
- `1 <= Node.val <= 10^5`
- `All Node.val are unique.`
- `startValue != destValue`

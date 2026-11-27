# 988. Smallest String Starting From Leaf

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/smallest-string-starting-from-leaf/

---

## Problem Statement

You are given the `root` of a binary tree where each node has a value in the range `[0, 25]` representing the letters `'a'` to `'z'`.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

---

## Examples

**Example 1:**
```
Input:  root = [0,1,2,3,3,null,null]
Output: "dba"
```

**Example 2:**
```
Input:  root = [25,1,3,1,3,0,2]
Output: "adz"
```

---

## Constraints

- The number of nodes in the tree is in the range `[1, 8500]`.
- `0 <= Node.val <= 25`

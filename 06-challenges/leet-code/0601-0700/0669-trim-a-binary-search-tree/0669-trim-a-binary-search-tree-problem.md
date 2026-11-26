# 669. Trim a Binary Search Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/trim-a-binary-search-tree/

---

## Problem Statement

Given the `root` of a binary search tree and the lowest and highest boundaries as `low` and `high`, trim the tree so that all its values are in `[low, high]`. Trimming the tree should not change the relative structure of the remaining nodes. It can be proven that there is a **unique answer**.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

---

## Examples

**Example 1:**
```
Input:  root = [1,0,2], low = 1, high = 2
Output: [1,null,2]
```

**Example 2:**
```
Input:  root = [3,0,4,null,2,null,null,1], low = 1, high = 3
Output: [3,2,null,1]
```

---

## Constraints

- The number of nodes in the tree is in the range `[1, 10⁴]`.
- `0 <= Node.val <= 10⁴`
- The value of each node in the tree is **unique**.
- `root` is guaranteed to be a valid binary search tree.
- `0 <= low <= high <= 10⁴`

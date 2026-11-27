# 119. Pascal's Triangle II

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/pascals-triangle-ii/

---

## Problem Statement

Given an integer `rowIndex`, return the `rowIndexth` (**0-indexed**) row of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

```
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
```

**Follow up:** Could you optimize your algorithm to use only `O(rowIndex)` extra space?

---

## Examples

**Example 1:**
```
Input:  rowIndex = 3
Output: [1,3,3,1]
```

**Example 2:**
```
Input:  rowIndex = 0
Output: [1]
```

**Example 3:**
```
Input:  rowIndex = 1
Output: [1,1]
```

---

## Constraints

- `0 <= rowIndex <= 33`

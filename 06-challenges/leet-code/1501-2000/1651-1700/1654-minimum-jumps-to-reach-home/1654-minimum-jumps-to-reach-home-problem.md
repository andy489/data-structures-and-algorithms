# 1654. Minimum Jumps to Reach Home

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-jumps-to-reach-home/

---

## Problem Statement

A certain bug's home is on the x-axis at position `x`. Help it get there from position `0`.

The bug jumps according to these rules:
- It can jump forward `a` positions.
- It can jump backward `b` positions (**not** from position 0 or negative positions).
- It **cannot** jump backward twice in a row.
- It cannot jump to any `forbidden` positions.

The bug may jump forward **beyond** `x`, but not to negative or forbidden positions.

Return the minimum number of jumps to reach `x`. If there is no possible sequence, return `-1`.

---

## Examples

**Example 1:**
```
Input: forbidden = [14,4,18,22,16], a = 3, b = 15, x = 9
Output: 3
```

**Example 2:**
```
Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
Output: -1
```

**Example 3:**
```
Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
Output: 2
```

---

## Constraints

- `1 <= forbidden.length <= 1000`
- `1 <= a, b, forbidden[i] <= 2000`
- `0 <= x <= 2000`

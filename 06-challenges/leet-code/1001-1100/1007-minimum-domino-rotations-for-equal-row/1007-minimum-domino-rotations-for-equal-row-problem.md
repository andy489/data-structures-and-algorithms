# 1007. Minimum Domino Rotations For Equal Row

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

---

## Problem Statement

In a row of dominoes, `tops[i]` and `bottoms[i]` represent the top and bottom halves of the `i`th domino. We may rotate the `i`th domino so that `tops[i]` and `bottoms[i]` swap values.

Return the minimum number of rotations so that all the values in `tops` are the same, or all the values in `bottoms` are the same. If it cannot be done, return `-1`.

---

## Examples

**Example 1:**
```
Input:  tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
```

**Example 2:**
```
Input:  tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output: -1
```

---

## Constraints

- `2 <= tops.length <= 2 * 10^4`
- `bottoms.length == tops.length`
- `1 <= tops[i], bottoms[i] <= 6`

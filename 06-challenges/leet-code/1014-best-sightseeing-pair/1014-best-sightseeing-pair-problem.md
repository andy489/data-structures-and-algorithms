# 1014. Best Sightseeing Pair

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/best-sightseeing-pair/

---

## Problem Statement

You are given an integer array `values` where `values[i]` represents the value of the `i`th sightseeing spot. Two sightseeing spots `i` and `j` have a distance `j - i` between them.

The score of a pair `(i < j)` of sightseeing spots is `values[i] + values[j] + i - j`.

Return the maximum score of a pair of sightseeing spots.

---

## Examples

**Example 1:**
```
Input:  values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[0] + values[2] + 0 - 2 = 8 + 5 - 2 = 11
```

---

## Constraints

- `2 <= values.length <= 5 * 10^4`
- `1 <= values[i] <= 1000`

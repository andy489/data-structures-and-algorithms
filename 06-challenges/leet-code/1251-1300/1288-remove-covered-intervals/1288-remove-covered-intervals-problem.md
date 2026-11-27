# 1288. Remove Covered Intervals

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-covered-intervals/

---

## Problem Statement

Given an array `intervals` where `intervals[i] = [li, ri]` represent the interval `[li, ri)`, remove all intervals that are covered by another interval in the array.

The interval `[a, b)` is covered by the interval `[c, d)` if and only if `c <= a` and `b <= d`.

Return the number of remaining intervals.

---

## Examples

**Example 1:**
```
Input:  intervals = [[1,4],[3,6],[2,8]]
Output: 2
```

---

## Constraints

- `1 <= intervals.length <= 1000`
- `intervals[i].length == 2`
- `0 <= li < ri <= 10^5`
- `All the given intervals are unique`

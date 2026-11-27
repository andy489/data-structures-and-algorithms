# 986. Interval List Intersections

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/interval-list-intersections/

---

## Problem Statement

You are given two lists of closed intervals, `firstList` and `secondList`, where `firstList[i] = [starti, endi]` and `secondList[j] = [startj, endj]`. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval `[a, b]` (with `a <= b`) denotes the set of real numbers `x` with `a <= x <= b`.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval.

---

## Examples

**Example 1:**
```
Input:  firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
```

---

## Constraints

- `0 <= firstList.length, secondList.length <= 1000`
- `firstList[i].length == secondList[j].length == 2`
- `0 <= starti < endi <= 10^9`

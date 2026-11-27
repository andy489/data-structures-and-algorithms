# 436. Find Right Interval

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-right-interval/

---

## Problem Statement

You are given an array of `intervals`, where `intervals[i] = [starti, endi]` and each `starti` is **unique**.

The **right interval** for an interval `i` is an interval `j` such that `startj >= endi` and `startj` is minimized. Note that `i` may equal `j`.

Return an array of **right interval** indices for each interval `i`. If no **right interval** exists for interval `i`, then put `-1` at index `i`.

---

## Examples

**Example 1:**
```
Input:  intervals = [[1,2]]
Output: [-1]
```

**Example 2:**
```
Input:  intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
```

**Example 3:**
```
Input:  intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
```

---

## Constraints

- `1 <= intervals.length <= 2 * 10^4`
- `intervals[i].length == 2`
- `-10^6 <= starti <= endi <= 10^6`
- The start point of each interval is **unique**

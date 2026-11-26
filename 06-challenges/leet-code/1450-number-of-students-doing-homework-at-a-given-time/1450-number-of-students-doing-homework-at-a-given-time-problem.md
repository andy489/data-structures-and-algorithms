# 1450. Number Of Students Doing Homework At A Given Time

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/

---

## Problem Statement

Return the number of students doing homework at time `queryTime`. Student i does homework from startTime[i] to endTime[i] inclusive.

---

## Examples

**Example 1:**
```
Input:  startTime=[1,2,3],endTime=[3,2,7],queryTime=4
Output: 1
```

**Example 2:**
```
Input:  startTime=[4],endTime=[4],queryTime=4
Output: 1
```

---

## Constraints

- `startTime.length == endTime.length == n`
- `1 <= n <= 100`
- `1 <= startTime[i] <= endTime[i] <= 1000`
- `1 <= queryTime <= 1000`

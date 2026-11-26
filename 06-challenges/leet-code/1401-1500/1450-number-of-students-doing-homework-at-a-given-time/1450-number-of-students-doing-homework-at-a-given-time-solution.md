# 1450. Number Of Students Doing Homework At A Given Time — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Count students where startTime[i] <= queryTime <= endTime[i].

**Algorithm:**
1. Count: for each i, if startTime[i] <= queryTime <= endTime[i], increment count.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |

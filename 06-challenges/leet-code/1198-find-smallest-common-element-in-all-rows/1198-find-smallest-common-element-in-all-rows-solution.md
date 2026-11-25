# 1198. Find Smallest Common Element in All Rows — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-smallest-common-element-in-all-rows/

---

## Solution: Count Array — O(m*n) time, O(max_val) space

**Idea:** Count how many rows contain each value. The first value with count == m is the answer.

**Algorithm:**
1. Count[v] = number of rows containing v.
2. Iterate through first row (smallest values first); return first element with count == m.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) |
| Space | O(max_val) |

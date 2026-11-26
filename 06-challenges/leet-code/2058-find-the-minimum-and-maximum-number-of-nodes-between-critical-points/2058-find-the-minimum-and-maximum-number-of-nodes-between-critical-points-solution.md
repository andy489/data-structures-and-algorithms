# 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Scan the list, track critical point positions, update min/max distances.

**Algorithm:**
1. Iterate with prev, curr, next.
2. If local max or min, record position.
3. Track firstCrit, prevCrit.
4. Min distance = min of consecutive diffs; max = last - first.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |

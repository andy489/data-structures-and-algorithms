# 3468. Find the Number of Copy Arrays — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-number-of-copy-arrays/

---

## Solution: Interval Intersection — O(n) time, O(1) space

**Idea:** Since copy must preserve all differences from the original, copy[i] = copy[0] + (original[i] - original[0]). So copy[0] fully determines the whole array. For each i, copy[0] must satisfy bounds[i][0] <= copy[0] + (original[i] - original[0]) <= bounds[i][1], which gives an interval for copy[0]. Intersect all intervals.

**Algorithm:**
1. For each index i, compute the valid range for copy[0]: [bounds[i][0] - (original[i] - original[0]), bounds[i][1] - (original[i] - original[0])].
2. Take the intersection of all these intervals.
3. Return max(0, intersection_max - intersection_min + 1).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |

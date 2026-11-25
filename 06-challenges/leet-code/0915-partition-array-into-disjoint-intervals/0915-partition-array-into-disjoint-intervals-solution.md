# 915. Partition Array into Disjoint Intervals — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/partition-array-into-disjoint-intervals/

---

## Solution: Two-Pass Scan — O(n) time, O(n) space

**Idea:** Precompute `minRight[i]` = min of nums[i..n-1]. Scan left to right tracking max of left part; when leftMax ≤ minRight[i+1], partition at i+1.

**Algorithm:**
1. Compute suffix min array.
2. Track running max of left part; first index where leftMax ≤ suffixMin[i+1] is the answer.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

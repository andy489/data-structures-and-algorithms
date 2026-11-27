# 1494. Parallel Courses Ii — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/parallel-courses-ii/

---

## Solution: Bitmask DP — O(3^n) time, O(2^n) space

**Idea:** dp[mask] = min semesters to complete courses in mask. For each state, find all available courses, enumerate subsets of size <= k.

**Algorithm:**
1. pre[i] = bitmask of prerequisites for course i.
2. dp[0] = 0. For each mask, compute available = all courses not in mask whose prerequisites are subset of mask.
3. Enumerate all subsets of available with popcount <= k. dp[mask | sub] = min(dp[mask] + 1).

**Complexity:**

| | |
|---|---|
| Time | O(3^n) |
| Space | O(2^n) |

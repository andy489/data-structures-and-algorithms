# 1235. Maximum Profit in Job Scheduling — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-profit-in-job-scheduling/

---

## Solution: DP + Binary Search — O(n log n) time, O(n) space

**Idea:** Sort jobs by end time. dp[i] = max profit considering first i jobs. For each job, binary search for the latest non-overlapping job.

**Algorithm:**
1. Sort jobs by endTime.
2. dp[i] = max(dp[i-1], dp[latest_non_overlap] + profit[i]).
3. Binary search for latest job ending ≤ startTime[i].

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |

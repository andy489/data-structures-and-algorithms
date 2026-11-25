# 1043. Partition Array for Maximum Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/partition-array-for-maximum-sum/

---

## Solution: DP — O(n*k) time, O(n) space

**Idea:** `dp[i]` = max sum for the first i elements. For each i, try all last partition lengths j from 1 to k, tracking max element in that last partition.

**Algorithm:**
1. `dp[i] = max over j in 1..min(i,k) of (dp[i-j] + max(arr[i-j..i-1]) * j)`.
2. Build dp array left to right.

**Complexity:**

| | |
|---|---|
| Time | O(n*k) |
| Space | O(n) |

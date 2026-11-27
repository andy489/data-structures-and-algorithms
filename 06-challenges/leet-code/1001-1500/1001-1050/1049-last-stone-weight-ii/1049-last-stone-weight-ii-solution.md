# 1049. Last Stone Weight II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/last-stone-weight-ii/

---

## Solution: 0/1 Knapsack DP — O(n * S) time, O(S) space

**Idea:** Split stones into two groups minimizing |sum1 - sum2|. This is 0/1 knapsack: find max achievable sum ≤ total/2.

**Algorithm:**
1. Compute total sum S.
2. DP: `dp[j]` = can we achieve sum j? Initialize `dp[0]=true`.
3. For each stone, update dp backwards.
4. Find largest j ≤ S/2 with `dp[j]=true`. Answer = S - 2*j.

**Complexity:**

| | |
|---|---|
| Time | O(n * S) |
| Space | O(S) |

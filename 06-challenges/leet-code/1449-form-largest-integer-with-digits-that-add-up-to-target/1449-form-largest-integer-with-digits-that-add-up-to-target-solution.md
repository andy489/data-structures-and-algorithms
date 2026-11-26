# 1449. Form Largest Integer With Digits That Add Up To Target — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/

---

## Solution: DP (Unbounded Knapsack + Digit Count) — O(9*target) time, O(target) space

**Idea:** dp[i] = max number of digits achievable with cost exactly i. Use -inf for impossible. Then greedily pick largest digit.

**Algorithm:**
1. dp[0]=0, dp[i]=-inf for i>0.
2. For each cost[d] 1-9: dp[i] = max(dp[i], dp[i-cost[d]] + 1) if dp[i-cost[d]] != -inf.
3. Build result: for each position, try digits 9 down to 1; pick the first that leaves remaining cost achievable.

**Complexity:**

| | |
|---|---|
| Time | O(9*target) |
| Space | O(target) |

# 3500. Minimum Cost to Divide Array Into Subarrays — Solution

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/minimum-cost-to-divide-array-into-subarrays/

---

## Solution: DP with Suffix Cost Reformulation — O(n^2) time, O(n) space

**Idea:** Use the identity: for a complete partition into P subarrays with starts `l_1=0 < l_2 < ... < l_P`, `sum_q(q * segCost_q) = sum_q suffCost[l_q]`. This converts the index-dependent cost into a suffix-cost term, enabling a clean DP.

Define `dp[r]` = min cost of partitioning `nums[0..r-1]`. Transition: last subarray is `[l..r-1]`. Cost contribution per subarray `[l..r-1]` = `prefNums[r] * segCost + k * suffCost[l]`. So:

`dp[r] = -prefNums[r] * suffCost[r] + min_l { dp[l] + (prefNums[r] + k) * suffCost[l] }`

Maintain a running minimum of `dp[l] + (prefNums[r] + k) * suffCost[l]` over all `l < r`.

**Algorithm:**
1. Compute prefix sums `prefNums[0..n]` and suffix cost sums `suffCost[0..n]`.
2. Initialize `dp[0] = 0`, `dp[1..n] = INF`.
3. For each `r` from 1 to n, find `minVal = min_l(dp[l] + (prefNums[r]+k)*suffCost[l])`.
4. Set `dp[r] = minVal - prefNums[r] * suffCost[r]`.
5. Return `dp[n]`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n) |

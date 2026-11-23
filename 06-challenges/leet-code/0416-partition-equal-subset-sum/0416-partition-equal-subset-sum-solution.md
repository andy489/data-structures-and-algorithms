# 416. Partition Equal Subset Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/partition-equal-subset-sum/

---

## Solution: 0/1 Knapsack DP (1D Bitset) — O(n · target) time, O(target) space

**Idea:** The problem reduces to: can we find a subset with sum = `totalSum / 2`? If the total is odd, it's impossible. Use a boolean DP array where `dp[s]` means "can we form sum `s`". Iterate in reverse to avoid using the same element twice.

**Algorithm:**
1. Compute `total = sum(nums)`. If `total` is odd, return false.
2. Set `target = total / 2`. Initialize `dp[0] = true`, rest false.
3. For each `num`: traverse `dp` from `target` down to `num`; set `dp[j] |= dp[j - num]`.
4. Return `dp[target]`.

**Complexity:**

| | |
|---|---|
| Time | O(n · target) — n items, target up to 10000 |
| Space | O(target) — single DP array |

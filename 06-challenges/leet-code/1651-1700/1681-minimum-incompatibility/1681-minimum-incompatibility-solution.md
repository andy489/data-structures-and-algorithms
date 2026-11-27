# 1681. Minimum Incompatibility — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-incompatibility/

---

## Solution: Bitmask DP — O(2^n * n) time, O(2^n) space

**Idea:** Since `n <= 16`, enumerate all subsets. For each subset of size `n/k` with all distinct elements, compute its incompatibility (max - min). Then use DP: `dp[mask]` = minimum incompatibility to partition the subset represented by `mask`.

**Algorithm:**
1. Precompute `cost[mask]` for each mask of size `n/k` with distinct elements: `max(mask) - min(mask)`.
2. `dp[mask]` = `min over all submasks s of mask (of size n/k) of dp[mask ^ s] + cost[s]`.
3. Base: `dp[0] = 0`. Return `dp[(1<<n)-1]`, or -1 if unreachable.

**Complexity:**

| | |
|---|---|
| Time | O(3^n) — iterating over all submasks of all masks |
| Space | O(2^n) |

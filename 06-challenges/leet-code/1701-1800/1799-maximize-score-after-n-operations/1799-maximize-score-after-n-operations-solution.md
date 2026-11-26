# 1799. Maximize Score After N Operations — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-score-after-n-operations/

---

## Solution: Bitmask DP — O(4^n * n) time, O(2^(2n)) space

**Idea:** With at most 14 elements (n=7), represent which elements have been used as a bitmask. The number of set bits divided by 2 tells us which operation number we are on. Use DP over bitmasks: `dp[mask]` = maximum score achievable using exactly the elements indicated by `mask`.

**Algorithm:**
1. Precompute GCD for all pairs `(i, j)`.
2. For each mask from 0 to `(1 << 2n) - 1`:
   - Count set bits `cnt`. If `cnt` is odd, skip (can't pair evenly).
   - Operation number `op = cnt / 2 + 1`.
   - Try all pairs of set bits `(i, j)` with `i < j`.
   - `dp[mask] = max(dp[mask], dp[mask without i and j] + op * gcd(nums[i], nums[j]))`.
3. Return `dp[(1 << 2n) - 1]`.

**Complexity:**

| | |
|---|---|
| Time | O(4^n * n) — O(4^n) masks, O(n^2) pairs per mask in worst case |
| Space | O(2^(2n)) — DP table |

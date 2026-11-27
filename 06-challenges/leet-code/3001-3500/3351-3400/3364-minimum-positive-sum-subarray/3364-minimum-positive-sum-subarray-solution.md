# 3364. Minimum Positive Sum Subarray — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-positive-sum-subarray/

---

## Solution: Prefix Sum + Brute Force — O(n * (r - l)) time, O(n) space

**Idea:** Given the small constraints (n ≤ 100, lengths between l and r), a simple prefix sum approach works. For each subarray of length k ∈ [l, r] and each start index, compute the sum and track the minimum positive value.

**Algorithm:**
1. Build prefix sums `pre[0..n]` where `pre[i] = nums[0] + ... + nums[i-1]`.
2. For each length `k` from `l` to `r`:
   - For each start index `i` from `0` to `n-k`:
     - Compute `s = pre[i+k] - pre[i]`.
     - If `s > 0`, update the answer with `min(ans, s)`.
3. Return `ans` if updated, else `-1`.

**Complexity:**

| | |
|---|---|
| Time | O(n * (r - l + 1)) — bounded by O(n^2) given constraints |
| Space | O(n) — prefix sum array |

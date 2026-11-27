# 3381. Maximum Subarray Sum With Length Divisible by K — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/

---

## Solution: Prefix Sum with Modulo Grouping — O(n) time, O(k) space

**Idea:** A subarray `nums[i..j]` has sum `prefix[j+1] - prefix[i]` and length `j+1-i`. For the length to be divisible by `k`, we need `(j+1) ≡ i (mod k)`. So for each index `j+1` with remainder `r = (j+1) % k`, we want to subtract the **minimum** prefix sum seen at any earlier index with the same remainder `r`. We track the minimum prefix sum per remainder group.

Initialize `minPrefix[r] = 0` for `r = 0` (the "empty prefix" at index 0 has remainder 0 and sum 0 — this handles subarrays starting at index 0).

**Algorithm:**
1. Compute prefix sums on the fly. Initialize `minByRem[0..k-1] = Long.MAX_VALUE`, but `minByRem[0] = 0`.
2. For each index `i` from 1 to n, compute `prefix[i] = prefix[i-1] + nums[i-1]`.
3. Let `r = i % k`. The best subarray ending at index `i-1` with length divisible by k has sum `prefix[i] - minByRem[r]`.
4. Update `minByRem[r] = min(minByRem[r], prefix[i])`.
5. Return the maximum such difference found.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(k) — min prefix sum per remainder |

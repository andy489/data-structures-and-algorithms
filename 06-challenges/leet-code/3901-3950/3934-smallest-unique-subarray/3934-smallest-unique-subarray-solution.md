# 3934. Smallest Unique Subarray — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-unique-subarray/

---

## Solution: Binary Search + Rolling Hash — O(n log n) time, O(n) space

**Idea:** Binary search on answer length `k`. For a fixed `k`, use Rabin-Karp polynomial rolling hash mod 2⁶¹−1 to hash each window of size `k` in O(1) per step, count frequencies, and check if any appears exactly once. The existence of a unique subarray is monotone in length (the whole array is always unique), so binary search is valid.

**Algorithm:**
1. Binary search `k` in `[1, n]`.
2. Precompute `pw = BASE^k mod MOD`.
3. Compute initial hash for `nums[0..k-1]`, then slide: `h = h * BASE + nums[i] - pw * nums[i-k]`.
4. Count hash frequencies; if any == 1, length `k` is feasible → `hi = mid`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — O(log n) binary search × O(n) hash pass |
| Space | O(n) — frequency map |

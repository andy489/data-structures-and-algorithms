# 3934. Smallest Unique Subarray — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-unique-subarray/

---

## Solution 1: Binary Search + Rolling Hash — O(n log n) time, O(n) space

**Idea:** Binary search on answer length `k`. For a fixed `k`, use Rabin-Karp polynomial rolling hash mod 2⁶¹−1 to hash each window of size `k` in O(1) per step, count frequencies, and check if any appears exactly once. The existence of a unique subarray is monotone in length (the whole array is always unique), so binary search is valid.

**Algorithm:**
1. Binary search `k` in `[1, n]`.
2. Precompute `pw = BASE^k mod MOD`.
3. Slide a window: `h = h * BASE + nums[i+1] - pw * nums[i-k+1]` (mod).
4. Count hash frequencies; if any == 1, length `k` is feasible.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — O(log n) binary search × O(n) hash pass |
| Space | O(n) — frequency map |

---

## Solution 2: Linear Scan + HashMap — O(n²) time, O(n) space

**Idea:** Scan `k` from 1 upward. For each length, build a frequency map of all subarray string keys using a sliding window. Return the first `k` where any entry has count 1.

**Algorithm:**
1. For `k = 1` to `n`: slide a window of size `k`, maintain a string key per window, count frequencies.
2. Return `k` as soon as any count == 1.

**Complexity:**

| | |
|---|---|
| Time | O(n²) worst case — O(n) per length level, up to O(n) levels |
| Space | O(n) — frequency map |

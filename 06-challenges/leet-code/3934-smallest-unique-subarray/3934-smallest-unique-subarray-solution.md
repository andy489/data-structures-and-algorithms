# 3934. Smallest Unique Subarray — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-unique-subarray/

---

## Solution 1: Binary Search + Sliding Window — O(n log n) time, O(n) space

**Idea:** The answer is monotone: if a unique subarray of length `k` exists, then a unique subarray of length `k+1` also exists (every unique subarray is a prefix of a longer unique subarray would still be unique). Binary search on `k`, and for each candidate length check with a sliding window.

For a window of size `k`, maintain a frequency map keyed by the subarray content (encoded as a tuple/list). We count how many distinct subarrays appear exactly once; if that count is positive, length `k` is feasible.

**Algorithm:**
1. Binary search `k` in `[1, n]`.
2. For fixed `k`, slide a window of size `k` over `nums`, maintaining a HashMap from subarray → count.
3. If any subarray has count == 1, return `true` (length `k` works).
4. Return the smallest `k` for which the check passes.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — O(log n) binary search iterations × O(n) sliding window per iteration |
| Space | O(n) — HashMap stores at most n subarrays |

---

## Solution 2: Linear Scan — O(n²) time, O(n) space

**Idea:** Scan from length `k = 1` upward. For each length, build the frequency map in one pass and check for a unique subarray. Return the first `k` that has at least one unique subarray. This is simpler to implement but slower when all elements are identical (worst case O(n²)).

**Algorithm:**
1. For `k = 1` to `n`:
   - Build a frequency map of all subarrays of length `k`.
   - If any entry has count 1, return `k`.
2. Return `n` (whole array is always unique).

**Complexity:**

| | |
|---|---|
| Time | O(n²) worst case — O(n) per length level, up to O(n) levels |
| Space | O(n) — HashMap |

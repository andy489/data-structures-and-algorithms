# 3934. Smallest Unique Subarray — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-unique-subarray/

---

## Solution 1: Binary Search + Rolling Hash — O(n log n) time, O(n) space

**Idea:** The existence of a unique subarray is monotone in length: if no unique subarray of length k exists, then no unique subarray of length k-1 exists either (a shorter subarray that appeared once would be a subarray of some length-k window that also appears once — but this direction of monotonicity is what allows binary search going upward from the answer). Binary search on k; for each candidate length use polynomial rolling hash mod 2⁶¹−1 to check all windows in O(n).

**Algorithm:**
1. Binary search `k` in `[1, n]`.
2. Precompute prefix hashes and powers of BASE.
3. For each window of size `k`, compute its hash in O(1) and count frequencies.
4. If any hash appears exactly once, length `k` is feasible → `hi = mid`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — O(log n) binary search × O(n) hash pass |
| Space | O(n) — prefix hash array and frequency map |

---

## Solution 2: Linear Scan + Sliding Window (prev/next + deques) — O(n²) worst case, O(n) space

**Idea:** A window `[l, r]` is unique iff every element's previous occurrence is before `l` AND every element's next occurrence is after `r`. Precompute `prev[i]` and `next[i]`, then for each length `k` use two monotonic deques to check the condition in O(n). Scan k from 1 upward.

**Algorithm:**
1. Build `prev[i]` = last index before `i` with same value (or −1).
2. Build `next[i]` = first index after `i` with same value (or n).
3. For k = 1..n: slide two monotonic deques tracking max-prev and min-next over windows of size k; return k if any window satisfies `max(prev) < l` and `min(next) > r`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) worst case — O(n) per length level, up to O(n) levels |
| Space | O(n) — prev/next arrays and deques |

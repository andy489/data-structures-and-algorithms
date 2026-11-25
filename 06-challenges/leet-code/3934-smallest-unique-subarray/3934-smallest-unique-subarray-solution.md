# 3934. Smallest Unique Subarray — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-unique-subarray/

---

## Solution 1: Binary Search + Rolling Hash — O(n log n) time, O(n) space

**Idea:** Binary search on the answer length `k`. For a fixed `k`, use polynomial rolling hash (mod 2⁶¹−1) to hash each window of size `k` in O(1) per step, then count frequencies. If any hash appears exactly once, length `k` is feasible.

**Algorithm:**
1. Precompute prefix hashes and powers of BASE.
2. Binary search `k` in `[1, n]`.
3. For each candidate `k`, slide a window computing `hash[l..r]` in O(1) and count in a HashMap.
4. If any count == 1, return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — O(log n) binary search × O(n) hash pass |
| Space | O(n) — HashMap of hashes |

---

## Solution 2: Binary Search + Sliding Window max/min — O(n log n) time, O(n) space

**Idea:** A window `[l, r]` is unique iff every element's previous occurrence is before `l` AND every element's next occurrence is after `r`. Precompute `prev[i]` and `next[i]` for each index, then for a fixed `k` check with a monotonic deque sliding window:
- `max(prev[l..r]) < l` — no duplicate enters from the left
- `min(next[l..r]) > r` — no duplicate enters from the right

**Algorithm:**
1. Build `prev[i]` = last index before `i` with same value (or −1).
2. Build `next[i]` = first index after `i` with same value (or n).
3. Binary search `k`; for each `k` slide two monotonic deques tracking max-prev and min-next.
4. If both conditions hold for any window, `k` is feasible.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — O(log n) binary search × O(n) deque pass |
| Space | O(n) — prev/next arrays and deques |

# 1521. Find a Value of a Mysterious Function Closest to Target — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-a-value-of-a-mysterious-function-closest-to-target/

---

## Solution: Bitwise AND Set Compression — O(n log(max_val)) time, O(log(max_val)) space

**Idea:** Key insight: for a fixed right endpoint `r`, the set of distinct values of `arr[l..r] & arr[l+1..r] & ... & arr[r]` for all `l <= r` has at most `log2(max_val)` distinct values. This is because AND is monotonically non-increasing as we extend left, and each extension can only clear bits — so there are at most 20 distinct values (since `max_val <= 10^6 < 2^20`).

We maintain a set `cur` of `(value, leftmost_index)` pairs representing all distinct AND values for subarrays ending at `r`. When we move to `r+1`, update each entry by ANDing with `arr[r+1]`, then merge duplicates. Add `(arr[r+1], r+1)`.

For each value in `cur`, update the minimum `|value - target|`.

**Algorithm:**
1. `cur = {}` (set of AND values ending at current r).
2. For each `r` in 0..n-1:
   - `next = {(v & arr[r], l) for (v, l) in cur}`, plus `(arr[r], r)`.
   - Merge entries with same AND value (keep leftmost `l`).
   - For each `(v, _)` in `cur`: `ans = min(ans, |v - target|)`.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(n * log(max_val)) — at most log(max_val) distinct AND values per position |
| Space | O(log(max_val)) — size of `cur` set |

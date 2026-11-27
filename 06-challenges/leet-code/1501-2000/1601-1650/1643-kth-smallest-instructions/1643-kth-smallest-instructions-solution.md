# 1643. Kth Smallest Instructions — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/kth-smallest-instructions/

---

## Solution: Combinatorics (Greedy Position-by-Position) — O((r+c)^2) time, O(1) space

**Idea:** Build the instruction string character by character. At each position, decide whether to place `'H'` or `'V'`. Since `'H' < 'V'` lexicographically, greedily try `'H'` first. If we place `'H'` here, there are `C(remaining-1, hLeft-1)` strings with `'H'` at this position. If `k <= C(...)`, place `'H'` and recurse; otherwise subtract that count from `k` and place `'V'`.

**Algorithm:**
1. Need `h = column` H's and `v = row` V's.
2. For each of the `h + v` positions:
   - Compute how many valid completions start with `'H'`: `C(h + v - 1, h - 1)`.
   - If `k <= count`, place `'H'`, decrement `h`.
   - Else `k -= count`, place `'V'`, decrement `v`.

**Complexity:**

| | |
|---|---|
| Time | O((r+c)^2) — building each character with a binomial coefficient lookup |
| Space | O(1) |

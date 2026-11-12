# 40. Combination Sum II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/combination-sum-ii/

---

## Solution: Backtracking with duplicate skipping — O(2^n) time, O(n) space

**Idea:** Same backtracking framework as problem 39, with two key differences: each element may be used only once (advance `start` to `i+1` in the recursive call), and duplicates must be skipped at the same recursion level (if `candidates[i] == candidates[i-1]` and `i > start`, skip to avoid identical combinations).

**Algorithm:**
1. Sort `candidates` ascending.
2. Call `backtrack(start=0, remaining=target, path=[])`.
3. At each call:
   - If `remaining == 0`: add a copy of `path` to results.
   - For `i` from `start` to end:
     - If `candidates[i] > remaining`: break (sorted, all further are larger).
     - If `i > start && candidates[i] == candidates[i-1]`: skip (duplicate at same level).
     - Otherwise push `candidates[i]`, recurse with `i+1` (no reuse) and `remaining - candidates[i]`, then pop.

**Why `i > start` and not `i > 0`:** We only skip a duplicate if it's not the first element chosen at this level. The first occurrence at a level is always explored; subsequent equal values at the same level are skipped to prevent identical combinations.

**Complexity:**

| | |
|---|---|
| Time | O(2^n) — each element is either included or not; sorting adds O(n log n) |
| Space | O(n) — recursion depth at most n (each element used once), excluding output |

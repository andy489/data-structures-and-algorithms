# 39. Combination Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/combination-sum/

---

## Solution: Backtracking with index-forward pruning — O(n^(T/M)) time, O(T/M) space

**Idea:** Sort the candidates, then use backtracking starting from index `start`. At each level try every candidate from `start` onward (allowing reuse by not advancing `start` on the recursive call). If the remaining target drops to 0 we have a valid combination; if it goes negative we prune. Sorting lets us break early when `candidates[i] > remaining`.

**Algorithm:**
1. Sort `candidates` ascending.
2. Call `backtrack(start=0, remaining=target, path=[])`.
3. At each call:
   - If `remaining == 0`: add a copy of `path` to results.
   - For `i` from `start` to end: if `candidates[i] > remaining` break (sorted → all further are larger too). Otherwise push `candidates[i]`, recurse with same `i` (reuse allowed) and `remaining - candidates[i]`, then pop.

**Complexity:**

| | |
|---|---|
| Time | O(n^(T/M)) — branching factor n, depth at most T/M where M is the smallest candidate |
| Space | O(T/M) — recursion depth, excluding output |

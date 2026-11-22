# 216. Combination Sum III — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/combination-sum-iii/

---

## Solution: Backtracking — O(C(9,k)) time, O(k) space

**Idea:** Use backtracking over digits 1–9 (each at most once). At each step either include the current digit or skip it. Prune when the current sum exceeds `n` or when too few digits remain to reach `k`.

**Algorithm:**
1. `backtrack(start, remaining, path)`: if `path.size() == k` and `remaining == 0`, record `path`.
2. Iterate `i` from `start` to `9`; if `i > remaining` break (pruning).
3. Add `i` to `path`, recurse with `(i+1, remaining-i, path)`, then remove `i`.

**Complexity:**

| | |
|---|---|
| Time | O(C(9,k) · k) — bounded combinations |
| Space | O(k) — recursion depth equals k |

# 1534. Count Good Triplets — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-good-triplets/

---

## Solution: Brute Force Triple Loop — O(n^3) time, O(1) space

**Idea:** Given the small constraint (n <= 100), a simple O(n^3) triple nested loop is efficient enough. We short-circuit early when the first condition fails.

**Algorithm:**
1. Iterate all triples (i, j, k) with i < j < k.
2. Skip inner iterations if `|arr[i] - arr[j]| > a`.
3. Count triplets where all three conditions hold.

**Complexity:**

| | |
|---|---|
| Time | O(n^3) — triple nested loop, feasible for n <= 100 |
| Space | O(1) — only a counter variable |

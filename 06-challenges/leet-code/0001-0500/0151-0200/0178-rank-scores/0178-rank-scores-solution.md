# 178. Rank Scores — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rank-scores/

---

## Solution 1: DENSE_RANK window function — O(n log n) time, O(n) space

**Idea:** `DENSE_RANK() OVER (ORDER BY score DESC)` directly computes the dense rank for each row. Ties share a rank and the next rank is the consecutive integer — exactly what the problem requires.

**Algorithm:**
1. Apply `DENSE_RANK() OVER (ORDER BY score DESC)` as column `rank` over the `Scores` table.
2. Return `score` and `rank`, ordered by `score DESC`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — window function requires a sort pass |
| Space | O(n) — intermediate ranked result set holds all rows |

---

## Solution 2: Correlated subquery — O(n²) time, O(1) space

**Idea:** A score's dense rank equals the count of *distinct* scores that are strictly greater than it, plus one. This avoids window functions and works on older MySQL versions.

**Algorithm:**
1. For each row, count `DISTINCT s2.score FROM Scores s2 WHERE s2.score > s1.score`.
2. Add 1 to that count — this gives the dense rank.
3. Return `s1.score` and the computed rank, ordered by `score DESC`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — correlated subquery executes once per outer row |
| Space | O(1) — no intermediate storage beyond scalar aggregates |

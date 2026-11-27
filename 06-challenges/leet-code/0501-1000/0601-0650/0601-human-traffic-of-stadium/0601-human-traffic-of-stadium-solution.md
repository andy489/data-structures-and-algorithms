# 601. Human Traffic of Stadium — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/human-traffic-of-stadium/

---

## Solution: Window Function — O(n) time, O(n) space

**Idea:** Use `ROW_NUMBER()` and subtract it from `id` to generate a group key for consecutive ids. Then filter groups of size >= 3 where all rows have people >= 100.

**Algorithm:**
1. Filter rows with `people >= 100`.
2. Assign `ROW_NUMBER()` ordered by `id`. Then `id - ROW_NUMBER()` is constant for consecutive id sequences.
3. Group by that key; keep groups with count >= 3.
4. Return matching rows ordered by `visit_date`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass with window function |
| Space | O(n) — CTE materialization |

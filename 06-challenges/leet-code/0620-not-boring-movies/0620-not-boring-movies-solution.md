# 620. Not Boring Movies — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/not-boring-movies/

---

## Solution: WHERE + ORDER BY — O(n log n) time, O(1) space

**Idea:** Filter with WHERE clause on odd id and non-boring description, then sort by rating descending.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting dominates |
| Space | O(1) — no extra storage |

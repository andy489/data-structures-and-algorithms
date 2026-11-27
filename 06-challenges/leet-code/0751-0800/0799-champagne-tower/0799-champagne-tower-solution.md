# 799. Champagne Tower — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/champagne-tower/

---

## Solution: Row-by-Row Simulation — O(query_row²) time, O(query_row) space

**Idea:** Simulate the pouring row by row. After filling a glass, the overflow (amount > 1) splits equally to the two glasses below.

**Algorithm:**
1. Start with `row = [poured]`.
2. For each row up to `query_row`: compute overflow for each glass; distribute to next row.
3. Return min(1, row[query_glass]).

**Complexity:**

| | |
|---|---|
| Time | O(query_row²) — triangular simulation |
| Space | O(query_row) — current row |

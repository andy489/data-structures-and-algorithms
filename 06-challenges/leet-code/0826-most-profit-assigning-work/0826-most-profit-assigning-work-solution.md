# 826. Most Profit Assigning Work — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/most-profit-assigning-work/

---

## Solution: Sort + Two Pointers — O(n log n + m log m) time, O(n) space

**Idea:** Sort jobs by difficulty, sort workers by ability. Use a pointer to sweep through jobs, tracking max profit seen so far.

**Algorithm:**
1. Sort jobs by difficulty, workers by ability.
2. For each worker, advance job pointer to include all doable jobs; track max profit.
3. Add max profit to total.

**Complexity:**

| | |
|---|---|
| Time | O(n log n + m log m) — sorting dominates |
| Space | O(n) — for sorted jobs |

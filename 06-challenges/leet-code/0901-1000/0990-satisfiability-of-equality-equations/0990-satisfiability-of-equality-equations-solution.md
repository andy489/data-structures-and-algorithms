# 990. Satisfiability of Equality Equations — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/satisfiability-of-equality-equations/

---

## Solution: Union-Find — O(n) time, O(1) space

**Idea:** Union all equal pairs; then check that no unequal pair shares a component.

**Complexity:**

| | |
|---|---|
| Time | O(n·α(26)) ≈ O(n) |
| Space | O(1) — fixed 26-node UF |

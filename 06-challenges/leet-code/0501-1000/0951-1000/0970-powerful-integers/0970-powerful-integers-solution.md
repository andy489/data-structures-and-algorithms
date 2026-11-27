# 970. Powerful Integers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/powerful-integers/

---

## Solution: Enumerate Powers — O(log(bound)²) time, O(log(bound)²) space

**Idea:** Enumerate all x^i and y^j such that x^i + y^j <= bound.

**Complexity:**

| | |
|---|---|
| Time | O(log(bound)²) — log_x(bound) × log_y(bound) iterations |
| Space | O(log(bound)²) — result set |

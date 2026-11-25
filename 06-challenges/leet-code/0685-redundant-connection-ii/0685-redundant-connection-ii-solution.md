# 685. Redundant Connection II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/redundant-connection-ii/

---

## Solution: Union-Find with Case Analysis — O(n·α(n)) time, O(n) space

**Idea:** Three cases: (1) no double parent and there's a cycle → return last edge in cycle; (2) double parent exists, one of those edges causes a cycle → return that one; (3) double parent exists, cycle not through either → return first candidate.

**Algorithm:**
1. Find if any node has two parents (candidate edges `cand1`, `cand2`).
2. Build UF ignoring `cand2`: if cycle found, return `cand1` (or last edge if no double parent); else return `cand2`.

**Complexity:**

| | |
|---|---|
| Time | O(n·α(n)) |
| Space | O(n) |

# 911. Online Election — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/online-election/

---

## Solution: Precompute Leaders + Binary Search — O(n) build, O(log n) query

**Idea:** Precompute the leading candidate at each vote time. For query t, binary search `times` for the last time ≤ t and return the precomputed leader.

**Algorithm:**
1. Precompute `leaders[i]` = leading candidate after processing vote i.
2. For query t: binary search for rightmost times[i] ≤ t, return leaders[i].

**Complexity:**

| | |
|---|---|
| Time | O(n) build, O(log n) per query |
| Space | O(n + p) where p = number of candidates |

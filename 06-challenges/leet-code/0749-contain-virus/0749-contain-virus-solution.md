# 749. Contain Virus — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/contain-virus/

---

## Solution: Simulation with BFS — O((mn)²) time, O(mn) space

**Idea:** Simulate each day: (1) BFS to find all infected regions, tracking their frontiers and wall counts. (2) Pick the region threatening the most uninfected cells. (3) Wall it off (mark as -1, add walls). (4) Spread the remaining regions.

**Algorithm:**
1. Repeat until no infected cells threaten others:
   a. BFS from each infected cell to identify connected regions.
   b. For each region, compute: set of threatened uninfected cells, number of walls needed.
   c. Find the region with the most threatened cells.
   d. Add its wall count to total, mark its cells as -1 (quarantined).
   e. All other regions spread: set their frontiers to 1.
2. Return total walls.

**Complexity:**

| | |
|---|---|
| Time | O((mn)²) — each day processes all cells, up to mn days |
| Space | O(mn) — BFS structures |

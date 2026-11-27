# 407. Trapping Rain Water II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/trapping-rain-water-ii/

---

## Solution: Min-Heap BFS (Dijkstra-like) — O(m·n·log(m·n)) time, O(m·n) space

**Idea:** The water level at any interior cell is bounded by the minimum-height path from that cell to any boundary cell. Use a min-heap seeded with all boundary cells. Expand inward: for each cell popped, any neighbour can hold water up to `max(current water level, neighbour height)`. The difference `waterLevel - neighbourHeight` is trapped water if positive.

**Algorithm:**
1. Add all border cells to a min-heap with their heights; mark visited.
2. Pop the cell with the minimum water level.
3. For each unvisited neighbour: compute trapped water = `max(0, waterLevel - neighbourHeight)`. Push neighbour with `max(waterLevel, neighbourHeight)`.
4. Accumulate trapped water.

**Complexity:**

| | |
|---|---|
| Time | O(m·n·log(m·n)) — each cell pushed/popped once |
| Space | O(m·n) — heap and visited array |

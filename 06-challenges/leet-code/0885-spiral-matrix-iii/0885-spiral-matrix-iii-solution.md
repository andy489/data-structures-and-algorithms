# 885. Spiral Matrix III — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/spiral-matrix-iii/

---

## Solution: Simulation — O(max(rows,cols)^2) time, O(rows*cols) space

**Idea:** Walk in spiral: E,S,W,N pattern. Steps go 1,1,2,2,3,3,4,4,... Each direction pair adds 1 to step count. Collect valid cells.

**Complexity:**

| | |
|---|---|
| Time | O(max(rows,cols)^2) |
| Space | O(rows * cols) — output |

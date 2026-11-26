# 417. Pacific Atlantic Water Flow — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/pacific-atlantic-water-flow/

---

## Solution: Reverse BFS from Ocean Borders — O(m·n) time, O(m·n) space

**Idea:** Instead of simulating flow from each cell to both oceans (expensive), reverse the problem: BFS outward from ocean borders. Water can "flow up" to equal or higher cells. Any cell reachable from both Pacific and Atlantic borders is an answer.

**Algorithm:**
1. Initialize two boolean grids `pacific` and `atlantic`, both `m×n`.
2. Add all top/left border cells to Pacific queue; add all bottom/right border cells to Atlantic queue.
3. BFS from each queue: for each cell's neighbor, if not yet visited and height >= current, mark and enqueue.
4. Collect all cells where both `pacific[r][c]` and `atlantic[r][c]` are true.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — each cell visited at most twice |
| Space | O(m·n) — two visited grids + queues |

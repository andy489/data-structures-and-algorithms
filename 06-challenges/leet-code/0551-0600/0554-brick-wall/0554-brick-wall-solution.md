# 554. Brick Wall — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/brick-wall/

---

## Solution: HashMap Edge Frequency — O(n·w) time, O(w) space

**Idea:** A vertical line crosses the fewest bricks when it passes through the most edges. Count edge positions (cumulative row sums, excluding the last brick in each row). The answer is `numRows - maxEdgeCount`.

**Algorithm:**
1. HashMap `edgeCount`: prefix sum → count across all rows.
2. For each row, iterate bricks accumulating prefix sum; increment `edgeCount[sum]` (skip last brick).
3. Return `wall.size() - max(edgeCount.values())` (0 if map empty).

**Complexity:**

| | |
|---|---|
| Time | O(n·w) — n rows, w bricks per row |
| Space | O(w) — edge positions |

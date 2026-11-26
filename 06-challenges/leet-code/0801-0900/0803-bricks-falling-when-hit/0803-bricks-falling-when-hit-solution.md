# 803. Bricks Falling When Hit — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/bricks-falling-when-hit/

---

## Solution: Reverse Union-Find — O(hits * α(mn)) time, O(mn) space

**Idea:** Process hits in reverse (add bricks back). Use Union-Find with a virtual "roof" node. When adding a brick back, count newly connected stable bricks.

**Algorithm:**
1. Apply all hits to a copy of the grid (erase bricks).
2. Build Union-Find on the resulting grid; connect top-row bricks to virtual roof.
3. Process hits in reverse: add brick back, union with neighbors, count increase in roof component.
4. Result[i] = max(0, new_roof_size - old_roof_size - 1).

**Complexity:**

| | |
|---|---|
| Time | O(mn + hits · α(mn)) — near-linear |
| Space | O(mn) — Union-Find arrays |

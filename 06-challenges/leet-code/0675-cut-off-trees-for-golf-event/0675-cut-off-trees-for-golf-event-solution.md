# 675. Cut Off Trees for Golf Event — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/cut-off-trees-for-golf-event/

---

## Solution: BFS between sorted targets — O((m·n)² log(m·n)) time, O(m·n) space

**Idea:** Collect all trees, sort by height. BFS between consecutive tree positions (starting from origin). Sum all BFS distances.

**Algorithm:**
1. Collect all (height, row, col) trees, sort by height.
2. BFS from current position to next tree position.
3. Accumulate steps; if any BFS returns -1, return -1.

**Complexity:**

| | |
|---|---|
| Time | O((m·n)²) — BFS for each tree, each O(m·n) |
| Space | O(m·n) — BFS queue |

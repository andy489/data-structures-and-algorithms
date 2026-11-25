# 1036. Escape a Large Maze — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/escape-a-large-maze/

---

## Solution: BFS with Area Bound — O(B²) time, O(B²) space

**Idea:** BFS from source and target separately. If blocked can enclose at most B*(B-1)/2 cells (where B = len(blocked)), stop BFS after visiting that many cells. If both BFS reach each other or exceed the limit, return true.

**Algorithm:**
1. Convert blocked to a set.
2. BFS from source: if we visit target or visit > B*(B-1)/2 cells, source is not enclosed.
3. BFS from target similarly.
4. Return true only if neither is enclosed.

**Complexity:**

| | |
|---|---|
| Time | O(B²) |
| Space | O(B²) |

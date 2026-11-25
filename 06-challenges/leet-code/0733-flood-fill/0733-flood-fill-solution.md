# 733. Flood Fill — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/flood-fill/

---

## Solution: DFS — O(m·n) time, O(m·n) space

**Idea:** Starting from `(sr, sc)`, do a DFS flood-filling all connected pixels of the original color. Skip if the new color equals the original to avoid infinite loops.

**Algorithm:**
1. Record `origColor = image[sr][sc]`. If it equals `color`, return unchanged image.
2. DFS from `(sr, sc)`: set `image[r][c] = color`, recurse into 4 neighbors that are in-bounds and have `origColor`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — visit each cell at most once |
| Space | O(m·n) — recursion stack |

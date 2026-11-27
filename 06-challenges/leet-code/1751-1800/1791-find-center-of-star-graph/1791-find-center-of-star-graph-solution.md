# 1791. Find Center of Star Graph — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-center-of-star-graph/

---

## Solution: Check First Two Edges — O(1) time, O(1) space

**Idea:** The center node appears in every edge. It must appear in both the first and second edges. So the center is whichever node is shared between `edges[0]` and `edges[1]`.

**Algorithm:**
1. Check if `edges[0][0]` appears in `edges[1]`. If yes, return it.
2. Otherwise, return `edges[0][1]`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — only checks first two edges |
| Space | O(1) — no extra space |

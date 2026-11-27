# 2013. DetectSquares — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/detect-squares/

---

## Solution: HashMap — O(n) time, O(n) space

**Idea:** Store point counts in a map. For count(point), fix one diagonal, check the other two corners.

**Algorithm:**
1. Store counts in map.
2. For each query (px,py), iterate over all x-coords with same y, check two possible squares.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

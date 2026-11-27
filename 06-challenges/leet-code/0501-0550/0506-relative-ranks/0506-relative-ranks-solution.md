# 506. Relative Ranks — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/relative-ranks/

---

## Solution: Sort with Index Tracking — O(n log n) time, O(n) space

**Idea:** Create index array sorted by descending score. Assign medals/ranks by sorted position.

**Algorithm:**
1. Create array of [score, originalIndex] pairs.
2. Sort descending by score.
3. Assign rank string to result[originalIndex] based on sorted position.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting |
| Space | O(n) — sorted index array |

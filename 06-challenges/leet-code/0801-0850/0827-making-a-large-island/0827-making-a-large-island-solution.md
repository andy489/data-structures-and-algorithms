# 827. Making A Large Island — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/making-a-large-island/

---

## Solution: Island Labeling + DFS — O(n²) time, O(n²) space

**Idea:** Label each island with an ID and record its size. Then for each 0, check how many distinct island IDs are adjacent and sum their sizes + 1.

**Algorithm:**
1. DFS to label each island with ID ≥ 2 and record size in a map.
2. Track max island size (in case we don't flip any 0).
3. For each 0, collect distinct neighboring island IDs, sum their sizes + 1, update max.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — two passes over grid |
| Space | O(n²) — island labels |

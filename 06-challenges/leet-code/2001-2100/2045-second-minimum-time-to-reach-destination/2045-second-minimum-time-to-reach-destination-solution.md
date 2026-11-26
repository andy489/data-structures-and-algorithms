# 2045. Second Minimum Time to Reach Destination — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/second-minimum-time-to-reach-destination/

---

## Solution: BFS with Dist1 and Dist2 — O(V + E) time, O(V + E) space

**Idea:** BFS tracking two distances: shortest and second shortest. Second shortest = shortest or shortest+1 (parity).

**Algorithm:**
1. BFS: dist1[v] = shortest, dist2[v] = second shortest (allowing revisits if different parity).
2. Simulate time with signal logic.
3. Return second shortest time to reach n.

**Complexity:**

| | |
|---|---|
| Time | O(V + E) |
| Space | O(V + E) |

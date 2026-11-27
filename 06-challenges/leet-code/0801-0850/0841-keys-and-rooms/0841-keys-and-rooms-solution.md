# 841. Keys and Rooms — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/keys-and-rooms/

---

## Solution: DFS — O(n + k) time, O(n) space

**Idea:** Start from room 0, use DFS/BFS to visit all reachable rooms. If all n rooms are visited, return true.

**Algorithm:**
1. Start DFS from room 0 with a visited set.
2. For each visited room, enqueue/recurse all keys (unvisited rooms).
3. Return visited.size() == n.

**Complexity:**

| | |
|---|---|
| Time | O(n + k) — n rooms, k total keys |
| Space | O(n) — visited set and stack |

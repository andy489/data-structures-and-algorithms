# 332. Reconstruct Itinerary — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/reconstruct-itinerary/

---

## Solution: Hierholzer's Algorithm (Eulerian Path) — O(E log E) time, O(E) space

**Idea:** Build an adjacency list with sorted destinations. Use Hierholzer's algorithm to find an Eulerian path starting from "JFK": do DFS always choosing the lexicographically smallest next airport, and add to result in post-order (reverse at end).

**Algorithm:**
1. Build `graph[from] = sorted list of to` using a sorted structure (e.g., `PriorityQueue`).
2. DFS from "JFK": while there are destinations from current, pop the smallest and recurse.
3. Add current to result list after all neighbors exhausted.
4. Reverse the result list.

**Complexity:**

| | |
|---|---|
| Time | O(E log E) — sorting adjacency lists |
| Space | O(E) — graph and call stack |

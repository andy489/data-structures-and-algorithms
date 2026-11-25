# 851. Loud and Rich — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/loud-and-rich/

---

## Solution: DFS with Memoization — O(n + e) time, O(n + e) space

**Idea:** Build a graph where an edge from a to b means a is richer than b. For each person, DFS to find all richer people (including themselves), then track who among them is the quietest.

**Algorithm:**
1. Build adjacency list: for each `[a,b]` in richer, add edge b→a (richer people reachable from poorer).
2. For each person x, DFS to collect all people at least as rich as x.
3. Among those, return the one with minimum quiet value. Memoize results.

**Complexity:**

| | |
|---|---|
| Time | O(n + e) — each node/edge visited once |
| Space | O(n + e) — graph + memo |

# 3015. Count the Number of Houses at a Certain Distance I — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i/

---

## Solution: BFS/Floyd All-Pairs — O(n³) time, O(n²) space

**Idea:** Build the graph with n nodes. Edges: i↔i+1 for all i, and x↔y. Run BFS/Floyd-Warshall to get all pairwise distances. Count pairs at each distance.

**Algorithm:**
1. Build adjacency: i to i+1 for 1<=i<n, plus edge x-y.
2. BFS from each node to get distances.
3. For each pair (i,j), increment answer[dist[i][j]].
4. Return answer (1-indexed, multiply ordered pairs by 1).

**Complexity:**

| | |
|---|---|
| Time | O(n²) — BFS from each node |
| Space | O(n²) — distance matrix |

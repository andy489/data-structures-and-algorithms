# 1697. Checking Existence of Edge Length Limited Paths — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/

---

## Solution: Offline Processing + Union-Find — O((E + Q) log(E + Q)) time, O(n + Q) space

**Idea:** Sort queries by their `limit`. Sort edges by weight. Process queries in order of increasing limit, adding edges whose weight < limit to a Union-Find structure. Answer each query by checking if the two nodes are connected.

**Algorithm:**
1. Sort edges by weight ascending.
2. Sort queries by limit ascending (keep original indices).
3. For each query in order: add all edges with weight < limit to Union-Find. Check connectivity.
4. Return answer array in original query order.

**Complexity:**

| | |
|---|---|
| Time | O((E + Q) log(E + Q)) — sorting dominates |
| Space | O(n + Q) — Union-Find + answer array |

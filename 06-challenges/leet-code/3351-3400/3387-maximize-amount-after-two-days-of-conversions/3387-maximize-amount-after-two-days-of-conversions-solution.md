# 3387. Maximize Amount After Two Days of Conversions — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximize-amount-after-two-days-of-conversions/

---

## Solution: BFS/DFS Reachability with Rate Propagation — O((n+m) * C) time, O(C) space

**Idea:** Since there are no cycles, each connected component of the conversion graph is a tree (forest). Run BFS from `initialCurrency` on day 1's undirected graph to compute the maximum amount reachable at every currency. Then treat each reachable amount as a starting value, run BFS on day 2's undirected graph, and return the maximum amount that arrives back at `initialCurrency`.

For undirected BFS, when traversing edge `(u→v, rate)`: going forward multiplies by `rate`, going backward multiplies by `1/rate`.

**Algorithm:**
1. Build adjacency lists for day 1 and day 2 (bidirectional, with forward and inverse rates).
2. BFS from `initialCurrency` on day 1 with initial amount 1.0. Record the maximum amount reachable at each currency in `day1Amounts`.
3. For each currency `c` with a non-zero `day1Amounts[c]`, BFS from `c` on day 2's graph — or equivalently, do a single BFS from every day1-reachable currency simultaneously, initializing the queue with all of them.
4. Return the final amount at `initialCurrency` from day 2's BFS.

**Complexity:**

| | |
|---|---|
| Time | O((n+m) * C) — C = number of distinct currencies, n and m are pair counts |
| Space | O(C + n + m) — adjacency lists and amount maps |

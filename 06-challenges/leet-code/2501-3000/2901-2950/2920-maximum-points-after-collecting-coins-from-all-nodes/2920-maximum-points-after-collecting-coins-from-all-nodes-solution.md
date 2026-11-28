# 2920. Maximum Points After Collecting Coins From All Nodes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-points-after-collecting-coins-from-all-nodes/

---

## Solution: Tree DFS with Memoization (halving depth) — O(n log(max_coins)) time, O(n log(max_coins)) space

**Idea:** When we choose option 2 (halving), all subtree values get halved. Since `coins[i] <= 10^4`, we can halve at most ~14 times before all values become 0. So we do DFS with a parameter `halvings` = how many times ancestors have chosen option 2. For each node with effective value `coins[node] >> halvings`, we try both options.

**Algorithm:**
1. Build adjacency list.
2. DFS from root with `halvings = 0`.
3. At each node, compute effective value `v = coins[node] >> halvings`.
4. Option 1: gain `v - k`, recurse children with same `halvings`.
5. Option 2: gain `v >> 1`, recurse children with `halvings + 1`.
6. Return max of option 1 and option 2 sums.
7. Memoize by `(node, halvings)` since `halvings` can be at most 14.

**Complexity:**

| | |
|---|---|
| Time | O(n log(max_coins)) |
| Space | O(n log(max_coins)) |

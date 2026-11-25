# 979. Distribute Coins in Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/distribute-coins-in-binary-tree/

---

## Solution: DFS Post-order — O(n) time, O(h) space

**Idea:** Each edge carries `|excess|` moves where excess = coins in subtree - nodes in subtree.

**Algorithm:**
1. DFS returns excess coins (positive = surplus, negative = deficit).
2. Add `|excess|` from each child to moves count.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(h) — recursion |

# 863. All Nodes Distance K in Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

---

## Solution: BFS with Parent Pointers — O(n) time, O(n) space

**Idea:** Build a parent map so we can traverse upward. Then BFS from target in all three directions (left child, right child, parent), stopping at distance k.

**Algorithm:**
1. DFS to build parent map: parent[node] = parent node.
2. BFS from target node. At each step, expand to left, right, and parent. Skip visited.
3. After k steps, collect all nodes in the queue.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — parent map + visited set |

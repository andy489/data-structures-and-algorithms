# 1448. Count Good Nodes In Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-good-nodes-in-binary-tree/

---

## Solution: DFS — O(n) time, O(n) space

**Idea:** DFS tracking the maximum value seen so far. A node is good if its value >= max so far.

**Algorithm:**
1. DFS(node, maxSoFar): if node.val >= maxSoFar, count++.
2. Recurse on children with max(maxSoFar, node.val).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

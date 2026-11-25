# 1080. Insufficient Nodes in Root to Leaf Paths — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/

---

## Solution: Post-order DFS — O(n) time, O(h) space

**Idea:** Recursively check if a node should be deleted. After pruning children, a leaf is insufficient if its value < remaining limit.

**Algorithm:**
1. DFS passing `limit - node.val` as the new limit to children.
2. Recursively prune left and right subtrees.
3. If node is a leaf and `node.val < limit`, return null (delete it).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(h) |

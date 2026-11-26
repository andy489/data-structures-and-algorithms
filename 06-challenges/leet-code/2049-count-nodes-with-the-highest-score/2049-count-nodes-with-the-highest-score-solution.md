# 2049. Count Nodes With the Highest Score — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-nodes-with-the-highest-score/

---

## Solution: DFS Subtree Sizes — O(n) time, O(n) space

**Idea:** Compute subtree sizes via DFS. For each node deletion, score = left * right * (n - 1 - left - right), ignoring 0-size components.

**Algorithm:**
1. Compute subtree size for each node.
2. For each node: left = subtree[left child] or 0, right = subtree[right child] or 0, up = n - 1 - left - right.
3. Score = product of non-zero sizes.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

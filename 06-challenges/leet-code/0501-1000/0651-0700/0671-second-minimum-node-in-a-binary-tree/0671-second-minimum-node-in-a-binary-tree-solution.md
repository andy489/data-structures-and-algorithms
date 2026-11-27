# 671. Second Minimum Node In a Binary Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

---

## Solution: DFS — O(n) time, O(n) space

**Idea:** The root has the minimum value. DFS to find the smallest value strictly greater than root.val.

**Algorithm:**
1. DFS: if null or node.val > current second minimum candidate, prune.
2. If node.val > min, it's a candidate for second minimum.
3. For children: if child.val == min, recurse into it; otherwise it's a candidate.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — recursion stack |

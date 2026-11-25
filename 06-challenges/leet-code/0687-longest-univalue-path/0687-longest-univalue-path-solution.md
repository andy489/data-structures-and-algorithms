# 687. Longest Univalue Path — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-univalue-path/

---

## Solution: DFS Post-order — O(n) time, O(n) space

**Idea:** DFS returns the longest univalue arm extending from a node. At each node, combine left and right arms if they match the node's value, updating the global max.

**Algorithm:**
1. DFS: get left arm length, right arm length.
2. If left child matches node.val, left arm = leftArm + 1; else 0.
3. Same for right.
4. Update global max with left + right (path through node).
5. Return max(left, right) to parent.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — recursion stack |

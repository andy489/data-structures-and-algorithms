# 1022. Sum of Root To Leaf Binary Numbers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

---

## Solution: DFS — O(n) time, O(h) space

**Idea:** DFS carrying current accumulated value. At each node, cur = cur*2 + node.val. At leaf, add to total.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(h) — recursion stack |

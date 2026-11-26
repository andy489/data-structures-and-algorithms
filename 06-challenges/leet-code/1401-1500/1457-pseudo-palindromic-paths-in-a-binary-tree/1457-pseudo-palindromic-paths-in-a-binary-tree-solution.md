# 1457. Pseudo Palindromic Paths In A Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

---

## Solution: DFS with Bitmask — O(n) time, O(n) space

**Idea:** Track a bitmask of digit parities. A path is pseudo-palindromic if at most 1 bit is set at the leaf.

**Algorithm:**
1. DFS with bitmask: toggle bit for current digit.
2. At leaf: if popcount(mask) <= 1, count++.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

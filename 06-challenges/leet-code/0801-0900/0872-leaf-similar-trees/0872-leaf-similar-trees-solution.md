# 872. Leaf-Similar Trees — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/leaf-similar-trees/

---

## Solution: DFS — O(n1 + n2) time, O(n1 + n2) space

**Idea:** Collect leaf sequences via DFS for both trees and compare.

**Algorithm:**
1. DFS: if leaf, append val. Else recurse left then right.
2. Compare leaf lists of root1 and root2.

**Complexity:**

| | |
|---|---|
| Time | O(n1 + n2) |
| Space | O(n1 + n2) — leaf lists |

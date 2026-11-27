# 1261. Find Elements in a Contaminated Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

---

## Solution: DFS + HashSet — O(n) init, O(1) find time, O(n) space

**Idea:** Recover the tree with DFS (root=0, left=2x+1, right=2x+2). Store all values in a HashSet for O(1) lookup.

**Algorithm:**
1. DFS to recover values and store in a set.
2. find(target) = target in set.

**Complexity:**

| | |
|---|---|
| Time | O(n) init, O(1) find |
| Space | O(n) |

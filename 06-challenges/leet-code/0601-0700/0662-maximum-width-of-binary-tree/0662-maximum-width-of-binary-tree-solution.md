# 662. Maximum Width of Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-width-of-binary-tree/

---

## Solution: BFS with Index — O(n) time, O(n) space

**Idea:** Assign each node an index (root=0, left child=2*i, right child=2*i+1). At each level, width = last_index - first_index + 1. Normalize by subtracting the leftmost index to prevent overflow.

**Algorithm:**
1. BFS level by level, carrying node indices.
2. At each level: normalize indices by subtracting first index.
3. Track max of `last - first + 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — queue |

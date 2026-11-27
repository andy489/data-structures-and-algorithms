# 1038. Binary Search Tree to Greater Sum Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

---

## Solution: Reverse In-order Traversal — O(n) time, O(h) space

**Idea:** Traverse BST in reverse in-order (right → node → left). Maintain a running sum of all visited nodes and add it to each node.

**Algorithm:**
1. Traverse right subtree first.
2. Add running sum to current node value.
3. Traverse left subtree.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(h) |

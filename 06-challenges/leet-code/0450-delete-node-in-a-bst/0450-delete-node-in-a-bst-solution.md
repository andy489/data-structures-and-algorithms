# 450. Delete Node in a BST — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/delete-node-in-a-bst/

---

## Solution: Recursive BST Deletion — O(h) time, O(h) space

**Idea:** Navigate to the target node. When found, handle three cases:
1. No children: return null.
2. One child: return the existing child.
3. Two children: find the inorder successor (leftmost node in right subtree), replace current value with it, then delete the successor from right subtree.

**Algorithm:**
1. If `key < root.val`: recurse left.
2. If `key > root.val`: recurse right.
3. If equal: apply the three cases above.

**Complexity:**

| | |
|---|---|
| Time | O(h) — h is tree height; O(log n) balanced, O(n) worst |
| Space | O(h) — recursion stack |

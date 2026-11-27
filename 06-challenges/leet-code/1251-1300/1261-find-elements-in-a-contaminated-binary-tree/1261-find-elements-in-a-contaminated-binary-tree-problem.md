# 1261. Find Elements in a Contaminated Binary Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

---

## Problem Statement

Given a binary tree with the following rules:
- `root.val == 0`
- For any node: `treenode.val == x`, then `treenode.left.val == 2*x+1` and `treenode.right.val == 2*x+2`.

Now the binary tree is contaminated, which means all `treenode.val` have been changed to `-1`.

Implement the `FindElements` class:
- `FindElements(TreeNode* root)` Initializes the object with a contaminated binary tree and recovers it.
- `bool find(int target)` Returns `true` if the `target` value exists in the recovered binary tree.

---

## Examples

**Example 1:**
```
Input:  ["FindElements","find","find"]
Output: [null,false,true]
```

---

## Constraints

- `TreeNode.val == -1`
- `The height of the binary tree is less than or equal to 20`
- `The total number of nodes is between [1, 10^4]`
- `Total calls of find() is between [1, 10^4]`
- `0 <= target <= 10^6`

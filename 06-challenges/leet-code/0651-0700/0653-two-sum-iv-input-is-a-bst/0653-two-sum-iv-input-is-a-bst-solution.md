# 653. Two Sum IV - Input is a BST — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

---

## Solution: DFS + HashSet — O(n) time, O(n) space

**Idea:** Traverse the tree and for each node, check if `k - node.val` is already in the set.

**Algorithm:**
1. DFS traversal.
2. For each node, check if complement exists in seen set.
3. Add current value to set.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visit each node once |
| Space | O(n) — set stores up to n values |

## Solution 2: BFS + HashSet — O(n) time, O(n) space

**Idea:** Same logic using iterative BFS.

**Algorithm:**
1. Use a queue for BFS and a set for seen values.
2. For each node dequeued, check complement in set, then add value.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

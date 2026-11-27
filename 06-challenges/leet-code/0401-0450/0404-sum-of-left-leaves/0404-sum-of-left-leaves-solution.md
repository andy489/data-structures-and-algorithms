# 404. Sum of Left Leaves — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sum-of-left-leaves/

---

## Solution 1: Recursive DFS — O(n) time, O(h) space

**Idea:** Recursively traverse the tree, passing a flag indicating whether the current node is a left child. If a node is a leaf and was reached as a left child, add its value.

**Algorithm:**
1. DFS with parameter `isLeft`.
2. If node is a leaf and `isLeft` is true, return node.val.
3. Otherwise recurse left (isLeft=true) and right (isLeft=false), summing results.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node |
| Space | O(h) — recursion stack, h = tree height |

---

## Solution 2: Iterative DFS — O(n) time, O(n) space

**Idea:** Use an explicit stack storing (node, isLeft) pairs to avoid recursion overhead.

**Algorithm:**
1. Push (root, false) onto stack.
2. Pop each entry; if it's a left leaf, add to sum.
3. Push children with appropriate isLeft flags.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node |
| Space | O(n) — stack |

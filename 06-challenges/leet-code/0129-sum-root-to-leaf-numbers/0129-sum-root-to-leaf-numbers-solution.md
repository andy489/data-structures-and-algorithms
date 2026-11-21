# 129. Sum Root to Leaf Numbers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-root-to-leaf-numbers/

---

## Solution 1: Recursive DFS — O(n) time, O(h) space

**Idea:** Pass the number formed so far (`curr = curr * 10 + node.val`) down the recursion. At a leaf, add `curr` to the total sum. Recurse left and right otherwise.

**Algorithm:**
1. Define `dfs(node, curr)`: if `node` is null return 0; compute `curr = curr * 10 + node.val`.
2. If leaf, return `curr`.
3. Return `dfs(node.left, curr) + dfs(node.right, curr)`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — every node visited once |
| Space | O(h) — recursion stack, h = tree height |

---

## Solution 2: Iterative DFS — O(n) time, O(h) space

**Idea:** Simulate the recursion with an explicit stack of `(node, currentNumber)` pairs. Pop each entry, push children with the updated number, and accumulate at leaves.

**Algorithm:**
1. Push `(root, 0)` onto the stack.
2. While stack is non-empty: pop `(node, curr)`, compute `curr = curr * 10 + node.val`.
3. If leaf, add `curr` to `ans`. Otherwise push non-null children with `curr`.
4. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — every node visited once |
| Space | O(h) — stack holds at most h entries at any time |

# 111. Minimum Depth of Binary Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-depth-of-binary-tree/

---

## Solution: BFS Level-Order — O(n) time, O(w) space

**Idea:** BFS naturally finds the minimum depth because it explores level by level. The first leaf node encountered is guaranteed to be at the minimum depth — return that level immediately without exploring the rest of the tree.

**Algorithm:**
1. If `root == null`, return `0`.
2. Use a queue initialized with `root`. Set `depth = 0`.
3. While queue is non-empty: increment `depth`; process all nodes at this level; if any node is a leaf (both children null), return `depth`; otherwise enqueue non-null children.

**Complexity:**

| | |
|---|---|
| Time | O(n) — in the worst case all nodes are visited; early exit in best case |
| Space | O(w) — queue holds at most one level; O(n) worst case (complete tree last level) |

---

## Solution 2: DFS Recursive — O(n) time, O(h) space

**Idea:** Recursively compute the minimum depth. The key edge case: if a node has only one child, we must not count the missing child's subtree as depth 0 — we must go through the existing child to reach a leaf.

**Algorithm:**
1. If `root == null`, return `0`.
2. If both children are null, return `1` (leaf).
3. If only right child exists, return `minDepth(root.right) + 1`.
4. If only left child exists, return `minDepth(root.left) + 1`.
5. Return `min(minDepth(root.left), minDepth(root.right)) + 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(h) — recursion depth; O(log n) balanced, O(n) skewed |

---

## Solution 3: Iterative DFS with (node, depth) Stack — O(n) time, O(h) space

**Idea:** Push `(node, depth)` pairs onto an explicit stack. Whenever a leaf (both children null) is popped, update a running `min`. After all nodes are processed, return `min`.

**Algorithm:**
1. If `root == null`, return `0`.
2. Initialize `min = ∞`, push `(root, 1)`.
3. While stack is non-empty: pop `(node, depth)`; if leaf, update `min`; push non-null children with `depth + 1`.
4. Return `min`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(h) — stack depth bounded by tree height |

---

## Solution 4: Recursive DFS with Depth Parameter and Shared Min — O(n) time, O(h) space

**Idea:** Pass `depth` as a parameter going down. When a leaf is reached, update a shared `min`. No return value needed — the side effect accumulates the answer.

**Algorithm:**
1. If `root == null`, return `0`.
2. Initialize `min = ∞`. Call `dfs(root, 1)`.
3. `dfs(node, depth)`: if leaf, update `min`; otherwise recurse into non-null children with `depth + 1`.
4. Return `min`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — every node visited once |
| Space | O(h) — recursion depth bounded by tree height |

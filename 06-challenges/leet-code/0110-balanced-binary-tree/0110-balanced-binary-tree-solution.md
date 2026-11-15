# 110. Balanced Binary Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/balanced-binary-tree/

---

## Solution: DFS with Early Termination (Bottom-Up Height Check) — O(n) time, O(h) space

**Idea:** Do a single post-order DFS that returns the height of each subtree, or `-1` as a sentinel if an imbalance is detected anywhere below. A node is balanced if both children return non-negative heights and their difference is at most 1.

**Algorithm:**
1. Define `height(node)`:
   - If `node == null`, return `0`.
   - `lh = height(node.left)`. If `lh == -1`, return `-1`.
   - `rh = height(node.right)`. If `rh == -1`, return `-1`.
   - If `|lh - rh| > 1`, return `-1`.
   - Return `max(lh, rh) + 1`.
2. Return `height(root) != -1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once |
| Space | O(h) — recursion depth; O(log n) balanced, O(n) worst case |

---

## Solution 2: Top-Down DFS (Naive) — O(n²) time, O(h) space

**Idea:** At each node, independently compute the heights of left and right subtrees and check the balance condition, then recurse into both children. Simple and intuitive, but heights are recomputed for every ancestor — O(n) height calls per level gives O(n²) overall for a skewed tree.

**Algorithm:**
1. If `root == null`, return `true`.
2. Compute `lh = height(root.left)`, `rh = height(root.right)`.
3. Return `|lh - rh| <= 1 && isBalanced(root.left) && isBalanced(root.right)`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — height recomputed at every level for each subtree |
| Space | O(h) — recursion depth |

---

## Solution 3: Iterative Post-Order with Height Map — O(n) time, O(n) space

**Idea:** Simulate post-order traversal with an explicit stack using the "prev pointer" technique to detect when a node's right subtree has been fully processed. Maintain a `heights` map; when popping each node, look up its children's stored heights, check balance, and store the node's own height.

**Algorithm:**
1. Traverse left as deep as possible pushing onto `stack`.
2. Peek the top: if its right child is null or already processed (`== prev`), pop it, look up `heights[left]` and `heights[right]`, check `|lh - rh| <= 1`, store `heights[node]`, set `prev = node`.
3. Otherwise, descend into the right child.
4. Return `true` if no imbalance was found.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once |
| Space | O(n) — heights map + stack |

# 99. Recover Binary Search Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/recover-binary-search-tree/

---

## Solution: In-order Traversal (Iterative) — O(n) time, O(h) space

**Idea:** In a valid BST, in-order traversal yields a strictly increasing sequence. When exactly two nodes are swapped, there are either one or two "inversions" (places where `prev.val > curr.val`). The first node of the first inversion is `first`; the second node of the last inversion is `second`. Swapping their values restores the BST.

**Algorithm:**
1. Perform iterative in-order traversal with a `prev` pointer.
2. Whenever `prev.val > curr.val`, record `first = prev` (once) and always update `second = curr`.
3. After traversal, swap `first.val` and `second.val`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node exactly once |
| Space | O(h) — implicit stack depth equals tree height h; O(log n) balanced, O(n) worst |

---

## Solution 2: Morris In-order Traversal — O(n) time, O(1) space

**Idea:** Morris traversal threads temporary right-child pointers to enable in-order traversal without a stack. The same inversion detection logic applies, but no auxiliary space is used beyond a constant number of pointers.

**Algorithm:**
1. Set `curr = root`.
2. While `curr != null`:
   - If no left child: visit `curr` (run inversion check against `prev`), then move right.
   - Else find in-order predecessor `pred` (rightmost node of left subtree):
     - If `pred.right == null`: thread `pred.right = curr`, move left.
     - If `pred.right == curr`: unthread (`pred.right = null`), visit `curr`, move right.
3. Swap `first.val` and `second.val`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited at most twice |
| Space | O(1) — no stack; only a fixed set of pointers |

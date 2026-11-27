# 109. Convert Sorted List to Binary Search Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

---

## Solution: Slow-Fast Pointer (Find Mid In-Place) — O(n log n) time, O(log n) space

**Idea:** Use the slow-fast pointer technique to find the middle node of the current list segment — it becomes the root. Sever the list at the node before mid, then recurse on the left half and the right half (mid.next onward).

**Algorithm:**
1. If `head == null`, return `null`. If `head.next == null`, return `new TreeNode(head.val)`.
2. Find the node just before the middle using slow/fast pointers (`prevMid`).
3. Set `mid = prevMid.next`; sever: `prevMid.next = null`.
4. Create `root = new TreeNode(mid.val)`.
5. `root.left = sortedListToBST(head)`, `root.right = sortedListToBST(mid.next)`.
6. Return `root`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — finding mid is O(n) at each of O(log n) recursion levels |
| Space | O(log n) — recursion depth equals tree height (balanced) |

---

## Solution 2: Convert to Array + Divide and Conquer — O(n) time, O(n) space (extra array)

**Idea:** Walk the list once to collect values into an array, then apply the same divide-and-conquer as LeetCode 108 with O(1) random access.

**Algorithm:**
1. Traverse the list and store all values in an array `nums`.
2. Define `build(lo, hi)`: if `lo > hi` return `null`; `mid = lo + (hi - lo) / 2`; create root from `nums[mid]`; recurse left and right.
3. Return `build(0, nums.length - 1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — O(n) list traversal + O(n) tree construction |
| Space | O(n) — array storage + O(log n) recursion stack |

---

## Solution 3: In-Order Simulation with Global Pointer — O(n) time, O(log n) space

**Idea:** The in-order traversal of a BST visits nodes in ascending order — exactly the order of the sorted list. Count the list length to determine index bounds, then simulate the in-order traversal by advancing a shared pointer through the list as recursion unfolds: build left subtree, consume current node, build right subtree.

**Algorithm:**
1. Count list length `n`; set `cur = head`.
2. Define `build(lo, hi)`: if `lo > hi` return `null`; `mid = lo + (hi - lo) / 2`; recurse `left = build(lo, mid - 1)`; create `node` from `cur.val`, advance `cur = cur.next`; `node.left = left`; `node.right = build(mid + 1, hi)`; return `node`.
3. Return `build(0, n - 1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited exactly once |
| Space | O(log n) — recursion depth only; no extra array |

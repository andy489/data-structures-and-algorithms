# 108. Convert Sorted Array to Binary Search Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

---

## Solution: Recursive Divide and Conquer (mid = left-mid) — O(n) time, O(log n) space

**Idea:** The middle element of a sorted array is the root of the height-balanced BST. Elements to the left form the left subtree; elements to the right form the right subtree. Recurse on each half using index bounds — no array slicing needed.

Choosing `mid = (lo + hi) / 2` (left-mid) consistently produces a unique tree. Choosing `mid = (lo + hi + 1) / 2` (right-mid) is equally valid and produces the other accepted answer.

**Algorithm:**
1. Define `build(lo, hi)`:
   - If `lo > hi`, return `null`.
   - `mid = (lo + hi) / 2`; create root from `nums[mid]`.
   - `root.left = build(lo, mid - 1)`
   - `root.right = build(mid + 1, hi)`
2. Return `build(0, nums.length - 1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each element becomes a node exactly once |
| Space | O(log n) — recursion depth equals tree height (balanced) |

---

## Solution 2: Iterative (explicit stack with bounds and side) — O(n) time, O(n) space

**Idea:** Simulate the recursion with an explicit stack. Each stack entry stores `(parent, lo, hi, side)` — the parent node, the index range to build from, and which side (`left=0`, `right=1`) to attach the new node to. Process entries until the stack is empty.

**Algorithm:**
1. Create `root` from `nums[mid]`; push two entries for the left and right ranges.
2. While the stack is non-empty:
   - Pop `(parent, lo, hi, side)`.
   - If `lo > hi`, skip.
   - `m = (lo + hi) / 2`; create `node = nums[m]`; attach to `parent.left` or `parent.right`.
   - Push entries for `(node, lo, m-1, 0)` and `(node, m+1, hi, 1)`.
3. Return `root`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each element processed once |
| Space | O(n) — stack holds O(h) = O(log n) entries for a balanced tree, but two stacks used in Java |

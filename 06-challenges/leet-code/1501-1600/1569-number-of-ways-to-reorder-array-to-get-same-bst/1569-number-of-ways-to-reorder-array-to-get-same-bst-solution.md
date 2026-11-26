# 1569. Number of Ways to Reorder Array to Get Same BST — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/

---

## Solution: Divide and Conquer with Combinatorics — O(n^2) time, O(n^2) space

**Idea:** The root must always be `nums[0]`. The left subtree contains elements less than root and the right subtree contains elements greater. Any interleaving of the left and right subsequences that preserves relative order within each subtree is valid. This interleaving count is `C(left+right, left)`. Multiply by the counts from each subtree recursively.

**Algorithm:**
1. Precompute Pascal's triangle for binomial coefficients mod 10^9+7.
2. Split `nums[1:]` into left (< root) and right (> root).
3. `count(arr) = C(|left|+|right|, |left|) * count(left) * count(right)` mod MOD.
4. Return `count(nums) - 1` (subtract the original ordering).

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — Pascal's triangle and recursion with O(n) work per level |
| Space | O(n^2) — Pascal's triangle table |

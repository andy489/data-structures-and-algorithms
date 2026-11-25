# 655. Print Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/print-binary-tree/

---

## Solution: DFS Fill — O(n) time, O(n) space

**Idea:** Calculate tree height first, then DFS-fill the matrix using the column formula `c ± 2^(height-row-1)`.

**Algorithm:**
1. Compute height of tree.
2. Create m × n matrix of empty strings where m = height+1, n = 2^(height+1)-1.
3. DFS: place node.val at (row, col), recurse left at (row+1, col - 2^(height-row-1)), right at (row+1, col + 2^(height-row-1)).

**Complexity:**

| | |
|---|---|
| Time | O(n) — visit each node once |
| Space | O(n) — matrix size proportional to nodes |

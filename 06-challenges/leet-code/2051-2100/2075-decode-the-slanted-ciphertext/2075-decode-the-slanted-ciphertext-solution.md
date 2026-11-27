# 2075. Decode the Slanted Ciphertext — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/decode-the-slanted-ciphertext/

---

## Solution: Matrix Diagonal Traversal — O(n) time, O(n) space

**Idea:** Reconstruct the matrix, read column by column.

**Algorithm:**
1. Compute columns = len / rows.
2. Fill matrix row by row.
3. Read diagonally: col c's diagonal = (0,c), (1,c+1), ...
4. Actually: original text at index i = matrix[i % rows][i // rows].

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

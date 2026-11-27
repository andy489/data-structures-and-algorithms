# 1738. Find Kth Largest XOR Coordinate Value — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/

---

## Solution: 2D XOR Prefix + Partial Sort — O(m · n · log(m · n)) time, O(m · n) space

**Idea:** Compute the 2D XOR prefix table in-place using `prefix[i][j] = matrix[i][j] XOR prefix[i-1][j] XOR prefix[i][j-1] XOR prefix[i-1][j-1]`. Collect all values and find the kth largest.

**Algorithm:**
1. For each row `i`, compute prefix XOR across columns: `matrix[i][j] ^= matrix[i][j-1]`.
2. For each column `j`, compute prefix XOR across rows: `matrix[i][j] ^= matrix[i-1][j]`.
3. Flatten the matrix and find the kth largest by sorting descending.

**Complexity:**

| | |
|---|---|
| Time | O(m · n + m · n · log(m · n)) — prefix + sort |
| Space | O(m · n) — values array |

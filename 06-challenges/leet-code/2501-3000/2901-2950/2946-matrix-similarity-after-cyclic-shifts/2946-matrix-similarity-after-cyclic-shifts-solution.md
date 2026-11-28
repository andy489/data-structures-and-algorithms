# 2946. Matrix Similarity After Cyclic Shifts — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/

---

## Solution: Check Net Shift — O(m * n) time, O(1) extra space

**Idea:** After `k` cyclic shifts, even rows shift left by `k % n` positions and odd rows shift right by `k % n` positions. The matrix is identical to the original if and only if for each row: the net effective shift is 0 modulo the row's length. Since all rows have the same length `n`, this is equivalent to `k % n == 0` for every row that is not all-equal. If `k % n == 0`, the matrix is unchanged. Otherwise, check each row: a row with net shift != 0 must consist of all identical elements to look unchanged.

**Algorithm:**
1. Compute `shift = k % n`.
2. If `shift == 0`, return true.
3. For each row, check if all elements are equal (a shifted row looks the same only if all elements match).
4. If all rows pass, return true; otherwise return false.

**Complexity:**

| | |
|---|---|
| Time | O(m * n) |
| Space | O(1) extra |

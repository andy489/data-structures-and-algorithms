# 1812. Determine Color of a Chessboard Square — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/determine-color-of-a-chessboard-square/

---

## Solution: Parity Check — O(1) time, O(1) space

**Idea:** A chessboard square is white if the sum of its column index and row index is odd. Map the letter to a 0-based column index (`'a'` → 0, ..., `'h'` → 7) and the digit to a 0-based row index (`'1'` → 0, ..., `'8'` → 7). If their sum is odd the square is white.

**Algorithm:**
1. Compute `col = coordinates[0] - 'a'`.
2. Compute `row = coordinates[1] - '1'`.
3. Return `(col + row) % 2 == 1`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — single arithmetic operation |
| Space | O(1) — no extra storage |

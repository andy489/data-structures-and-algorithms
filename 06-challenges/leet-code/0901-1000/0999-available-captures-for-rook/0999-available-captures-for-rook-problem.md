# 999. Available Captures for Rook

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/available-captures-for-rook/

---

## Problem Statement

You are given an `8 x 8` matrix representing a chessboard. There is exactly one white rook `'R'`, some white bishops `'B'`, some black pawns `'p'`, and empty squares `'.'`.

A rook can move any number of squares horizontally or vertically (up, down, left, right) until it reaches another piece or the edge of the board. The rook captures a black pawn if it lands on the pawn's square.

Return the number of pawns the rook can capture in one move.

---

## Examples

**Example 1:**
```
Input:  board = [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]]
Output: 3
```

---

## Constraints

- `board.length == board[i].length == 8`
- `board[i][j]` is either `'R'`, `'B'`, `'p'`, or `'.'`.
- There is exactly one `'R'` on the board.

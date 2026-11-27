# 3001. Minimum Moves To Capture The Queen

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-moves-to-capture-the-queen/

---

## Problem Statement

There is a 1-indexed 8x8 chessboard containing 3 pieces.

You are given the integer positions of a white rook at `(rook_row, rook_col)`, a white bishop at `(bishop_row, bishop_col)`, and a black queen at `(queen_row, queen_col)`.

Return the minimum number of moves to capture the black queen, assuming the white pieces move optimally.

---

## Examples

**Example 1:**
```
Input:  a=1,b=1,c=8,d=8,e=2,f=3
Output: 2
```
Explanation: We can capture the queen in 2 moves: Rook to (2,1) then to (2,3), or other paths.

**Example 2:**
```
Input:  a=5,b=3,c=3,d=4,e=5,f=4
Output: 1
```
Explanation: The rook at (5,3) can directly move to (5,4) capturing the queen.

---

## Constraints

- `1 <= rook_row, rook_col, bishop_row, bishop_col, queen_row, queen_col <= 8`
- `No two pieces are at the same position.`

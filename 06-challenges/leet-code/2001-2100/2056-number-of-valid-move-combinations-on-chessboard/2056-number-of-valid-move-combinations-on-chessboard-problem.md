# 2056. Number of Valid Move Combinations on Chessboard

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-valid-move-combinations-on-chessboard/

---

## Problem Statement

You are given `n` chess pieces on an 8x8 chessboard. Each piece is one of 'rook', 'queen', or 'bishop'. Find the number of valid move combination sequences where each piece moves to a stop position simultaneously without collision.

---

## Examples

**Example 1:**
```
Input:  pieces = ["rook"], positions = [[1,1]]
Output: 15
```

**Example 2:**
```
Input:  pieces = ["queen"], positions = [[1,1]]
Output: 22
```

**Example 3:**
```
Input:  pieces = ["bishop"], positions = [[4,3]]
Output: 12
```

---

## Constraints

- `n == pieces.length == positions.length`
- `1 <= n <= 4`
- `positions[i].length == 2`
- `1 <= positions[i][j] <= 8`

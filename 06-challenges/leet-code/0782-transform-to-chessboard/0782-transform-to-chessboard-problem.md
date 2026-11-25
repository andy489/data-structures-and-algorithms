# 782. Transform to Chessboard

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/transform-to-chessboard/

---

## Problem Statement

You are given an `n x n` binary grid `board`. In each move, you can swap any two rows with each other, or any two columns with each other.

Return the minimum number of moves to transform the board into a **chessboard**. A chessboard is a board where no `0`'s and no `1`'s are 4-directionally adjacent. If the task is impossible, return `-1`.

---

## Examples

**Example 1:**
```
Input:  board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
Output: 2
```

**Example 2:**
```
Input:  board = [[0,1],[1,0]]
Output: 0
```

**Example 3:**
```
Input:  board = [[1,0],[1,0]]
Output: 1
```

---

## Constraints

- `n == board.length`
- `n == board[i].length`
- `2 <= n <= 30`
- `board[i][j]` is either `0` or `1`.

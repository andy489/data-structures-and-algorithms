# 130. Surrounded Regions

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/surrounded-regions/

---

## Problem Statement

You are given an `m x n` matrix `board` containing `'X'` and `'O'` characters. Capture all regions that are 4-directionally surrounded by `'X'`.

A region is **captured** by flipping all `'O'`s into `'X'`s in that surrounded region.

A region is considered **not surrounded** if any `'O'` cell in it lies on the board boundary (or is 4-directionally connected to a boundary `'O'`). All such `'O'` cells must remain.

---

## Examples

**Example 1:**

```
Input:  board = [["X","X","X","X"],
                 ["X","O","O","X"],
                 ["X","X","O","X"],
                 ["X","O","X","X"]]
Output:         [["X","X","X","X"],
                 ["X","X","X","X"],
                 ["X","X","X","X"],
                 ["X","O","X","X"]]
```

Explanation: The connected `'O'` region in rows 1–2 is fully surrounded, so it gets captured. The `'O'` at `board[3][1]` connects to the bottom edge, so it stays.

**Example 2:**

```
Input:  board = [["X"]]
Output:         [["X"]]
```

---

## Constraints

- `m == board.length`
- `n == board[i].length`
- `1 <= m, n <= 200`
- `board[i][j]` is `'X'` or `'O'`

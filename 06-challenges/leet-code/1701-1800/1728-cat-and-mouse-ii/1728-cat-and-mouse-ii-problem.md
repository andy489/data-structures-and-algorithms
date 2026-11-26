# 1728. Cat and Mouse II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/cat-and-mouse-ii/

---

## Problem Statement

A game is played on an `m x n` grid. There is a cat at position `catPos` and a mouse at position `mousePos` on the grid. They alternate turns, with the **mouse going first**. At each turn, a player either stays (jump 0) or moves up to their jump distance (cat jumps `catJump`, mouse jumps `mouseJump`) in one of the four cardinal directions, but cannot pass through or land on a **wall** cell (marked `'#'`). The mouse wins if it reaches any food cell (marked `'F'`). The cat wins if it catches the mouse (occupies the same cell) or after a total of `128` moves.

Given the grid, return `true` if the mouse can always win regardless of the cat's moves, `false` otherwise.

- `'C'` — cat's initial position
- `'M'` — mouse's initial position
- `'F'` — food
- `'#'` — wall
- `'.'` — floor

---

## Examples

**Example 1:**
```
Input: grid = ["####F","#C...","M...."]
Output: true
```

**Example 2:**
```
Input: grid = ["M.C...F"]
Output: true
```

**Example 3:**
```
Input: grid = ["M.C...F"], catJump = 1, mouseJump = 4
Output: true
```

---

## Constraints

- `rows == grid.length`
- `cols == grid[i].length`
- `1 <= rows, cols <= 8`
- `grid[i][j]` is `'C'`, `'M'`, `'F'`, `'#'`, or `'.'`.
- There is exactly one `'C'`, one `'M'`, and one `'F'`.
- `catJump` and `mouseJump` are given in the actual function signature.

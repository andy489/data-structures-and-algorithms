# 1958. Check if Move is Legal

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-if-move-is-legal/

## Description

You are given a 0-indexed 8 x 8 grid board, where board[r][c] represents the cell (r, c) on a game board. On the board, free cells are represented by '.', white cells are represented by 'W', and black cells are represented by 'B'.

Each move in this game consists of choosing a free cell and changing it to the color you are playing as (either white or black). However, a move is only legal if, after changing it, the cell becomes the endpoint of a good line (horizontal, vertical, or diagonal).

A good line is a line of three or more cells (including the endpoints) where the endpoints of the line are one color, and the remaining cells in the middle are the opposite color (no cells in the line are free).

Given two integers rMove and cMove and a character color representing the color you are playing as (white or black), return true if changing cell (rMove, cMove) to color color is a legal move, or false if it is not legal.

## Examples

**Example 1:**
```
Input: board = [[".",".",".",".",".",".",".","."],
                ...], rMove = 4, cMove = 3, color = "B"
Output: true
```

**Example 2:**
```
Output: false
```

## Constraints

- board.length == board[r].length == 8
- 0 <= rMove, cMove < 8
- board[rMove][cMove] == '.'
- color is either 'B' or 'W'.

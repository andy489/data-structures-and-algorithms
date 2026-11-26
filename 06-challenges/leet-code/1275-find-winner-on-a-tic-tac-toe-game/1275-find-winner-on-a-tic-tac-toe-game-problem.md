# 1275. Find Winner on a Tic Tac Toe Game

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

---

## Problem Statement

Tic-tac-toe is played by two players A and B on a 3 x 3 grid. Player A always places 'X' and player B always places 'O'.

'X' always goes first.

Given a 2D integer array `moves` where `moves[i] = [row, col]` indicates that the player who moves first at step `i` places a mark on (row, col).

Return the winner of the game if it exists (A or B). In case the game is a draw, return "Draw". If there are still movements to play return "Pending".

---

## Examples

**Example 1:**
```
Input:  moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
```

---

## Constraints

- `1 <= moves.length <= 9`
- `moves[i].length == 2`
- `0 <= moves[i][j] <= 2`
- `There are no repeated elements on moves`
- `moves follow the rules of tic tac toe`

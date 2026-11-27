# 488. Zuma Game

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/zuma-game/

---

## Problem Statement

You are playing a variation of the game Zuma.

In this variation of Zuma, there is a single row of colored balls on a board, where each ball can be colored red `'R'`, yellow `'Y'`, blue `'B'`, green `'G'`, or white `'W'`. You also have several colored balls in your hand.

Your goal is to **clear all of the balls from the board**. On each turn:

- Pick **any** ball from your hand and insert it in between two balls in the row or on either end of the row.
- If there is a group of **three or more consecutive balls** of the same color, remove the group of balls from the board.
- If this removal causes more groups of three or more of the same color to form, then continue removing each group. This is a **chain reaction**.
- If there are no more balls on the board, then you have won the game.
- Repeat this process until you either clear all the balls from the board or cannot insert any more balls.

Given a string `board`, representing the row of balls on the board, and a string `hand`, representing the balls in your hand, return *the **minimum** number of balls you have to insert to clear all the balls from the board*. If you cannot clear all the balls from the board using the balls in your hand, return `-1`.

---

## Examples

**Example 1:**
```
Input:  board = "WRRBBW", hand = "RB"
Output: -1
```

**Example 2:**
```
Input:  board = "WWRRBBWW", hand = "WRBRW"
Output: 2
```

**Example 3:**
```
Input:  board = "G", hand = "GGGGG"
Output: 2
```

---

## Constraints

- `1 <= board.length <= 16`
- `1 <= hand.length <= 5`
- `board` and `hand` consist of the characters `'R'`, `'Y'`, `'B'`, `'G'`, and `'W'`

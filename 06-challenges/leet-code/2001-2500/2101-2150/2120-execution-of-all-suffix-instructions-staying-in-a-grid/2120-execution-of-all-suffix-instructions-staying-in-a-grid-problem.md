# 2120. Execution of All Suffix Instructions Staying in a Grid

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/

## Problem

There is an `n x n` grid, with the top-left cell at `(0, 0)` and the bottom-right cell at `(n - 1, n - 1)`. You are given the integer `n` and an integer array `startPos` where `startPos = [startrow, startcol]` indicates that a robot is initially at cell `(startrow, startcol)`.

You are also given a 0-indexed string `s` of length `m` where `s[i]` is the ith instruction for the robot: `'L'` (move left), `'R'` (move right), `'U'` (move up), and `'D'` (move down).

The robot can begin executing from any ith instruction in `s`. It executes the instructions one by one towards the end of `s` but it stops if either of these conditions is met:

- The next instruction will move the robot off the grid.
- There are no more instructions left to execute.

Return an array `answer` of length `m` where `answer[i]` is the number of instructions the robot can execute if the robot begins executing from the ith instruction in `s`.

## Examples

**Example 1:**
```
Input: n = 3, startPos = [0,1], s = "RRDDLU"
Output: [1,5,4,3,1,0]
Explanation:
- 0th: "RRDDLU". Only "R" before off-grid.
- 1st: "RDDLU". All 5 execute.
- 2nd: "DDLU". All 4 execute.
- 3rd: "DLU". All 3 execute.
- 4th: "LU". Only "L" before off-grid.
- 5th: "U". Off-grid immediately.
```

**Example 2:**
```
Input: n = 2, startPos = [1,1], s = "LURD"
Output: [4,1,0,0]
```

**Example 3:**
```
Input: n = 1, startPos = [0,0], s = "LRUD"
Output: [0,0,0,0]
```

## Constraints

- `m == s.length`
- `1 <= n, m <= 500`
- `startPos.length == 2`
- `0 <= startrow, startcol < n`
- `s` consists of `'L'`, `'R'`, `'U'`, and `'D'`.

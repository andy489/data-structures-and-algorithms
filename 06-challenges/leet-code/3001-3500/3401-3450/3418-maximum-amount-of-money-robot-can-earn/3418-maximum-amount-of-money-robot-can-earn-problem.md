# 3418. Maximum Amount of Money Robot Can Earn

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/

## Problem

You are given an m x n grid. A robot starts at the top-left corner of the grid (0, 0) and wants to reach the bottom-right corner (m - 1, n - 1). The robot can move either right or down at any point in time.

The grid contains a value coins[i][j] in each cell:

- If coins[i][j] >= 0, the robot gains that many coins.
- If coins[i][j] < 0, the robot encounters a robber, and the robber steals the absolute value of coins[i][j] coins.

The robot has a special ability to neutralize robbers in at most 2 cells on its path, preventing them from stealing coins in those cells.

Note: The robot's total coins can be negative.

Return the maximum profit the robot can gain on the route.

## Examples

**Example 1:**

Input: coins = [[0,1,-1],[1,-2,3],[2,-3,4]]
Output: 8

Explanation: An optimal path: (0,0) -> (0,1) -> (1,1) neutralized -> (1,2) -> (2,2). Total = 0+1+0+3+4 = 8.

**Example 2:**

Input: coins = [[10,10,10],[10,10,10]]
Output: 40

## Constraints

- m == coins.length
- n == coins[i].length
- 1 <= m, n <= 500
- -1000 <= coins[i][j] <= 1000

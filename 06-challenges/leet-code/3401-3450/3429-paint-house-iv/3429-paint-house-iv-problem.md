# 3429. Paint House IV

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/paint-house-iv/

## Problem

You are given an even integer n representing the number of houses arranged in a straight line, and a 2D array cost of size n x 3, where cost[i][j] represents the cost of painting house i with color j + 1.

The houses will look beautiful if they satisfy the following conditions:

- No two adjacent houses are painted the same color.
- Houses equidistant from the ends of the row are not painted the same color. For example, if n = 6, houses at positions (0, 5), (1, 4), and (2, 3) are considered equidistant.

Return the minimum cost to paint the houses such that they look beautiful.

## Examples

**Example 1:**

Input: n = 4, cost = [[3,5,7],[6,2,9],[4,8,1],[7,3,5]]
Output: 9

**Example 2:**

Input: n = 6, cost = [[2,4,6],[5,3,8],[7,1,9],[4,6,2],[3,5,7],[8,2,4]]
Output: 18

## Constraints

- 2 <= n <= 10^5
- n is even
- cost.length == n
- cost[i].length == 3
- 0 <= cost[i][j] <= 10^5

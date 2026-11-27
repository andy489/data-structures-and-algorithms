# 3426. Manhattan Distances of All Arrangements of Pieces

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/manhattan-distances-of-all-arrangements-of-pieces/

## Problem

You are given three integers m, n, and k.

There is a rectangular grid of size m x n containing k identical pieces. Return the sum of Manhattan distances between every pair of pieces over all valid arrangements of pieces.

A valid arrangement is a placement of all k pieces on the grid with at most one piece per cell.

Since the answer may be very large, return it modulo 10^9 + 7.

The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.

## Examples

**Example 1:**

Input: m = 2, n = 2, k = 2
Output: 8

**Example 2:**

Input: m = 1, n = 4, k = 3
Output: 20

## Constraints

- 1 <= m, n <= 10^5
- 2 <= m * n <= 10^5
- 2 <= k <= m * n

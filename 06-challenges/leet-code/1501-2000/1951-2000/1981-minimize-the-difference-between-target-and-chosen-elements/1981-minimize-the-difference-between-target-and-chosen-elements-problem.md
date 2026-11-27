# 1981. Minimize the Difference Between Target and Chosen Elements

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/

## Problem

You are given an `m x n` integer matrix `mat` and an integer `target`.

Choose one integer from each row in the matrix such that the absolute difference between `target` and the sum of the chosen elements is minimized.

Return the minimum absolute difference.

## Examples

**Example 1:**
```
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
Output: 0
Explanation: Choose 1, 5, 7 (sum = 13).
```

**Example 2:**
```
Input: mat = [[1],[2],[3]], target = 100
Output: 94
```

**Example 3:**
```
Input: mat = [[1,2,9,8,7]], target = 6
Output: 1
```

## Constraints

- `m == mat.length`
- `n == mat[i].length`
- `1 <= m, n <= 70`
- `1 <= mat[i][j] <= 70`
- `1 <= target <= 800`

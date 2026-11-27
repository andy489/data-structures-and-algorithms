# 3882. Minimum XOR Path in a Grid

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-xor-path-in-a-grid/

## Problem

You are given a 2D integer array `grid` of size `m * n`.

You start at the **top-left** cell `(0, 0)` and want to reach the **bottom-right** cell `(m - 1, n - 1)`.

At each step, you **may** move either **right or down**.

The **cost** of a path is defined as the **bitwise XOR** of all the values in the cells along that path, **including** the start and end cells.

Return the **minimum** possible XOR value among all valid paths from `(0, 0)` to `(m - 1, n - 1)`.

## Examples

**Example 1:**
```
Input: grid = [[1,2],[3,4]]
Output: 6
Explanation:
- Path (0,0)->(0,1)->(1,1): XOR = 1^2^4 = 7
- Path (0,0)->(1,0)->(1,1): XOR = 1^3^4 = 6
Minimum is 6.
```

**Example 2:**
```
Input: grid = [[6,7],[5,8]]
Output: 9
```

**Example 3:**
```
Input: grid = [[2,7,5]]
Output: 0
Explanation: 2^7^5 = 0
```

## Constraints

- `1 <= m == grid.length <= 1000`
- `1 <= n == grid[i].length <= 1000`
- `m * n <= 1000`
- `0 <= grid[i][j] <= 1023`

# 62. Unique Paths

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/unique-paths/

---

## Problem Statement

There is a robot on an `m x n` grid. The robot is initially located at the **top-left corner** (i.e., `grid[0][0]`). The robot tries to move to the **bottom-right corner** (i.e., `grid[m - 1][n - 1]`). The robot can only move either **down** or **right** at any point in time.

Given the two integers `m` and `n`, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

---

## Examples

**Example 1:**
```
Input:  m = 3, n = 7
Output: 28
```

**Example 2:**
```
Input:  m = 3, n = 2
Output: 3
Explanation: From the top-left there are 3 ways to reach the bottom-right:
  1. Right -> Down -> Down
  2. Down -> Down -> Right
  3. Down -> Right -> Down
```

---

## Constraints

- `1 <= m, n <= 100`
- The answer will be less than or equal to `2 * 10^9`.

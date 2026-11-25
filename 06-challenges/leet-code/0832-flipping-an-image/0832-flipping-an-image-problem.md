# 832. Flipping an Image

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/flipping-an-image/

---

## Problem Statement

Given an `n x n` binary matrix `image`, flip the image horizontally, then invert it, and return the resulting image.

Flipping horizontally means each row is reversed. Inverting means each 0 is replaced by 1, and each 1 by 0.

---

## Examples

**Example 1:**
```
Input:  image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
```

---

## Constraints

- `n == image.length == image[i].length`
- `1 <= n <= 20`
- `images[i][j]` is either `0` or `1`.

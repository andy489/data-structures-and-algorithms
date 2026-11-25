# 835. Image Overlap

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/image-overlap/

---

## Problem Statement

You are given two images, `img1` and `img2`, represented as binary, square matrices of size `n x n`. A translation of an image is a right and/or downward shift. Find the maximum number of overlapping 1-bits when translating `img1` over `img2`, or `img2` over `img1`.

---

## Examples

**Example 1:**
```
Input:  img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
Output: 3
```

---

## Constraints

- `n == img1.length == img1[i].length == img2.length == img2[i].length`
- `1 <= n <= 30`
- `img1[i][j]` is either `0` or `1`.
- `img2[i][j]` is either `0` or `1`.

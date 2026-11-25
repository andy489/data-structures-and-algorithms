# 661. Image Smoother

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/image-smoother/

---

## Problem Statement

An **image smoother** is a filter of the size `3 x 3` that can smooth out the values of a cell and all of its surrounding cells. The result of a cell is obtained by taking the **floor** of the average of the cells in the filter.

Given an `m x n` integer matrix `img` representing the grayscale of an image, return the image after applying the smoother on each cell.

---

## Examples

**Example 1:**
```
Input:  img = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[0,0,0],[0,0,0],[0,0,0]]
```

**Example 2:**
```
Input:  img = [[100,200,100],[200,50,200],[100,200,100]]
Output: [[137,141,137],[141,138,141],[137,141,137]]
```

---

## Constraints

- `m == img.length`
- `n == img[i].length`
- `1 <= m, n <= 200`
- `0 <= img[i][j] <= 255`

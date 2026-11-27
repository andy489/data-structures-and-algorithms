# 427. Construct Quad Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/construct-quad-tree/

---

## Problem Statement

Given a `n * n` matrix `grid` of `0`s and `1`s only, we want to represent it with a Quad-Tree.

A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:

- `val`: True if the node represents a grid of all 1s, or False if the node represents a grid of all 0s. For non-leaf nodes, this value can be arbitrary.
- `isLeaf`: True if the node is a leaf node on the tree, or False if the node has four children nodes.

You can construct the Quad-Tree from a matrix using the following steps:

1. If the current grid has the same value (i.e., all `1`s or all `0`s) set `isLeaf` True and set `val` to the value of the grid and set the four children to Null and stop.
2. If the current grid has different values, set `isLeaf` to False and set `val` to any value and divide the current grid into four sub-grids.
3. Recurse for each of the children with the proper sub-grid.

---

## Examples

**Example 1:**
```
Input:  grid = [[0,1],[1,0]]
Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]
```

**Example 2:**
```
Input:  grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
Output: [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
```

---

## Constraints

- `n == grid.length == grid[i].length`
- `n == 2^x` where `0 <= x <= 6`
- `1 <= n <= 64`
- `grid[i][j]` is `0` or `1`

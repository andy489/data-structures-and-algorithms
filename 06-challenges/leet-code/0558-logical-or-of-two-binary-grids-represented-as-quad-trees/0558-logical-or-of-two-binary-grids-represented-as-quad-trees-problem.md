# 558. Logical OR of Two Binary Grids Represented as Quad-Trees

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/

---

## Problem Statement

A Binary Matrix is a matrix in which all the elements are either **0** or **1**.

Given `quadTree1` and `quadTree2`. `quadTree1` represents a `n * n` binary matrix and `quadTree2` represents another `n * n` binary matrix.

Return *a Quad-Tree* representing the `n * n` binary matrix which is the result of **logical bitwise OR** of the two binary matrixes represented by `quadTree1` and `quadTree2`.

Notice that you can assign the value of a node to **True** or **False** when `isLeaf` is **False**, and both are **accepted** in the answer.

A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:
- `val`: True if the node represents a grid of 1's or False if the node represents a grid of 0's.
- `isLeaf`: True if the node is leaf node on the tree or False if the node has the four children.

---

## Examples

**Example 1:**
```
Input:  quadTree1 = [[0,1],[1,1],[1,1],[1,0],[1,0]], quadTree2 = [[0,1],[1,1],[0,1],[1,1],[1,0]]
Output: [[0,0],[1,1],[1,1],[1,1],[1,0]]
```

**Example 2:**
```
Input:  quadTree1 = [[1,0]], quadTree2 = [[1,0]]
Output: [[1,0]]
```

---

## Constraints

- `quadTree1` and `quadTree2` are both valid Quad-Trees each representing a `n * n` grid
- `n == 2^x` where `0 <= x <= 9`

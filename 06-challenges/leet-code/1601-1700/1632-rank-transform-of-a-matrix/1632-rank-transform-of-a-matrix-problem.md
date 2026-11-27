# 1632. Rank Transform of a Matrix

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/rank-transform-of-a-matrix/

---

## Problem Statement

Given an `m x n` matrix, return a new matrix `answer` where `answer[i][j]` is the **rank** of `matrix[i][j]`.

The **rank** is an **integer** that represents how large an element is compared to other elements. It is calculated using the following rules:

- The rank is an integer starting from `1`.
- If two elements `p` and `q` are in the **same row or column**, then:
  - If `p < q` then `rank(p) < rank(q)`.
  - If `p == q` then `rank(p) == rank(q)`.
  - If `p > q` then `rank(p) > rank(q)`.
- The rank should be as **small** as possible.

The test cases are generated so that `answer` is unique under the given rules.

---

## Examples

**Example 1:**
```
Input: matrix = [[1,2],[3,4]]
Output: [[1,2],[2,3]]
```

**Example 2:**
```
Input: matrix = [[7,7],[7,7]]
Output: [[1,1],[1,1]]
```

**Example 3:**
```
Input: matrix = [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]
Output: [[4,2,3],[1,3,4],[5,1,6],[1,3,4]]
```

---

## Constraints
- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 500`
- `-10^9 <= matrix[i][j] <= 10^9`

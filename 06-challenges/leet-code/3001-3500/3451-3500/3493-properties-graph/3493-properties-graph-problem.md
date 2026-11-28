# 3493. Properties Graph

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/properties-graph/

---

## Problem Statement

You are given a 2D integer array `properties` having dimensions `n x m` and an integer `k`.

Define a function `intersect(a, b)` that returns the **number of distinct integers** common to both arrays `a` and `b`.

Construct an **undirected** graph where each index `i` corresponds to `properties[i]`. There is an edge between node `i` and node `j` if and only if `intersect(properties[i], properties[j]) >= k`, where `i` and `j` are in the range `[0, n - 1]` and `i != j`.

Return the number of **connected components** in the resulting graph.

---

## Examples

**Example 1:**
```
Input: properties = [[1,2],[1,1],[3,4],[4,5],[5,6],[7,7]], k = 1
Output: 3
```

**Example 2:**
```
Input: properties = [[1,2,3],[2,3,4],[4,3,5]], k = 2
Output: 1
```

**Example 3:**
```
Input: properties = [[1,1],[1,1]], k = 2
Output: 2
```

---

## Constraints

- `1 <= n == properties.length <= 100`
- `1 <= m == properties[i].length <= 100`
- `1 <= properties[i][j] <= 100`
- `1 <= k <= m`

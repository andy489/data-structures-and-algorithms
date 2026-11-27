# 1617. Count Subtrees With Max Distance Between Cities

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/

---

## Problem Statement

There are `n` cities numbered from `1` to `n`. You are given an array `edges` of size `n - 1`, where `edges[i] = [ui, vi]` represents a bidirectional edge between cities `ui` and `vi`. There exists a unique path between each pair of cities. In other words, the cities form a **tree**.

A **subtree** is a subset of cities where every city is reachable from every other city in the subset, where the path between each pair passes through only the cities from the subset. Two subsets are the same if there is a bijection between them that preserves edges.

For each `d` from `1` to `n - 1`, find the number of subtrees in which the **maximum distance** between any two cities in the subtree is equal to `d`.

Return an array of size `n - 1` where the `d`th element (1-indexed) is the number of subtrees in which the **maximum distance** between any two cities is equal to `d`.

---

## Examples

**Example 1:**
```
Input: n = 4, edges = [[1,2],[2,3],[2,4]]
Output: [3,4,0]
Explanation:
- d=1: subtrees {1,2}, {2,3}, {2,4}
- d=2: subtrees {1,2,3}, {1,2,4}, {2,3,4}, {1,2,3,4}
```

**Example 2:**
```
Input: n = 2, edges = [[1,2]]
Output: [1]
```

**Example 3:**
```
Input: n = 3, edges = [[1,2],[2,3]]
Output: [2,1]
```

---

## Constraints
- `2 <= n <= 15`
- `edges.length == n - 1`
- `edges[i].length == 2`
- `1 <= ui, vi <= n`
- All pairs `(ui, vi)` are distinct.

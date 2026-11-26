# 1409. Queries On A Permutation With Key

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/queries-on-a-permutation-with-key/

---

## Problem Statement

Given `m` and `queries`, start with a permutation [1,2,...,m]. For each query[i], find the position of query[i] (1-indexed), record it, then move query[i] to position 1.

---

## Examples

**Example 1:**
```
Input:  m=5, queries=[3,1,2,1]
Output: [2,1,2,1]
```

**Example 2:**
```
Input:  m=3, queries=[1,2,3,2,1]
Output: [1,2,2,1,1]
```

---

## Constraints

- `1 <= m <= 10^3`
- `1 <= queries.length <= m`
- `1 <= queries[i] <= m`

# 1627. Graph Connectivity With Threshold

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/graph-connectivity-with-threshold/

---

## Problem Statement

We have `n` cities labeled from `1` to `n`. Two different cities are directly connected by a bidirectional edge if and only if they share a common divisor **strictly greater than** some threshold `threshold`. More formally, cities `i` and `j` are connected if there exists an integer `z` such that all three conditions are satisfied:

- `i % z == 0`
- `j % z == 0`
- `z > threshold`

Given the two integers, `n` and `threshold`, and an array of `queries` where `queries[i] = [ai, bi]`, return an array of booleans where `answer[i]` is `true` if city `ai` is connected to city `bi` (directly or via other cities), and `false` otherwise.

---

## Examples

**Example 1:**
```
Input: n = 6, threshold = 2, queries = [[1,4],[2,5],[3,6]]
Output: [false,false,true]
```

**Example 2:**
```
Input: n = 6, threshold = 0, queries = [[4,5],[3,4],[3,2],[2,6],[1,3]]
Output: [true,true,true,true,true]
```

**Example 3:**
```
Input: n = 5, threshold = 1, queries = [[4,5],[4,5],[3,2],[2,3],[3,4]]
Output: [false,false,false,false,false]
```

---

## Constraints
- `2 <= n <= 10^4`
- `0 <= threshold <= n`
- `1 <= queries.length <= 10^5`
- `queries[i].length == 2`
- `1 <= ai, bi <= n`
- `ai != bi`

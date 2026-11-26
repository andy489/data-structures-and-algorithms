# 2065. Maximum Path Quality of a Graph

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-path-quality-of-a-graph/

---

## Problem Statement

Given an undirected weighted graph with `n` nodes and edges, starting at node 0. A path's quality is the sum of values of **unique** nodes visited. You have `maxTime` seconds. Edge weights are travel times. Return maximum path quality if you can return to 0 within `maxTime` seconds.

---

## Examples

**Example 1:**
```
Input:  values = [0,32,10,43], edges = [[0,1,10],[1,2,15],[0,3,10]], maxTime = 49
Output: 75
```
Explanation: Path 0→3→0→1→0: quality = 43+32 = 75.

**Example 2:**
```
Input:  values = [5,10,15,20], edges = [[0,1,10],[1,2,10],[0,3,10]], maxTime = 30
Output: 25
```

**Example 3:**
```
Input:  values = [1,2,3,4], edges = [[0,1,10],[1,2,11],[2,3,12],[1,3,13]], maxTime = 50
Output: 7
```

---

## Constraints

- `n == values.length`
- `1 <= n <= 1000`
- `0 <= values[i] <= 10^8`
- `0 <= edges.length <= 2000`
- `1 <= maxTime <= 10^3`

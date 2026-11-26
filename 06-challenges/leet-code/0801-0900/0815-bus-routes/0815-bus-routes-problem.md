# 815. Bus Routes

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/bus-routes/

---

## Problem Statement

You are given an array `routes` representing bus routes. `routes[i]` is a bus route that the `i`th bus repeats forever. You will start at the bus stop `source` and you want to reach bus stop `target`. You can travel between bus stops only by buses. Return the least number of buses you need to ride to reach `target`, or `-1` if impossible.

---

## Examples

**Example 1:**
```
Input:  routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
```

**Example 2:**
```
Input:  routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
Output: -1
```

---

## Constraints

- `1 <= routes.length <= 500`
- `1 <= routes[i].length <= 10^5`
- `0 <= routes[i][j] < 10^6`
- `0 <= source, target < 10^6`

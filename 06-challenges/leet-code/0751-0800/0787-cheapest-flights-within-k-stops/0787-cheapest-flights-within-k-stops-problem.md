# 787. Cheapest Flights Within K Stops

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/cheapest-flights-within-k-stops/

---

## Problem Statement

There are `n` cities connected by some number of flights. You are given an array `flights` where `flights[i] = [fromi, toi, pricei]` indicates that there is a flight from city `fromi` to city `toi` with cost `pricei`.

Given three integers `src`, `dst`, and `k`, return the **cheapest price** from `src` to `dst` with at most `k` stops. If there is no such route, return `-1`.

---

## Examples

**Example 1:**
```
Input:  n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
```

**Example 2:**
```
Input:  n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
```

---

## Constraints

- `1 <= n <= 100`
- `0 <= flights.length <= (n * (n - 1) / 2)`
- `0 <= fromi, toi < n`
- `fromi != toi`
- `1 <= pricei <= 10^4`
- There will not be any multiple flights between two cities.
- `0 <= src, dst, k < n`
- `src != dst`

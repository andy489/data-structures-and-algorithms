# 2045. Second Minimum Time to Reach Destination

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/second-minimum-time-to-reach-destination/

---

## Problem Statement

A graph has `n` vertices (1-indexed). You start at vertex 1 and need to reach vertex `n`. Travel time along any edge is 1 minute. At red/green signals: green [0, time), red [time, 2*time), etc. You can only leave during green. Return **second minimum** time to reach vertex `n`.

---

## Examples

**Example 1:**
```
Input:  n = 5, edges = [[1,2],[1,3],[1,4],[3,4],[4,5]], time = 3, change = 5
Output: 13
```

**Example 2:**
```
Input:  n = 2, edges = [[1,2]], time = 3, change = 2
Output: 11
```

---

## Constraints

- `2 <= n <= 10^4`
- `n - 1 <= edges.length <= min(2*10^4, n*(n-1)/2)`
- `1 <= change, time <= 10^3`

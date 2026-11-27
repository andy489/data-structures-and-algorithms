# 2039. The Time When the Network Becomes Idle

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/the-time-when-the-network-becomes-idle/

---

## Problem Statement

There are `n` servers numbered 0 to n-1 connected by undirected edges. Data packets are sent from each server `i` (i > 0) to server 0 and back. `patience[i]` = how often server i resends if no reply. Find the earliest time when the network is idle (no messages in transit).

---

## Examples

**Example 1:**
```
Input:  edges = [[0,1],[1,2]], patience = [0,2,1]
Output: 8
```

**Example 2:**
```
Input:  edges = [[0,1],[0,2],[1,2]], patience = [0,10,10]
Output: 3
```

---

## Constraints

- `n == patience.length`
- `2 <= n <= 10^5`
- `1 <= patience[i] <= 10^6`
- `1 <= edges.length <= min(10^5, n*(n-1)/2)`

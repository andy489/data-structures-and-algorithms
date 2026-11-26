# 1473. Paint House Iii

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/paint-house-iii/

---

## Problem Statement

Return minimum cost to paint `m` houses with `n` colors such that there are exactly `target` neighborhoods. Already painted houses cannot be repainted.

---

## Examples

**Example 1:**
```
Input:  houses=[0,0,0,0,0],cost=[[1,10],[10,1],[10,1],[1,10],[5,1]],m=5,n=2,target=3
Output: 9
```

**Example 2:**
```
Input:  houses=[0,2,1,2,0],cost=[[1,10],[10,1],[10,1],[1,10],[5,1]],m=5,n=2,target=3
Output: 11
```

---

## Constraints

- `m == houses.length`
- `n == cost[i].length`
- `1 <= m <= 100`
- `1 <= n <= 20`
- `1 <= target <= m`
- `0 <= houses[i] <= n`
- `1 <= cost[i][j] <= 10^4`

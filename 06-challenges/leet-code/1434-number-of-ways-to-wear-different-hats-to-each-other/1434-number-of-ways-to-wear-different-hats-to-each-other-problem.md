# 1434. Number Of Ways To Wear Different Hats To Each Other

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-ways-to-wear-different-hats-to-each-other/

---

## Problem Statement

There are `n` people and 40 hats (labeled 1-40). Each person has a list of preferred hats. Return the number of ways to assign each person a different hat such that everyone wears a preferred hat. Mod 10^9+7.

---

## Examples

**Example 1:**
```
Input:  hats=[[3,4],[4,5],[5]]
Output: 1
```

**Example 2:**
```
Input:  hats=[[3,5,1],[3,5]]
Output: 4
```

**Example 3:**
```
Input:  hats=[[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]
Output: 24
```

---

## Constraints

- `n == hats.length`
- `1 <= n <= 10`
- `1 <= hats[i].length <= 40`
- `1 <= hats[i][j] <= 40`
- `hats[i] contains a list of unique integers`

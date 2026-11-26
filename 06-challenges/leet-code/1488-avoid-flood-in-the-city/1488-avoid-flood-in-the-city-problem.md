# 1488. Avoid Flood In The City

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/avoid-flood-in-the-city/

---

## Problem Statement

Given rains array where rains[i]=lake if lake fills that day, =0 if you can drain one lake. Return valid drain plan or empty array if impossible.

---

## Examples

**Example 1:**
```
Input:  rains=[1,2,3,4]
Output: [-1,-1,-1,-1]
```

**Example 2:**
```
Input:  rains=[1,2,0,0,2,1]
Output: [-1,-1,2,1,-1,-1]
```

**Example 3:**
```
Input:  rains=[1,2,0,1,2]
Output: []
```

---

## Constraints

- `1 <= rains.length <= 10^5`
- `0 <= rains[i] <= 10^9`

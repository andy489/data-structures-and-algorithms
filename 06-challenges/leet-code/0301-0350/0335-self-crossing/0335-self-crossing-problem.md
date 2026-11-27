# 335. Self Crossing

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/self-crossing/

---

## Problem Statement

You are given an array of integers `distance`.

You start at the origin `(0, 0)` on a Cartesian plane and you move `distance[0]` meters to the north, then `distance[1]` meters to the west, `distance[2]` meters to the south, `distance[3]` meters to the east, and so on. In other words, after each move, your direction changes counter-clockwise.

Return `true` if your path crosses itself or `false` if it does not.

---

## Examples

**Example 1:**
```
Input:  distance = [2,1,1,2]
Output: true
```

**Example 2:**
```
Input:  distance = [1,2,3,4]
Output: false
```

**Example 3:**
```
Input:  distance = [1,1,1,2,1]
Output: true
```

---

## Constraints

- `1 <= distance.length <= 10^5`
- `1 <= distance[i] <= 10^5`

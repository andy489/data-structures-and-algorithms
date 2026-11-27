# 3015. Count the Number of Houses at a Certain Distance I

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i/

---

## Problem Statement

You are given three positive integers `n`, `x`, and `y`.

In a city, there are `n` houses numbered 1 to n, lined up on a street. There is also a street connecting house x and house y (bidirectional). The distance between two houses is the minimum of the path along the main street or through the x-y connection.

Return a 1-indexed array `answer` of size `n` where `answer[d]` is the number of pairs `(house1, house2)` such that the minimum distance between them is exactly `d`.

---

## Examples

**Example 1:**
```
Input:  n = 3, x = 1, y = 3
Output: [6,0,0]
```

**Example 2:**
```
Input:  n = 5, x = 2, y = 4
Output: [10,8,2,0,0]
```

---

## Constraints

- `2 <= n <= 100`
- `1 <= x, y <= n`

# 1742. Maximum Number of Balls in a Box

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-number-of-balls-in-a-box/

---

## Problem Statement

You are working in a ball factory where you have `n` balls numbered from `lowLimit` up to `highLimit` inclusive (i.e., `n == highLimit - lowLimit + 1`), and an infinite number of boxes numbered from `1` to `infinity`.

Your job at this factory is to put each ball in the box with a number equal to the sum of digits of the ball's number. For example, the ball number `321` will be put in the box number `3 + 2 + 1 = 6` and the ball number `10` will be put in the box number `1 + 0 = 1`.

Given two integers `lowLimit` and `highLimit`, return the number of balls in the box with the most balls.

---

## Examples

**Example 1:**
```
Input: lowLimit = 1, highLimit = 10
Output: 2
Explanation:
Box 1 has balls [1, 10]
Box 2 has ball [2]
...
Box 9 has ball [9]
```

**Example 2:**
```
Input: lowLimit = 5, highLimit = 15
Output: 2
Explanation:
Box 6 has balls [6, 15]
Box 7 has ball [7]
...
Box 5 has ball [5]
Box 1 has ball [10]
Box 2 has ball [11]
Box 3 has ball [12]
Box 4 has ball [13]
Box 5 has ball [14]
```

**Example 3:**
```
Input: lowLimit = 19, highLimit = 28
Output: 2
```

---

## Constraints

- `1 <= lowLimit <= highLimit <= 100000`

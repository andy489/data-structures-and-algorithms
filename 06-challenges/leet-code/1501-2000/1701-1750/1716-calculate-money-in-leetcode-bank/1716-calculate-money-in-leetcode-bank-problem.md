# 1716. Calculate Money in Leetcode Bank

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/calculate-money-in-leetcode-bank/

---

## Problem Statement

Hercy wants to save money for his first car. He puts money in the Leetcode bank **every day**.

He starts by putting in `$1` on Monday, the first day. Every day from Tuesday to Sunday, he will put in `$1` more than the day before. On every subsequent Monday, he will put in `$1` more than the **previous Monday**.

Given `n`, return the total amount of money he will have in the Leetcode bank at the end of the `n`th day.

---

## Examples

**Example 1:**
```
Input: n = 4
Output: 10
Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.
```

**Example 2:**
```
Input: n = 10
Output: 37
Explanation: (1+2+3+4+5+6+7) + (2+3+4) = 37.
```

**Example 3:**
```
Input: n = 20
Output: 96
```

---

## Constraints

- `1 <= n <= 1000`

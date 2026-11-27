# 1977. Number of Ways to Separate Numbers

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/number-of-ways-to-separate-numbers/

## Problem

You wrote down many positive integers in a string called `num`. However, you realized that you forgot to add commas to separate the different numbers. You remember that the list of integers was non-decreasing and that no integer had leading zeros.

Return the number of possible lists of integers that you could have written down to get the string `num`. Since the answer may be large, return it modulo `10^9 + 7`.

## Examples

**Example 1:**
```
Input: num = "327"
Output: 2
Explanation: You could have written down the numbers:
3, 27
327
```

**Example 2:**
```
Input: num = "094"
Output: 0
Explanation: No numbers can have leading zeros and all numbers must be positive.
```

**Example 3:**
```
Input: num = "0"
Output: 0
```

## Constraints

- `1 <= num.length <= 3500`
- `num` consists of digits `'0'` through `'9'`.

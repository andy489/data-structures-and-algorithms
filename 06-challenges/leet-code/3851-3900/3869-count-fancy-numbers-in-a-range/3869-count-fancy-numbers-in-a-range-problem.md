# 3869. Count Fancy Numbers in a Range

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/count-fancy-numbers-in-a-range/

## Problem

You are given two integers `l` and `r`.

An integer is called **good** if its digits form a strictly monotone sequence, meaning the digits are strictly increasing or strictly decreasing. All single-digit integers are considered good.

An integer is called **fancy** if it is good, or if the sum of its digits is good.

Return an integer representing the number of fancy integers in the range `[l, r]` (inclusive).

## Examples

**Example 1:**
```
Input: l = 8, r = 10
Output: 3
Explanation: 8 and 9 are single-digit (good), 10 has digits [1,0] strictly decreasing (good). All 3 are fancy.
```

**Example 2:**
```
Input: l = 12340, r = 12341
Output: 1
Explanation: 12340 is not good, but digit sum = 10, which is good (strictly decreasing). So 12340 is fancy. 12341 has digit sum 11 which is not good, and 12341 itself is not good.
```

**Example 3:**
```
Input: l = 123456788, r = 123456788
Output: 0
```

## Constraints

- `1 <= l <= r <= 10^15`

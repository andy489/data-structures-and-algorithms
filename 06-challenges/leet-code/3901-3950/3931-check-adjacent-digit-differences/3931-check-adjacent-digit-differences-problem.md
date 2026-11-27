# 3931. Check Adjacent Digit Differences

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/check-adjacent-digit-differences/

## Problem

You are given a string `s` consisting of digits.

Return `true` if the **absolute difference** between every pair of **adjacent** digits is at most 2, otherwise return `false`.

The absolute difference between `a` and `b` is defined as `abs(a - b)`.

## Examples

**Example 1:**

```
Input: s = "132"
Output: true
Explanation:
- abs(1 - 3) = 2 <= 2
- abs(3 - 2) = 1 <= 2
```

**Example 2:**

```
Input: s = "129"
Output: false
Explanation:
- abs(1 - 2) = 1 <= 2
- abs(2 - 9) = 7 > 2
```

## Constraints

- `2 <= s.length <= 100`
- `s` consists only of digits.

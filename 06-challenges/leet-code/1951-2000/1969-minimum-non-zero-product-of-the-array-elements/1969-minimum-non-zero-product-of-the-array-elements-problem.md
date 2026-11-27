# 1969. Minimum Non-Zero Product of the Array Elements

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/

## Description

You are given a positive integer p. Consider an array nums (1-indexed) that consists of the integers in the inclusive range [1, 2^p - 1] in their binary representations. You are allowed to do the following operation any number of times:

- Choose two elements x and y from nums.
- Choose a bit in x and swap it with its corresponding bit in y.

Find the minimum non-zero product of nums after performing the above operation any number of times. Return this product modulo 10^9 + 7.

Note: The answer should be the minimum product before the modulo operation is done.

## Examples

**Example 1:**
```
Input: p = 1
Output: 1
Explanation: nums = [1]. There is only one element, so the product equals that element.
```

**Example 2:**
```
Input: p = 2
Output: 6
Explanation: nums = [01, 10, 11]. The array product of 1 * 2 * 3 = 6 is already minimized.
```

**Example 3:**
```
Input: p = 3
Output: 1512
Explanation: The array product is 1 * 6 * 1 * 6 * 1 * 6 * 7 = 1512.
```

## Constraints

- 1 <= p <= 60

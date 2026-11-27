# 2600. K Items With the Maximum Sum

**Difficulty:** Easy

**Link:** https://leetcode.com/problems/k-items-with-the-maximum-sum/

## Problem

There is a bag that consists of items, each item has a number `1`, `0`, or `-1` written on it.

You are given four **non-negative** integers `numOnes`, `numZeros`, `numNegOnes`, and `k`.

The bag initially contains:

- `numOnes` items with `1`s written on them.
- `numZeroes` items with `0`s written on them.
- `numNegOnes` items with `-1`s written on them.

We want to pick exactly `k` items among the available items. Return the **maximum** possible sum of numbers written on the items.

## Examples

**Example 1:**
```
Input: numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2
Output: 2
Explanation: We have {1, 1, 1, 0, 0}. We take 2 items with 1 and get sum = 2.
```

**Example 2:**
```
Input: numOnes = 3, numZeros = 2, numNegOnes = 0, k = 4
Output: 3
Explanation: We take 3 items with 1 and 1 item with 0, sum = 3.
```

## Constraints

- `0 <= numOnes, numZeros, numNegOnes <= 50`
- `0 <= k <= numOnes + numZeros + numNegOnes`

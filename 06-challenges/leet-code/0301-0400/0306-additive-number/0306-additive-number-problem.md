# 306. Additive Number

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/additive-number/

---

## Problem Statement

An **additive number** is a string whose digits can form an additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number must equal the sum of the preceding two.

Given a string `num`, return `true` if it is an additive number or `false` otherwise.

**Note:** Numbers in the additive sequence must not have leading zeros, so sequence `1, 2, 03` or `1, 02, 3` is invalid.

---

## Examples

**Example 1:**
```
Input:  num = "112358"
Output: true
```

**Example 2:**
```
Input:  num = "199100199"
Output: true
```

---

## Constraints

- `1 <= num.length <= 35`
- `num` consists only of digits.

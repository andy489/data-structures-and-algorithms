# 989. Add to Array-Form of Integer

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/add-to-array-form-of-integer/

---

## Problem Statement

The array-form of an integer `num` is an array representing its digits in left to right order.

For example, for `num = 1321`, the array form is `[1,3,2,1]`.

Given `num`, the array-form of an integer, and an integer `k`, return the array-form of the integer `num + k`.

---

## Examples

**Example 1:**
```
Input:  num = [1,2,0,0], k = 34
Output: [1,2,3,4]
```

**Example 2:**
```
Input:  num = [2,7,4], k = 181
Output: [4,5,5]
```

---

## Constraints

- `1 <= num.length <= 10^4`
- `0 <= num[i] <= 9`
- `num` does not contain any leading zeros except for the zero itself.
- `1 <= k <= 10^4`

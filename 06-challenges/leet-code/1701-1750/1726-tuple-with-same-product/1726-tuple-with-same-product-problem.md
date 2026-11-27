# 1726. Tuple with Same Product

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/tuple-with-same-product/

---

## Problem Statement

Given an array `nums` of **distinct** positive integers, return *the number of tuples* `(a, b, c, d)` *such that* `a * b = c * d` *where* `a`, `b`, `c`, and `d` *are elements of* `nums`, *and* `a != b != c != d`.

---

## Examples

**Example 1:**
```
Input: nums = [2,3,4,6]
Output: 8
Explanation: There are 8 valid tuples: (2,6,3,4), (2,6,4,3), (6,2,3,4), (6,2,4,3), (3,4,2,6), (4,3,2,6), (3,4,6,2), (4,3,6,2).
```

**Example 2:**
```
Input: nums = [1,2,4,5,10]
Output: 16
```

---

## Constraints

- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 10^4`
- All elements in `nums` are **distinct**.

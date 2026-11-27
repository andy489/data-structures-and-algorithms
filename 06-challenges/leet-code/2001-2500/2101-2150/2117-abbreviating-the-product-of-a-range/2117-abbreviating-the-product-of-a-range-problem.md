# 2117. Abbreviating the Product of a Range

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/abbreviating-the-product-of-a-range/

## Problem

You are given two positive integers `left` and `right` with `left <= right`. Calculate the product of all integers in the inclusive range `[left, right]`.

Since the product may be very large, you will abbreviate it following these steps:

1. Count all trailing zeros in the product and remove them. Let us denote this count as `C`.
2. Denote the remaining number of digits in the product as `d`. If `d > 10`, then express the product as `<pre>...<suf>` where `<pre>` denotes the first 5 digits of the product, and `<suf>` denotes the last 5 digits of the product after removing all trailing zeros. If `d <= 10`, we keep it unchanged.
3. Finally, represent the product as a string `"<pre>...<suf>eC"`.

Return a string denoting the abbreviated product of all integers in the inclusive range `[left, right]`.

## Examples

**Example 1:**
```
Input: left = 1, right = 4
Output: "24e0"
Explanation: Product = 1 x 2 x 3 x 4 = 24. No trailing zeros. 2 digits <= 10, so no abbreviation.
```

**Example 2:**
```
Input: left = 2, right = 11
Output: "399168e2"
Explanation: Product = 39916800. Remove 2 trailing zeros → 399168. 6 digits <= 10, no abbreviation needed.
```

**Example 3:**
```
Input: left = 371, right = 375
Output: "7219856259e3"
Explanation: Product = 7219856259000. Remove 3 trailing zeros.
```

## Constraints

- `1 <= left <= right <= 10^4`

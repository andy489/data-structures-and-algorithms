# 3899. Angles of a Triangle

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/angles-of-a-triangle/

## Problem Statement

You are given a positive integer array `sides` of length 3.

Determine if there exists a triangle with **positive** area whose three side lengths are given by the elements of `sides`.

If such a triangle exists, return an array of three floating-point numbers representing its internal angles (in **degrees**), **sorted** in **non-decreasing** order. Otherwise, return an empty array.

Answers within `10^-5` of the actual answer will be accepted.

## Examples

### Example 1
**Input:** `sides = [3,4,5]`
**Output:** `[36.86990, 53.13010, 90.00000]`

**Explanation:** You can form a right-angled triangle with sides 3, 4, and 5. The internal angles are approximately 36.87, 53.13, and 90 degrees.

### Example 2
**Input:** `sides = [2,4,2]`
**Output:** `[]`

**Explanation:** Cannot form a triangle with positive area using side lengths 2, 4, 2.

## Constraints

- `sides.length == 3`
- `1 <= sides[i] <= 1000`

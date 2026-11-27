# 3024. Type Of Triangle

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/type-of-triangle/

---

## Problem Statement

You are given a 0-indexed integer array `nums` of size 3 which can form the sides of a triangle.

- A triangle is valid if the sum of any two sides is greater than the third side.
- Return `"equilateral"` if all three sides are equal.
- Return `"isosceles"` if exactly two sides are equal.
- Return `"scalene"` if all three sides are different.
- Return `"none"` if `nums` does not form a valid triangle.

---

## Examples

**Example 1:**
```
Input:  nums = [3,3,3]
Output: "equilateral"
```
Explanation: All sides equal.

**Example 2:**
```
Input:  nums = [3,4,5]
Output: "scalene"
```
Explanation: Valid triangle, all sides different.

---

## Constraints

- `nums.length == 3`
- `1 <= nums[i] <= 100`

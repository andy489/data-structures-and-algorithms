# 3890. Integers With Multiple Sum of Two Cubes

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/integers-with-multiple-sum-of-two-cubes/

## Problem Statement

You are given an integer `n`.

An integer `x` is considered **good** if there exist **at least** two **distinct** pairs `(a, b)` such that:

- `a` and `b` are positive integers.
- `a <= b`
- `x = a^3 + b^3`

Return an array containing all good integers **less than or equal to** `n`, sorted in ascending order.

## Examples

### Example 1
**Input:** `n = 4104`
**Output:** `[1729, 4104]`

**Explanation:**
- 1729: `1^3 + 12^3 = 1729` and `9^3 + 10^3 = 1729`.
- 4104: `2^3 + 16^3 = 4104` and `9^3 + 15^3 = 4104`.

### Example 2
**Input:** `n = 578`
**Output:** `[]`

**Explanation:** There are no good integers less than or equal to 578.

## Constraints

- `1 <= n <= 10^9`

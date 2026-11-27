# 3896. Minimum Operations to Transform Array into Alternating Prime

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-operations-to-transform-array-into-alternating-prime/

## Problem Statement

You are given an integer array `nums`.

An array is considered **alternating prime** if:

- Elements at **even** indices (0-based) are **prime** numbers.
- Elements at **odd** indices are **non-prime** numbers.

In one operation, you may **increment** any element by 1.

Return the **minimum** number of operations required to transform `nums` into an **alternating prime** array.

A **prime** number is a natural number greater than 1 with only two factors, 1 and itself.

## Examples

### Example 1
**Input:** `nums = [1,2,3,4]`
**Output:** `3`

**Explanation:**
- Index 0 must be prime: increment `1` to `2` (1 operation).
- Index 1 must be non-prime: increment `2` to `4` (2 operations).
- Index 2 is already prime.
- Index 3 is already non-prime.
Total operations = 1 + 2 = 3.

### Example 2
**Input:** `nums = [5,6,7,8]`
**Output:** `0`

### Example 3
**Input:** `nums = [4,4]`
**Output:** `1`

**Explanation:** Increment index 0 from 4 to 5 (1 operation).

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^5`

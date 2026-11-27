# 982. Triples with Bitwise AND Equal To Zero

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/

---

## Problem Statement

Given an integer array `nums`, return the number of AND triples.

An AND triple is a triple of indices `(i, j, k)` where `0 <= i < j < k < n` such that `nums[i] & nums[j] & nums[k] == 0` (using bitwise AND).

Wait — actually the problem does NOT require `i < j < k`, any indices `(i, j, k)` where they can be equal are allowed in some variants. Let's use the standard: return the number of triples of indices (i, j, k) (not necessarily distinct) such that `nums[i] & nums[j] & nums[k] == 0`.

---

## Examples

**Example 1:**
```
Input:  nums = [2,1,3]
Output: 12
```

**Example 2:**
```
Input:  nums = [0,0,0]
Output: 27
```

---

## Constraints

- `1 <= nums.length <= 1000`
- `0 <= nums[i] < 2^16`

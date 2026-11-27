# 3314. Construct the Minimum Bitwise Array I

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/

## Problem

You are given an array `nums` consisting of `n` **prime** integers.

You need to construct an array `ans` of length `n`, such that, for each index `i`, the bitwise `OR` of `ans[i]` and `ans[i] + 1` is equal to `nums[i]`, i.e. `ans[i] OR (ans[i] + 1) == nums[i]`.

Additionally, you must **minimize** each value of `ans[i]` in the resulting array.

If it is not possible to find such a value for `ans[i]` that satisfies the condition, then set `ans[i] = -1`.

## Examples

**Example 1:**
```
Input: nums = [2,3,5,7]
Output: [-1,1,4,3]
Explanation:
- ans[0] = -1 (no value satisfies for 2).
- ans[1] = 1 because 1 OR 2 = 3.
- ans[2] = 4 because 4 OR 5 = 5.
- ans[3] = 3 because 3 OR 4 = 7.
```

**Example 2:**
```
Input: nums = [11,13,31]
Output: [9,12,15]
```

## Constraints

- `1 <= nums.length <= 100`
- `2 <= nums[i] <= 1000`
- `nums[i]` is a prime number.

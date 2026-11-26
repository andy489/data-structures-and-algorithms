# 1558. Minimum Numbers of Function Calls to Make Target Array

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/

---

## Problem Statement

You are given an integer array `nums`. You have an integer array `arr` of the same length with all values set to `0` initially. You also have the following `modify` function:

```
function modify(arr, op, idx) {
    if (op == 0) arr[idx] += 1
    if (op == 1) for (i = 0; i < arr.length; i++) arr[i] *= 2
}
```

Your task is to use the modify function to convert `arr` to `nums` using the minimum number of calls.

Return the minimum number of function calls to make `nums` from `arr`.

The answer is guaranteed to fit in a 32-bit signed integer.

---

## Examples

**Example 1:**
```
Input: nums = [1,5]
Output: 5
Explanation: Increment 1st index 1 time and 5th index 1 time, multiply 2 times. Answer is 1 + 1 + 2 + 2 = carry 1 bit set + carry 1 bit set + 2 doublings.
```

**Example 2:**
```
Input: nums = [3,2,2,4]
Output: 7
```

**Example 3:**
```
Input: nums = [2,2]
Output: 3
```

---

## Constraints
- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^9`

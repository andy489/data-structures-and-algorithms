# 1526. Minimum Number of Increments on Subarrays to Form a Target Array

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/

---

## Problem Statement

You are given an integer array `target`. In one operation you can choose any subarray of an all-zeros array and increment all elements in it by 1. Return the minimum number of operations needed to form `target`.

---

## Examples

**Example 1:**
```
Input: target = [1,2,3,2,1]
Output: 3
Explanation: We need at least 3 operations to form the target array.
```

**Example 2:**
```
Input: target = [3,1,1,2]
Output: 4
Explanation: (initial)[0,0,0,0] -> [1,1,1,1] -> [2,1,1,2] -> [3,1,1,2]
```

**Example 3:**
```
Input: target = [3,1,2,2]
Output: 4
```

---

## Constraints
- `1 <= target.length <= 10^5`
- `1 <= target[i] <= 10^4`

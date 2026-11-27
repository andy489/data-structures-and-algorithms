# 1675. Minimize Deviation in Array

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimize-deviation-in-array/

---

## Problem Statement

You are given an array `nums` of `n` positive integers.

You can perform two types of operations on any element of the array any number of times:

- If the element is **even**, **divide** it by `2`.
- If the element is **odd**, **multiply** it by `2`.

The **deviation** of the array is the **maximum difference** between any two elements in the array.

Return the **minimum deviation** the array can have after performing some number of operations.

---

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4]
Output: 1
Explanation: Modify nums so that it becomes [1,2,3,2]:
- 4 -> 2 -> divide 4 by 2
- the deviation becomes max - min = 3 - 2 = 1
Actually, [2,2,2,2] gives deviation 0? No: 1 can become 2, 3 can become 6, so optimal is [2,2,2,2] -> wait, 3 is odd*2=6, then 6/2=3... Result: [2,2,3,2] deviation = 1.
```

**Example 2:**
```
Input: nums = [4,1,5,20,3]
Output: 3
Explanation: Modify nums so that it becomes [4,2,5,5,3], deviation = 5-2 = 3.
```

**Example 3:**
```
Input: nums = [2,10,8]
Output: 3
```

---

## Constraints

- `n == nums.length`
- `2 <= n <= 5 * 10^4`
- `1 <= nums[i] <= 10^9`

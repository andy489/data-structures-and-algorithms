# 457. Circular Array Loop

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/circular-array-loop/

---

## Problem Statement

You are playing a game involving a **circular** array of non-zero integers `nums`. Each `nums[i]` denotes the number of indices forward/backward you must move if you are located at index `i`:

- If `nums[i]` is positive, move `nums[i]` steps **forward**, and
- If `nums[i]` is negative, move `nums[i]` steps **backward**.

Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backward from the first element puts you on the last element.

A **cycle** in the array consists of a sequence of indices `seq` of length `k` where:

- Following the movement rules above results in the repeating index sequence `seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...`
- Every `nums[seq[j]]` is either all positive or all negative.
- `k > 1`

Return `true` if there is a **cycle** in `nums`, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  nums = [2,-1,1,2,2]
Output: true
```

**Example 2:**
```
Input:  nums = [-1,-2,-3,-4,-5,6]
Output: false
```

**Example 3:**
```
Input:  nums = [1,-1,5,1,4]
Output: true
```

---

## Constraints

- `1 <= nums.length <= 5000`
- `-1000 <= nums[i] <= 1000`
- `nums[i] != 0`

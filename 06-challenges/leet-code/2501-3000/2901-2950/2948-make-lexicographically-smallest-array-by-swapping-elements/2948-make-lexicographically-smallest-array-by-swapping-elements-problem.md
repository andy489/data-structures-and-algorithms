# 2948. Make Lexicographically Smallest Array by Swapping Elements

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/

---

## Problem Statement

You are given a **0-indexed** array of **positive** integers `nums` and a **positive** integer `limit`.

In one operation, you can choose any two indices `i` and `j` and swap `nums[i]` and `nums[j]` **if** `|nums[i] - nums[j]| <= limit`.

Return *the **lexicographically smallest array** that can be obtained by performing the operation any number of times*.

---

## Examples

**Example 1:**
```
Input: nums = [1,5,3,9,8], limit = 2
Output: [1,3,5,8,9]
Explanation: Swap nums[1] with nums[2] => [1,3,5,9,8], swap nums[3] with nums[4] => [1,3,5,8,9].
```

**Example 2:**
```
Input: nums = [1,7,6,18,2,1], limit = 3
Output: [1,6,7,18,1,2]
```

**Example 3:**
```
Input: nums = [1,7,28,19,10], limit = 3
Output: [1,7,28,19,10]
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= limit <= 10^9`

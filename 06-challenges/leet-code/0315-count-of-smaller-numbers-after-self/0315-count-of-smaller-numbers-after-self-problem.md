# 315. Count of Smaller Numbers After Self

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-of-smaller-numbers-after-self/

---

## Problem Statement

Given an integer array `nums`, return an integer array `counts` where `counts[i]` is the number of smaller elements to the right of `nums[i]`.

---

## Examples

**Example 1:**
```
Input:  nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there are 0 smaller elements.
```

**Example 2:**
```
Input:  nums = [-1]
Output: [0]
```

**Example 3:**
```
Input:  nums = [-1,-1]
Output: [0,0]
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`

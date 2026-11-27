# 1425. Constrained Subsequence Sum

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/constrained-subsequence-sum/

---

## Problem Statement

Return the max sum of a non-empty subsequence of `nums` such that for every two consecutive elements in the subsequence, their indices differ by at most `k`.

---

## Examples

**Example 1:**
```
Input:  nums=[10,2,-10,5,20],k=2
Output: 37
```

**Example 2:**
```
Input:  nums=[-1,-2,-3],k=1
Output: -1
```

**Example 3:**
```
Input:  nums=[10,-2,-10,-5,20],k=2
Output: 23
```

---

## Constraints

- `1 <= k <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`

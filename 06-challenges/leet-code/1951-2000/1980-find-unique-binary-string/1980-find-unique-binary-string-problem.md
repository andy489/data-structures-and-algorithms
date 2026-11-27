# 1980. Find Unique Binary String

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/find-unique-binary-string/

## Problem

Given an array of strings `nums` containing `n` unique binary strings each of length `n`, return a binary string of length `n` that does not appear in `nums`. If there are multiple answers, you may return any of them.

## Examples

**Example 1:**
```
Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
```

**Example 2:**
```
Input: nums = ["00","01"]
Output: "11"
```

**Example 3:**
```
Input: nums = ["111","011","001"]
Output: "101"
```

## Constraints

- `n == nums.length`
- `1 <= n <= 16`
- `nums[i].length == n`
- `nums[i]` is either `'0'` or `'1'`.
- All the strings of `nums` are unique.

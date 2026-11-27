# 1987. Number of Unique Good Subsequences

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/number-of-unique-good-subsequences/

## Problem

You are given a binary string `binary`. A subsequence of `binary` is considered **good** if it is not empty and has no leading zeros (with the exception of `"0"`).

Find the number of unique good subsequences of `binary`.

Return the number of unique good subsequences of `binary`. Since the answer may be very large, return it modulo `10^9 + 7`.

## Examples

**Example 1:**
```
Input: binary = "001"
Output: 2
Explanation: The unique good subsequences are "0" and "1".
```

**Example 2:**
```
Input: binary = "11"
Output: 2
Explanation: The unique good subsequences are "1" and "11".
```

**Example 3:**
```
Input: binary = "101"
Output: 5
Explanation: The unique good subsequences are "0", "1", "10", "11", and "101".
```

## Constraints

- `1 <= binary.length <= 10^5`
- `binary` consists of only `'0'`s and `'1'`s.

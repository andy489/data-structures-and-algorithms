# 1520. Maximum Number of Non-Overlapping Substrings

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/

---

## Problem Statement

Given a string `s` of lowercase letters, your task is to find the maximum number of **non-empty** substrings of `s` that meet the following conditions:

1. The substrings do not overlap, that is for any two substrings `s[i..j]` and `s[x..y]`, either `j < x` or `i > y` is true.
2. A substring that contains a certain character `c` must also contain all occurrences of `c`.

Find the **maximum** number of non-overlapping substrings that satisfy the above conditions. If there are multiple solutions with the same number of substrings, return the one with **minimum total length**. It can be shown that there exists a unique answer.

Return the list in any order.

---

## Examples

**Example 1:**
```
Input:  s = "adefaddaccc"
Output: ["e","f","ccc"]
Explanation: The following are all the possible substrings that meet the conditions:
[ "adefaddaccc" , "adefadda" , "ef" , "e" , "ccc" , "f" ]
If we choose the first string, we cannot choose anything else and we'd get only 1.
If we choose "adefadda", we can only get 2, with "ccc".
If we choose "ef", "ccc" and "f" we can get 3 substrings. So the maximum number of substrings is 3.
```

**Example 2:**
```
Input:  s = "abbaccd"
Output: ["d","bb","cc"]
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of only lowercase English letters.

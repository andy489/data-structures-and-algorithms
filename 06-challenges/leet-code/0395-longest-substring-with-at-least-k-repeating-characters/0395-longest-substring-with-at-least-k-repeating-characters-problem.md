# 395. Longest Substring with At Least K Repeating Characters

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

---

## Problem Statement

Given a string `s` and an integer `k`, return the length of the longest substring of `s` such that the frequency of each character in this substring is greater than or equal to `k`.

If no such substring exists, return `0`.

---

## Examples

**Example 1:**
```
Input:  s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
```

**Example 2:**
```
Input:  s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
```

---

## Constraints

- `1 <= s.length <= 10^4`
- `s` consists of only lowercase English letters.
- `1 <= k <= 10^5`

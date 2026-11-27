# 1542. Find Longest Awesome Substring

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-longest-awesome-substring/

---

## Problem Statement

Given a string `s`. An awesome substring is a non-empty substring of `s` such that we can make any number of swaps in order to make it a palindrome.

Return the length of the maximum length awesome substring of `s`.

---

## Examples

**Example 1:**
```
Input: s = "3242415"
Output: 5
Explanation: "24241" is a palindrome after shuffling.
```

**Example 2:**
```
Input: s = "12345678"
Output: 1
```

**Example 3:**
```
Input: s = "213123"
Output: 6
Explanation: The entire string is a palindrome after shuffling.
```

---

## Constraints
- `1 <= s.length <= 10^5`
- `s` consists of digits `'0'` to `'9'` only.

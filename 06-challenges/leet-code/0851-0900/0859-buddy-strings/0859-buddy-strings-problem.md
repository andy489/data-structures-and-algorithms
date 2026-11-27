# 859. Buddy Strings

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/buddy-strings/

---

## Problem Statement

Given two strings `s` and `goal`, return `true` if you can swap two letters in `s` so the result is equal to `goal`, otherwise, return `false`.

Swapping letters is defined as taking two indices `i` and `j` (0-indexed) such that `i != j` and swapping the characters at `s[i]` and `s[j]`.

---

## Examples

**Example 1:**
```
Input:  s = "ab", goal = "ba"
Output: true
```

**Example 2:**
```
Input:  s = "ab", goal = "ab"
Output: false
```

**Example 3:**
```
Input:  s = "aa", goal = "aa"
Output: true
```

---

## Constraints

- `1 <= s.length, goal.length <= 2 * 10^4`
- `s` and `goal` consist of lowercase English letters.

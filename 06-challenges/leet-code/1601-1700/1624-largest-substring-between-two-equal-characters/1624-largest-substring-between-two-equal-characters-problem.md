# 1624. Largest Substring Between Two Equal Characters

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/largest-substring-between-two-equal-characters/

---

## Problem Statement

Given a string `s`, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return `-1`.

A **substring** is a contiguous sequence of characters within a string.

---

## Examples

**Example 1:**
```
Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.
```

**Example 2:**
```
Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".
```

**Example 3:**
```
Input: s = "cbzxy"
Output: -1
Explanation: There are no two equal characters, so we return -1.
```

---

## Constraints
- `1 <= s.length <= 300`
- `s` contains only lowercase English letters.

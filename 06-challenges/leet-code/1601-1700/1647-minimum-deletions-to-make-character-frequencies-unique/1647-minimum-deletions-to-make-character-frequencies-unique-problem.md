# 1647. Minimum Deletions to Make Character Frequencies Unique

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

---

## Problem Statement

A string `s` is called **good** if there are no two different characters in `s` that have the same frequency.

Given a string `s`, return the **minimum** number of characters you need to delete to make `s` good.

---

## Examples

**Example 1:**
```
Input: s = "aab"
Output: 0
Explanation: s is already good since 'a' has frequency 2 and 'b' has frequency 1.
```

**Example 2:**
```
Input: s = "aaabbbcc"
Output: 2
Explanation: Delete one 'b' and one 'c' → "aaabbc", which has distinct frequencies.
```

**Example 3:**
```
Input: s = "ceabaacb"
Output: 2
Explanation: Delete both 'c's → "eabaab", which is good.
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s` contains only lowercase English letters.

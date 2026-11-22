# 2124. Check if All A's Appears Before All B's

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/

---

## Problem Statement

Given a string `s` consisting only of the characters `'a'` and `'b'`, return `true` if **every** `'a'` appears before **every** `'b'` in the string. Otherwise, return `false`.

---

## Examples

**Example 1:**
```
Input:  s = "aaabbb"
Output: true
Explanation: The 'a's are at indices 0, 1, and 2, while the 'b's are at indices 3, 4, and 5.
             All 'a's appear before all 'b's.
```

**Example 2:**
```
Input:  s = "abab"
Output: false
Explanation: There is an 'a' at index 2 that appears after a 'b' at index 1.
```

**Example 3:**
```
Input:  s = "bbb"
Output: true
Explanation: There are no 'a's, so the condition is trivially satisfied.
```

---

## Constraints

- `1 <= s.length <= 100`
- `s[i]` is either `'a'` or `'b'`

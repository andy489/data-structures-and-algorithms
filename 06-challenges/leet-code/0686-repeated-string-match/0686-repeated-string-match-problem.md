# 686. Repeated String Match

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/repeated-string-match/

---

## Problem Statement

Given two strings `a` and `b`, return the minimum number of times you should repeat string `a` such that string `b` is a substring of it. If it is not possible for `b` to be a substring of `a` after repeating, return `-1`.

Notice: string `"abc"` repeated 0 times is `""`, repeated 1 time is `"abc"` and repeated 2 times is `"abcabc"`.

---

## Examples

**Example 1:**
```
Input:  a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a 3 times "abcdabcdabcd", b is a substring of it.
```

**Example 2:**
```
Input:  a = "a", b = "aa"
Output: 2
```

---

## Constraints

- `1 <= a.length, b.length <= 10⁴`
- `a` and `b` consist of lowercase English letters.

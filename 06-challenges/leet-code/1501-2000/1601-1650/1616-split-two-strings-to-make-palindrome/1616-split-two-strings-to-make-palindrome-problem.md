# 1616. Split Two Strings to Make Palindrome

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/split-two-strings-to-make-palindrome/

---

## Problem Statement

You are given two strings `a` and `b` of the same length. Choose an index and split both strings at the same index, splitting `a` into two strings: `aprefix` and `asuffix` where `a = aprefix + asuffix`, and splitting `b` into two strings: `bprefix` and `bsuffix` where `b = bprefix + bsuffix`. Check if `aprefix + bsuffix` or `bprefix + asuffix` forms a palindrome.

When you split a string `s` into `sprefix` and `ssuffix`, either `ssuffix` or `sprefix` can be empty. For example, if `s = "abc"`, then `"" + "abc"`, `"a" + "bc"`, `"ab" + "c"`, and `"abc" + ""` are valid splits.

Return `true` if it is possible to form a palindrome string, otherwise return `false`.

---

## Examples

**Example 1:**
```
Input: a = "x", b = "y"
Output: true
Explanation: If either a or b is a palindrome, the split ""+a or ""+b works.
```

**Example 2:**
```
Input: a = "xbdef", b = "xecab"
Output: false
```

**Example 3:**
```
Input: a = "ulacfd", b = "jizalu"
Output: true
Explanation: Split at index 3: "ula" + "lu" = "ulalu", which is a palindrome.
```

---

## Constraints
- `1 <= a.length, b.length <= 10^5`
- `a.length == b.length`
- `a` and `b` consist of lowercase English letters.

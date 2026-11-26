# 1525. Number of Good Ways to Split a String

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

---

## Problem Statement

You are given a string `s`. A split is called good if you can split `s` into two non-empty strings `s_left` and `s_right` where their concatenation is `s` (i.e., `s_left + s_right = s`) and the number of distinct letters in `s_left` and `s_right` is the same.

Return the number of good splits you can make in `s`.

---

## Examples

**Example 1:**
```
Input: s = "aacaba"
Output: 2
Explanation: There are 5 ways to split "aacaba":
  "a" and "acaba" - 1 unique letter vs 3 unique letters - not good
  "aa" and "caba" - 1 unique letter vs 3 unique letters - not good
  "aac" and "aba" - 2 unique letters vs 2 unique letters - good
  "aaca" and "ba" - 2 unique letters vs 2 unique letters - good
  "aacab" and "a" - 3 unique letters vs 1 unique letter - not good
```

**Example 2:**
```
Input: s = "abcd"
Output: 1
Explanation: Split "abcd" into "abc" and "d". 3 unique letters vs 1 unique letter - not good.
Wait: "a" and "bcd" - 1 vs 3 not good; "ab" and "cd" - 2 vs 2 - good; etc.
```

---

## Constraints
- `1 <= s.length <= 10^5`
- `s` consists of only lowercase English letters.

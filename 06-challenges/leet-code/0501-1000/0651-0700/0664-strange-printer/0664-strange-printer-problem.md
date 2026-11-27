# 664. Strange Printer

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/strange-printer/

---

## Problem Statement

There is a strange printer with the following two special properties:

- The printer can only print a sequence of **the same character** each time.
- At each turn, the printer can print new characters starting from and ending at any place, and will **overwrite** the existing characters.

Given a string `s`, return the **minimum number of turns** the printer needs to print it.

---

## Examples

**Example 1:**
```
Input:  s = "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".
```

**Example 2:**
```
Input:  s = "aba"
Output: 2
Explanation: Print "aaa" first and then print "b" at position 2.
```

---

## Constraints

- `1 <= s.length <= 100`
- `s` consists of lowercase English letters.

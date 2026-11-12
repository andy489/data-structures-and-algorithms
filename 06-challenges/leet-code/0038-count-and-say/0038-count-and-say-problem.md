# 38. Count and Say

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-and-say/

---

## Problem Statement

The **count-and-say** sequence is a sequence of digit strings defined by the recursive formula:

- `countAndSay(1) = "1"`
- `countAndSay(n)` is the run-length encoding of `countAndSay(n - 1)`.

**Run-length encoding (RLE)** is a string compression method that works by replacing consecutive identical characters with the count followed by the character. For example, to compress `"3322251"` we replace `"33"` with `"23"`, replace `"222"` with `"32"`, replace `"5"` with `"15"`, and replace `"1"` with `"11"`. So the compressed string becomes `"23321511"`.

Given a positive integer `n`, return the `n`th element of the count-and-say sequence.

---

## Examples

**Example 1:**
```
Input:  n = 1
Output: "1"
Explanation: This is the base case.
```

**Example 2:**
```
Input:  n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = RLE of "1"     = "11"
countAndSay(3) = RLE of "11"    = "21"
countAndSay(4) = RLE of "21"    = "1211"
```

---

## Constraints

- `1 <= n <= 30`

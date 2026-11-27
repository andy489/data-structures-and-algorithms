# 467. Unique Substrings in Wraparound String

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/unique-substrings-in-wraparound-string/

---

## Problem Statement

We define the string `base` to be the infinite wraparound string of `"abcdefghijklmnopqrstuvwxyz"`, so `base` will look like this:

`"...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...."`.

Given a string `p`, return the number of **unique non-empty substrings** of `p` are present in `base`.

---

## Examples

**Example 1:**
```
Input:  p = "a"
Output: 1
```

**Example 2:**
```
Input:  p = "cac"
Output: 2
```

**Example 3:**
```
Input:  p = "zab"
Output: 6
```

---

## Constraints

- `1 <= p.length <= 10^5`
- `p` consists of lowercase English letters.

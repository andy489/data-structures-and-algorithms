# 1540. Can Convert String in K Moves

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/can-convert-string-in-k-moves/

---

## Problem Statement

Given two strings `s` and `t`, your goal is to convert `s` into `t` in `k` moves or less. During the `i`-th move (1-indexed) you can:
- Choose any index `j` (1-indexed) from `s` such that `1 <= j <= s.length` and shift the character at that index `i` times.
- Or do nothing.

Shifting a character means replacing it by the next letter in the alphabet (wrapping 'z' to 'a').

Return `true` if you can convert `s` to `t` in no more than `k` moves, otherwise return `false`.

---

## Examples

**Example 1:**
```
Input: s = "input", t = "ouput", k = 9
Output: true
```

**Example 2:**
```
Input: s = "abc", t = "bcd", k = 10
Output: false
```

**Example 3:**
```
Input: s = "aab", t = "bbb", k = 27
Output: true
```

---

## Constraints
- `1 <= s.length, t.length <= 10^5`
- `0 <= k <= 10^9`
- `s`, `t` contain only lowercase English letters.

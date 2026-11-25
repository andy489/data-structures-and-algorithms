# 848. Shifting Letters

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shifting-letters/

---

## Problem Statement

You are given a string `s` of lowercase English letters and an integer array `shifts`.

Call the **shift** of a letter, the next letter in the alphabet, (wrapping around so that `'z'` becomes `'a'`).

For example, `shift('a') = 'b'`, `shift('t') = 'u'`, and `shift('z') = 'a'`.

Now for each `shifts[i] = x`, we want to shift the first `i + 1` letters of `s`, `x` times.

Return the final string after all such shifts to `s` are applied.

---

## Examples

**Example 1:**
```
Input: s = "abc", shifts = [3,5,9]
Output: "rpl"
```

**Example 2:**
```
Input: s = "aaa", shifts = [1,2,3]
Output: "gfd"
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of lowercase English letters.
- `shifts.length == s.length`
- `0 <= shifts[i] <= 10^9`

# 466. Count The Repetitions

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-the-repetitions/

---

## Problem Statement

We define `str = [s, n]` as the string `str` which consists of the string `s` concatenated `n` times.

- For example, `str == ["abc", 3] =="abcabcabc"`.

We define that string `s1` can be obtained from string `s2` if we can remove some characters from `s2` such that the remaining characters in the same order form `s1`. For example, `"abc"` can be obtained from `"abdbec"` based on our definition by this order: `"abdbec"`.

We are given two strings `s1` and `s2` and two integers `n1` and `n2`. We have:

- `str1 = [s1, n1]`
- `str2 = [s2, n2]`

Return the **maximum** integer `m` such that `str = [str2, m]` can be obtained from `str1`.

---

## Examples

**Example 1:**
```
Input:  s1 = "acb", n1 = 4, s2 = "ab", n2 = 2
Output: 2
```

**Example 2:**
```
Input:  s1 = "acb", n1 = 1, s2 = "acb", n2 = 1
Output: 1
```

---

## Constraints

- `1 <= s1.length, s2.length <= 100`
- `s1` and `s2` consist of lowercase English letters.
- `1 <= n1, n2 <= 10^6`

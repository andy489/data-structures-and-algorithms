# 1758. Minimum Changes to Make Alternating Binary String

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/

---

## Problem Statement

You are given a string `s` consisting only of the characters `'0'` and `'1'`. In one operation, you can change any `'0'` to `'1'` or vice versa.

The string is called **alternating** if no two adjacent characters are equal. For example, the string `"010"` is alternating, while the string `"0100"` is not.

Return the **minimum** number of operations needed to make `s` alternating.

---

## Examples

**Example 1:**
```
Input: s = "0100"
Output: 1
Explanation: If you change the last character to '1', s becomes "0101".
```

**Example 2:**
```
Input: s = "10"
Output: 0
Explanation: s is already alternating.
```

**Example 3:**
```
Input: s = "1111"
Output: 2
Explanation: One possible conversion: s becomes "0101".
```

---

## Constraints

- `1 <= s.length <= 10^4`
- `s[i]` is either `'0'` or `'1'`.

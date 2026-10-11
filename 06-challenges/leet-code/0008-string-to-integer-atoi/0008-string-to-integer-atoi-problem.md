# 8. String to Integer (atoi)

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/string-to-integer-atoi/

---

## Problem Statement

Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer.

The algorithm for `myAtoi(string s)` is as follows:

1. **Whitespace:** Ignore any leading whitespace.
2. **Signedness:** Determine the sign by checking if the next character is `'-'` or `'+'`, defaulting to positive if neither.
3. **Conversion:** Read digits until a non-digit character or end of string is reached. Convert the read digits to an integer.
4. **Rounding:** If the integer is out of the 32-bit signed range `[-2^31, 2^31 - 1]`, clamp it to that range.

Return the resulting integer.

**Note:** No built-in conversion functions or libraries that convert a string to an integer may be used.

---

## Examples

**Example 1:**
```
Input:  s = "42"
Output: 42
```

**Example 2:**
```
Input:  s = " -042"
Output: -42
Explanation: Leading whitespace ignored, '-' sign read, "042" → 42.
```

**Example 3:**
```
Input:  s = "1337c0d3"
Output: 1337
Explanation: Stops at 'c' (non-digit).
```

**Example 4:**
```
Input:  s = "0-1"
Output: 0
Explanation: Stops at '-' after reading '0'.
```

**Example 5:**
```
Input:  s = "words and 987"
Output: 0
Explanation: No leading digit, returns 0.
```

---

## Constraints

- `0 <= s.length <= 200`
- `s` consists of English letters, digits, `' '`, `'+'`, `'-'`, and `'.'`.

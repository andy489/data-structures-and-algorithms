# 13. Roman to Integer

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/roman-to-integer/

---

## Problem Statement

Given a Roman numeral, convert it to an integer.

Roman numerals are represented by seven different symbols:

| Symbol | Value |
|--------|-------|
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

Roman numerals are usually written largest to smallest from left to right. However, there are six cases where subtraction is used:
- `IV` = 4, `IX` = 9
- `XL` = 40, `XC` = 90
- `CD` = 400, `CM` = 900

---

## Examples

**Example 1:**
```
Input:  s = "III"
Output: 3
Explanation: III = 3.
```

**Example 2:**
```
Input:  s = "LVIII"
Output: 58
Explanation: L = 50, V = 5, III = 3.
```

**Example 3:**
```
Input:  s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90, IV = 4.
```

---

## Constraints

- `1 <= s.length <= 15`
- `s` contains only the characters `('I', 'V', 'X', 'L', 'C', 'D', 'M')`.
- It is guaranteed that `s` is a valid roman numeral in the range `[1, 3999]`.

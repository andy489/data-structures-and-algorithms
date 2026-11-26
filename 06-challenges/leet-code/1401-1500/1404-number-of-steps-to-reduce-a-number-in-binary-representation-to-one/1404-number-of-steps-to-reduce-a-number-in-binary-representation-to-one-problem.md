# 1404. Number Of Steps To Reduce A Number In Binary Representation To One

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/

---

## Problem Statement

Given binary string `s`, return the number of steps to reduce it to `"1"`. Even → divide by 2 (drop last bit). Odd → add 1.

---

## Examples

**Example 1:**
```
Input:  s = "1101"
Output: 6
```

**Example 2:**
```
Input:  s = "10"
Output: 1
```

**Example 3:**
```
Input:  s = "1"
Output: 0
```

---

## Constraints

- `1 <= s.length <= 500`
- `s[i] is '0' or '1'`
- `s[0] == '1'`

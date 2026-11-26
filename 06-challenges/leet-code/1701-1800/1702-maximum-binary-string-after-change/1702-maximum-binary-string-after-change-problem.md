# 1702. Maximum Binary String After Change

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-binary-string-after-change/

---

## Problem Statement

You are given a binary string `binary` consisting of only `0`'s or `1`'s. You can apply each of the following operations any number of times:

- **Operation 1:** If the number contains the substring `"00"`, you can replace it with `"10"`.
  - For example, `"00010" -> "10010"`
- **Operation 2:** If the number contains the substring `"10"`, you can replace it with `"01"`.
  - For example, `"00010" -> "00001"`

Return the **maximum binary string** you can obtain after any number of operations. Binary string `x` is greater than binary string `y` if `x`'s decimal representation is greater than `y`'s decimal representation.

---

## Examples

**Example 1:**
```
Input: binary = "000110"
Output: "111011"
```

**Example 2:**
```
Input: binary = "01"
Output: "01"
```

---

## Constraints

- `1 <= binary.length <= 10^5`
- `binary` consists of `'0'` and `'1'`.

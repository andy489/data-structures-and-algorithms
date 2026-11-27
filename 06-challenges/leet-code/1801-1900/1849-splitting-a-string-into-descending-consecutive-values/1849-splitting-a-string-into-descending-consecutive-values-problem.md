# 1849. Splitting a String Into Descending Consecutive Values

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/

---

## Problem Statement

You are given a string `s` that consists of only digits.

Check if we can split `s` into **two or more non-empty substrings** such that the **numerical values** of the substrings are in **descending order** and the **difference** between numerical values of every two **adjacent substrings** is equal to `1`.

- For example, the string `s = "0090089"` can be split into `["009", "008", "9"]` with numerical values `[9,8,9]`. The values are not in descending order, so this is not a valid split.
- Another example, the string `s = "10009998"` can be split into `["100", "099", "98"]` with numerical values `[100,99,98]`. The values are in descending order and adjacent differences are `1`, so this is a valid split.

Return `true` *if it is possible to split* `s` *as described above*, *or* `false` *otherwise.*

A substring is a contiguous sequence of characters in a string.

---

## Examples

**Example 1:**
```
Input: s = "1234"
Output: false
Explanation: There is no valid way to split s.
```

**Example 2:**
```
Input: s = "050043"
Output: true
Explanation: s can be split into ["05", "004", "3"] with numerical values [5,4,3].
The values are in descending order with adjacent differences equal to 1.
```

**Example 3:**
```
Input: s = "9080701"
Output: false
Explanation: There is no valid way to split s.
```

---

## Constraints

- `1 <= s.length <= 20`
- `s` only consists of digits.

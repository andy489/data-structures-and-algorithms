# 925. Long Pressed Name

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/long-pressed-name/

---

## Problem Statement

Your friend is typing his `name` into a keyboard. Sometimes, when typing a character `c`, the key might get **long pressed**, and the character will be typed 1 or more times.

You examine the `typed` characters of the keyboard. Return `True` if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

---

## Examples

**Example 1:**
```
Input:  name = "alex", typed = "aaleex"
Output: true
```

**Example 2:**
```
Input:  name = "saeed", typed = "ssaaedd"
Output: false
```

---

## Constraints

- `1 <= name.length, typed.length <= 1000`
- `name` and `typed` consist of only lowercase English letters.

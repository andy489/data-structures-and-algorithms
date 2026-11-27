# 3389. Minimum Operations to Make Character Frequencies Equal

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-operations-to-make-character-frequencies-equal/

---

## Problem Statement

You are given a string `s`.

A string `t` is called **good** if all characters of `t` occur the same number of times.

You can perform the following operations **any number of times**:

- Delete a character from `s`.
- Insert a character in `s`.
- Change a character in `s` to its next letter in the alphabet.

**Note** that you cannot change `'z'` to `'a'` using the third operation.

Return the **minimum** number of operations required to make `s` **good**.

---

## Examples

**Example 1:**
```
Input:  s = "acab"
Output: 1
```
Explanation: Delete one occurrence of 'a'.

**Example 2:**
```
Input:  s = "wddw"
Output: 0
```
Explanation: Already good ('w' and 'd' each appear twice).

**Example 3:**
```
Input:  s = "aaabc"
Output: 2
```
Explanation: Change one 'a' to 'b' (cost 1), insert one 'c' (cost 1).

---

## Constraints

- `3 <= s.length <= 2 * 10^4`
- `s` contains only lowercase English letters.

# 2000. Reverse Prefix of Word

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reverse-prefix-of-word/

---

## Problem Statement

Given a **0-indexed** string `word` and a character `ch`, reverse the segment of `word` that starts at index 0 and ends at the index of the **first occurrence** of `ch` (inclusive). If the character `ch` does not exist in `word`, do nothing.

Return the resulting string.

---

## Examples

**Example 1:**
```
Input:  word = "abcdefd", ch = "d"
Output: "dcbaefd"
```
Explanation: The first occurrence of 'd' is at index 3. Reverse word[0..3] → 'dcba', result = 'dcbaefd'.

**Example 2:**
```
Input:  word = "xyxzxe", ch = "z"
Output: "zxyxxe"
```
Explanation: The first occurrence of 'z' is at index 3. Reverse word[0..3] → 'zxyx', result = 'zxyxxe'.

**Example 3:**
```
Input:  word = "abcd", ch = "z"
Output: "abcd"
```
Explanation: 'z' does not exist, return word unchanged.

---

## Constraints

- `1 <= word.length <= 250`
- `word consists of lowercase English letters.`
- `ch is a lowercase English letter.`

# 2047. Number of Valid Words in a Sentence

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-valid-words-in-a-sentence/

---

## Problem Statement

A sentence contains tokens separated by spaces. A token is valid if: it only consists of lowercase letters, digits (0-9), hyphens, and punctuation ('!', '.', ','), with at most one hyphen (between letters) and punctuation only at the end. Return the number of valid tokens.

---

## Examples

**Example 1:**
```
Input:  sentence = "cat and  dog"
Output: 3
```

**Example 2:**
```
Input:  sentence = "!this  1-s b8d!"
Output: 0
```

**Example 3:**
```
Input:  sentence = "alice and  bob are playing stone-game10"
Output: 5
```

---

## Constraints

- `1 <= sentence.length <= 1000`
- `sentence only contains lowercase English letters, digits, spaces, hyphens, and punctuation.`

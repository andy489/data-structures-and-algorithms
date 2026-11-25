# 824. Goat Latin

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/goat-latin/

---

## Problem Statement

A sentence `sentence` is converted to Goat Latin using the following rules:

- If a word begins with a vowel (`a`, `e`, `i`, `o`, or `u`), append `"ma"` to the end.
- If a word begins with a consonant, remove the first letter and append it to the end, then add `"ma"`.
- Add one letter `'a'` to the end of each word per its word index (1-indexed).

Return the final sentence representing the conversion from sentence to Goat Latin.

---

## Examples

**Example 1:**
```
Input:  sentence = "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
```

---

## Constraints

- `1 <= sentence.length <= 150`
- `sentence` consists of English letters and spaces.
- There are no leading or trailing spaces.
- All words consist of only uppercase and lowercase English letters.

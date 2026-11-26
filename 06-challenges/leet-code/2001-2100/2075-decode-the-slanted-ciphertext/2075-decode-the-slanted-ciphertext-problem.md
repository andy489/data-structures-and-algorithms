# 2075. Decode the Slanted Ciphertext

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/decode-the-slanted-ciphertext/

---

## Problem Statement

A string was written in a matrix with `rows` rows. Reading diagonally from top-left to bottom-right, it becomes the ciphertext. Decode and return the original string with trailing spaces removed.

---

## Examples

**Example 1:**
```
Input:  encodedText = "ch   ie   pr", rows = 3
Output: "cipher"
```

**Example 2:**
```
Input:  encodedText = "iveo    eed   l te   olc", rows = 4
Output: "i love leetcode"
```

**Example 3:**
```
Input:  encodedText = "coding", rows = 1
Output: "coding"
```

---

## Constraints

- `0 <= encodedText.length <= 10^6`
- `encodedText consists of lowercase English letters and ' '.`
- `encodedText is a valid encoding of some original text.`

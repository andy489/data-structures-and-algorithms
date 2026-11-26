# 3014. Minimum Number of Pushes to Type Word I

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/

---

## Problem Statement

You are given a string `word` containing distinct lowercase English letters.

A telephone keypad has keys 2–9. Each key can be mapped to any number of letters. To type a letter assigned to key `k` at position `p` (1-indexed), you need to push key `k` exactly `p` times.

You need to map all letters of `word` to the keypad keys (2-9, so 8 keys). Return the minimum number of pushes needed to type `word`.

---

## Examples

**Example 1:**
```
Input:  word = "abcde"
Output: 5
```
Explanation: Map a→2, b→3, c→4, d→5, e→6. Each needs 1 push.

**Example 2:**
```
Input:  word = "xyzxyzxyzxyz"
Output: 12
```

---

## Constraints

- `1 <= word.length <= 26`
- `word` consists of distinct lowercase English letters.

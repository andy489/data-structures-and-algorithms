# 819. Most Common Word

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/most-common-word/

---

## Problem Statement

Given a string `paragraph` and a string array of banned words, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and the answer is unique.

---

## Examples

**Example 1:**
```
Input:  paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
```

---

## Constraints

- `1 <= paragraph.length <= 1000`
- `paragraph` consists of English letters, space, or punctuation `'!?',;.'`.
- `0 <= banned.length <= 100`
- `1 <= banned[i].length <= 10`
- `banned[i]` consists only of lowercase English letters.

# 2942. Find Words Containing Character

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-words-containing-character/

---

## Problem Statement

You are given a **0-indexed** array of strings `words` and a character `x`.

Return *an **array of indices** representing the words that contain the character* `x`.

**Note** that the returned array may be in **any** order.

---

## Examples

**Example 1:**
```
Input: words = ["leet","code"], x = "e"
Output: [0,1]
Explanation: "e" occurs in both "leet" and "code".
```

**Example 2:**
```
Input: words = ["abc","bcd","aaaa","cbc"], x = "a"
Output: [0,2]
Explanation: "a" occurs in "abc" and "aaaa".
```

**Example 3:**
```
Input: words = ["abc","bcd","aaaa","cbc"], x = "z"
Output: []
Explanation: "z" does not occur in any of the words.
```

---

## Constraints

- `1 <= words.length <= 50`
- `1 <= words[i].length <= 50`
- `x` is a lowercase English letter.
- `words[i]` consists only of lowercase English letters.

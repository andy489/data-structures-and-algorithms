# 1657. Determine if Two Strings Are Close

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/determine-if-two-strings-are-close/

---

## Problem Statement

Two strings are considered **close** if you can attain one from the other using the following operations:

- **Operation 1:** Swap any two **existing** characters. For example, `abcde -> aecdb`.
- **Operation 2:** Transform every occurrence of one **existing** character into another **existing** character, and do the same with the other character. For example, `aacabb -> bbcbaa` (all `a`'s turn into `b`'s, and all `b`'s turn into `a`'s).

You can use the operations on either string as many times as necessary.

Given two strings `word1` and `word2`, return `true` if `word1` and `word2` are close, and `false` otherwise.

---

## Examples

**Example 1:**
```
Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: Operation 1: "abc" -> "bca"
```

**Example 2:**
```
Input: word1 = "a", word2 = "aa"
Output: false
```

**Example 3:**
```
Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: Operation 1: "cabbba" -> "caabbb"
             Operation 2: "caabbb" -> "baaccc" -> "abbccc"
```

---

## Constraints

- `1 <= word1.length, word2.length <= 10^5`
- `word1` and `word2` consist of only lowercase English letters.

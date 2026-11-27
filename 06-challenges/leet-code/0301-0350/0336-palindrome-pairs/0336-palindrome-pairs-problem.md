# 336. Palindrome Pairs

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/palindrome-pairs/

---

## Problem Statement

You are given a **0-indexed** array of **unique** strings `words`.

A **palindrome pair** is a pair of integers `(i, j)` such that `i != j` and `words[i] + words[j]` (concatenation) is a palindrome.

Return an array of all the palindrome pairs of `words`.

---

## Examples

**Example 1:**
```
Input:  words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
```

**Example 2:**
```
Input:  words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
```

---

## Constraints

- `1 <= words.length <= 5000`
- `0 <= words[i].length <= 300`
- `words[i]` consists of lowercase English letters.

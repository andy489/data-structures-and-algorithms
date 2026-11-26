# 966. Vowel Spellchecker

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/vowel-spellchecker/

---

## Problem Statement

Given a `wordlist`, we want to implement a spellchecker that converts a query word into a correct word.

For a given `query` word, the spell checker handles two categories of spelling mistakes:

- **Capitalization**: If the query matches a word in the wordlist (case-insensitively), return the first such match.
- **Vowel Errors**: If lowercasing the query and replacing all vowels with `'*'` matches a word in the wordlist, return the first such match.

Return a list of words that result from replacing each query. If a query has no match, return the query unchanged.

---

## Examples

**Example 1:**
```
Input:  wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","ketic"]
Output: ["kite","KiTe","KiTe","Hare","hare","","","kite",""]
```

---

## Constraints

- `1 <= wordlist.length, queries.length <= 5000`
- `1 <= wordlist[i].length, queries[i].length <= 7`

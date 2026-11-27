# 1170. Compare Strings by Frequency of the Smallest Character

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

---

## Problem Statement

Let the function `f(s)` be defined as the **frequency of the lexicographically smallest character** in a non-empty string `s`. For example, if `s = "dcce"` then `f(s) = 2` because the lexicographically smallest character is `'c'`, which has a frequency of `2`.

You are given an array of strings `queries` and an array of strings `words`. For each query `queries[i]`, count the number of words in `words` such that `f(queries[i]) < f(W)` for each word `W` in `words`.

Return an integer array `answer`, where `answer[i]` is the answer to the `i`th query.

---

## Examples

**Example 1:**
```
Input:  queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: f("cbd") = 1, f("zaaaz") = 3. Since 1 < 3, the answer is [1].
```

**Example 2:**
```
Input:  queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation:
  f("bbb") = 3, f("cc") = 2.
  f("a")=1, f("aa")=2, f("aaa")=3, f("aaaa")=4.
  For "bbb" (f=3): only f("aaaa")=4 > 3 → 1 word.
  For "cc" (f=2): f("aaa")=3 and f("aaaa")=4 > 2 → 2 words.
```

---

## Constraints

- `1 <= queries.length <= 2000`
- `1 <= words.length <= 2000`
- `1 <= queries[i].length, words[i].length <= 10`
- `queries[i][j]` and `words[i][j]` consist of lowercase English letters

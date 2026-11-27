# 2559. Count Vowel Strings in Ranges

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-vowel-strings-in-ranges/

---

## Problem Statement

You are given a **0-indexed** array of strings `words` and a 2D array of integers `queries`.

Each query `queries[i] = [l_i, r_i]` asks us to find the number of strings present at the indices ranging from `l_i` to `r_i` (both **inclusive**) of `words` that start and end with a vowel.

Return an array `ans` of size `queries.length`, where `ans[i]` is the answer to the `i`th query.

**Note** that the vowel letters are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.

---

## Examples

**Example 1:**
```
Input:  words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2,3,0]
```
*Explanation:* The strings starting and ending with a vowel are "aba", "ece", "aa" and "e". The answer to query [0,2] is 2 (strings "aba" and "ece"). To query [1,4] is 3 (strings "ece", "aa", "e"). To query [1,1] is 0.

**Example 2:**
```
Input:  words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
Output: [3,2,1]
```
*Explanation:* Every string satisfies the conditions, so we return [3,2,1].

---

## Constraints

- `1 <= words.length <= 10^5`
- `1 <= words[i].length <= 40`
- `words[i]` consists only of lowercase English letters.
- `sum(words[i].length) <= 3 * 10^5`
- `1 <= queries.length <= 10^5`
- `0 <= l_i <= r_i < words.length`

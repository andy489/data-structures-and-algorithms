# 3485. Longest Common Prefix of K Strings After Removal

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/longest-common-prefix-of-k-strings-after-removal/

---

## Problem Statement

You are given an array of strings `words` and an integer `k`.

For each index `i` in the range `[0, words.length - 1]`, find the **length** of the **longest common prefix** among any `k` strings (selected at **distinct indices**) from the remaining array after removing the `i`th element.

Return an array `answer`, where `answer[i]` is the answer for the `i`th element. If removing the `i`th element leaves the array with fewer than `k` strings, `answer[i]` is 0.

---

## Examples

**Example 1:**
```
Input: words = ["jump","run","run","jump","run"], k = 2
Output: [3,4,4,3,4]
```

**Example 2:**
```
Input: words = ["dog","racer","car"], k = 2
Output: [0,0,0]
```

---

## Constraints

- `1 <= k <= words.length <= 10^5`
- `1 <= words[i].length <= 10^4`
- `words[i]` consists of lowercase English letters.
- The total number of characters in `words` does not exceed `10^5`.

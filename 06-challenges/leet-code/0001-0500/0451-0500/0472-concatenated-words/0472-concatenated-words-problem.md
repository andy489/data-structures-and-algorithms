# 472. Concatenated Words

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/concatenated-words/

---

## Problem Statement

Given an array of strings `words` (**without duplicates**), return all the **concatenated words** in the given list of `words`.

A **concatenated word** is defined as a string that is comprised entirely of at least two shorter words (not necessarily distinct) in the given array.

---

## Examples

**Example 1:**
```
Input:  words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
```

**Example 2:**
```
Input:  words = ["cat","dog","catdog"]
Output: ["catdog"]
```

---

## Constraints

- `1 <= words.length <= 10^4`
- `1 <= words[i].length <= 30`
- `words[i]` consists of only lowercase English letters.
- All the strings of `words` are **unique**.
- `1 <= sum(words[i].length) <= 10^5`

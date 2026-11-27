# 833. Find And Replace in String

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-and-replace-in-string/

---

## Problem Statement

You are given a 0-indexed string `s` that you must perform `k` replacement operations on. The replacement operations are given three 0-indexed parallel arrays, `indices`, `sources` and `targets`, all of length `k`. To complete the `i`th replacement operation: check if the substring `sources[i]` occurs at index `indices[i]` of `s`. If it does, replace it with `targets[i]`. All replacement operations must occur simultaneously, meaning the replacements should not affect other operations.

Return the resulting string after performing all replacement operations.

---

## Examples

**Example 1:**
```
Input:  s = "abcd", indices = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
Output: "eeebffff"
```

---

## Constraints

- `1 <= s.length <= 1000`
- `k == indices.length == sources.length == targets.length`
- `1 <= k <= 100`
- `0 <= indices[i] < s.length`
- `1 <= sources[i].length, targets[i].length <= 50`

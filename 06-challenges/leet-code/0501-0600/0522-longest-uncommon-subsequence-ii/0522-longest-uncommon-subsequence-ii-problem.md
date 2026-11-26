# 522. Longest Uncommon Subsequence II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-uncommon-subsequence-ii/

---

## Problem Statement

Given an array of strings `strs`, return the length of the **longest uncommon subsequence** between them. If the longest uncommon subsequence does not exist, return `-1`.

An **uncommon subsequence** is a subsequence of exactly one string in the array.

A **subsequence** of a string is a string obtained by deleting some (possibly zero) characters without changing the remaining order.

---

## Examples

**Example 1:**
```
Input:  strs = ["aba","cdc","eae"]
Output: 3
```

**Example 2:**
```
Input:  strs = ["aaa","aaa","aa"]
Output: -1
```

---

## Constraints

- `2 <= strs.length <= 50`
- `1 <= strs[i].length <= 10`
- `strs[i]` consists of lowercase English letters.

# 1209. Remove All Adjacent Duplicates in String II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

---

## Problem Statement

You are given a string `s` and an integer `k`. A `k` duplicate removal consists of choosing `k` adjacent and equal letters from `s` and removing them, causing the left and the right parts of the string to concatenate together.

Repeatedly apply `k` duplicate removals on `s` until no more can be applied.

Return the final string after all such duplicate removals have been made.

---

## Examples

**Example 1:**
```
Input:  s = "deeedbbcccbdaa", k = 3
Output: "aa"
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `2 <= k <= 10^4`
- `s only contains lowercase English letters`

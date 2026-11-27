# 960. Delete Columns to Make Sorted III

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/delete-columns-to-make-sorted-iii/

---

## Problem Statement

You are given an array of `n` strings `strs`, all of the same length.

We may choose any deletion indices, and we delete all the characters in those positions for each string.

For example, if we have `strs = ["abcdef","uvwxyz"]` and deletion indices `{0, 2, 3}`, then the final array after deletions is `["bef","vyz"]`.

Suppose we chose a set of deletion indices `answer` such that after deletions, the final array of strings is in lexicographic order (each row of the resulting matrix is nondecreasing). Return the minimum possible value of `answer.length`.

---

## Examples

**Example 1:**
```
Input:  strs = ["babca","bbazb"]
Output: 3
```

**Example 2:**
```
Input:  strs = ["edcba"]
Output: 4
```

---

## Constraints

- `n == strs.length`
- `1 <= n <= 100`
- `1 <= strs[i].length <= 100`

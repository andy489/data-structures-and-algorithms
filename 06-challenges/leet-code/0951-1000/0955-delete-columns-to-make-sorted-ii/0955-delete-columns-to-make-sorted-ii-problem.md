# 955. Delete Columns to Make Sorted II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/delete-columns-to-make-sorted-ii/

---

## Problem Statement

You are given an array of `n` strings `strs`, all of the same length.

We may choose any deletion indices, and we delete all the characters in those positions for each string.

For example, if we have `strs = ["abcdef","uvwxyz"]` and deletion indices `{0, 2, 3}`, then the final array after deletions is `["bef","vyz"]`.

Suppose we chose a set of deletion indices `answer` such that after deletions, the final array of strings is in lexicographic order (i.e., `strs[0] <= strs[1] <= strs[2] <= ... <= strs[n - 1]`). Return the minimum possible value of `answer.length`.

---

## Examples

**Example 1:**
```
Input:  strs = ["ca","bb","ac"]
Output: 1
```

**Example 2:**
```
Input:  strs = ["xc","yb","za"]
Output: 0
```

---

## Constraints

- `n == strs.length`
- `1 <= n <= 100`
- `1 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters.

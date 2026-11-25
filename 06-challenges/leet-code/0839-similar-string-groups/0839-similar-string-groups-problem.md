# 839. Similar String Groups

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/similar-string-groups/

---

## Problem Statement

Two strings `X` and `Y` are similar if we can swap two letters in `X` to match `Y`. Two strings in an array are in the same group if one can be derived from the other through a sequence of swaps. Return the number of groups.

---

## Examples

**Example 1:**
```
Input:  strs = ["tars","rats","arts","star"]
Output: 2
```

**Example 2:**
```
Input:  strs = ["omv","ovm"]
Output: 1
```

---

## Constraints

- `1 <= strs.length <= 300`
- `1 <= strs[i].length <= 300`
- `strs[i]` consists of lowercase letters only.
- All words in `strs` have the same length and are anagrams of each other.

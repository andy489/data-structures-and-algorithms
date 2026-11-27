# 1487. Making File Names Unique

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/making-file-names-unique/

---

## Problem Statement

Given an array of folder names, return a unique set of folder names by appending (k) to duplicates.

---

## Examples

**Example 1:**
```
Input:  names=["pes","fifa","gta","pes(2019)"]
Output: ["pes","fifa","gta","pes(2019)"]
```

**Example 2:**
```
Input:  names=["gta","gta(1)","gta","avalon"]
Output: ["gta","gta(1)","gta(2)","avalon"]
```

---

## Constraints

- `1 <= names.length <= 5*10^4`
- `1 <= names[i].length <= 20`
- `names[i] contains lowercase letters, digits, and/or parentheses`

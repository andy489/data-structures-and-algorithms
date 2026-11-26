# 1233. Remove Sub-Folders from the Filesystem

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

---

## Problem Statement

Given a list of folders, remove all sub-folders in those folders and return only the folders after removing.

If a folder[i] is located within another folder[j], it is called a sub-folder of it. The format of a path is one or more concatenated strings of the form: `/` followed by one or more lowercase English letters.

Return the folders in any order.

---

## Examples

**Example 1:**
```
Input:  folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
Output: ["/a","/c/d","/c/f"]
```

---

## Constraints

- `1 <= folder.length <= 4*10^4`
- `2 <= folder[i].length <= 100`
- `folder[i] contains only lowercase letters and '/'`
- `folder[i] always starts with the character '/'`
- `Each folder name is unique`

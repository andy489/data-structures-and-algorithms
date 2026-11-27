# 609. Find Duplicate File in System

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-duplicate-file-in-system/

---

## Problem Statement

Given a list `paths` of directory info, including the directory path, and all the files with contents in this directory, return all the duplicate files in the file system in terms of their paths. You may return the answer in **any order**.

A group of duplicate files consists of at least two files that have the same content.

A single directory info string in the `paths` input list is formatted as: `"root/d1/d2/.../dk f1.txt(f1_content) f2.txt(f2_content) ..."`.

It means there are `k` files (`f1.txt`, `f2.txt`, ...) in the directory `root/d1/d2/.../dk`. The input format for a single file is `fi.txt(fi_content)`. Both the file name and content contain only letters and digits. You are guaranteed that the number of unique content strings across all files will be less than or equal to `20000`.

---

## Examples

**Example 1:**
```
Input:  paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
```

**Example 2:**
```
Input:  paths = ["root/a 1.txt(abcd)","root/c 2.txt(efgh)"]
Output: []
```

---

## Constraints

- `1 <= paths.length <= 2 * 10^4`
- `1 <= paths[i].length <= 3000`
- `1 <= sum(paths[i].length) <= 5 * 10^5`
- `paths[i]` consist of English letters, digits, `'/'`, `'.'`, `'('`, `')'`, and `' '`
- You may assume no files or directories share the same name in the same directory
- You may assume each given directory info represents a unique directory

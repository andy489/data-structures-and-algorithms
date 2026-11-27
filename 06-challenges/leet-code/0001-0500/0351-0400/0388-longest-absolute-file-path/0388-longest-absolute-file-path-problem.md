# 388. Longest Absolute File Path

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-absolute-file-path/

---

## Problem Statement

Suppose we have a file system that stores both files and directories. The file system is represented as a string where `\n` denotes a new line and `\t` denotes a tab (indicating depth).

The length of the absolute path is the number of characters including the `/` separators.

Return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return `0`.

**Note:** The name of a file contains at least a `.` and an extension.

---

## Examples

**Example 1:**
```
Input:  input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
Output: 20
Explanation: The path is "dir/subdir2/file.ext" with length 20.
```

**Example 2:**
```
Input:  input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
Output: 32
Explanation: The path is "dir/subdir2/subsubdir2/file2.ext" with length 32.
```

---

## Constraints

- `1 <= input.length <= 10^4`
- `input` may contain lowercase or uppercase English letters, a new line character `\n`, a tab character `\t`, a dot `.`, a space ` `, and digits.
- All file and directory names have positive length.

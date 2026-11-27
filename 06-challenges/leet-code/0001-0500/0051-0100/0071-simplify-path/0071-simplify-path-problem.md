# 71. Simplify Path

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/simplify-path/

---

## Problem Statement

You are given an absolute path for a Unix-style file system, which always begins with a slash `'/'`. Your task is to transform this absolute path into its **simplified canonical path**.

The rules of a Unix-style file system are as follows:

- A single period `'.'` represents the current directory.
- A double period `'..'` represents the previous/parent directory.
- Multiple consecutive slashes such as `'//'` and `'///'` are treated as a single slash `'/'`.
- Any other format of periods such as `'...'` are treated as valid directory or file names.

The simplified canonical path should follow these rules:

- The path must start with a single slash `'/'`.
- Directories within the path must be separated by exactly one slash `'/'`.
- The path must not end with a slash `'/'`, unless it is the root directory.
- The path must not have any single or double periods (`'.'` and `'..'`) used to denote current or parent directories.

Return the simplified canonical path.

---

## Examples

**Example 1:**
```
Input:  path = "/home/"
Output: "/home"
```

**Example 2:**
```
Input:  path = "/home//foo/"
Output: "/home/foo"
```

**Example 3:**
```
Input:  path = "/home/user/Documents/../Pictures"
Output: "/home/user/Pictures"
```

**Example 4:**
```
Input:  path = "/../"
Output: "/"
```

**Example 5:**
```
Input:  path = "/.../a/../b/c/../d/./"
Output: "/.../b/d"
```

---

## Constraints

- `1 <= path.length <= 3000`
- `path` consists of English letters, digits, period `'.'`, slash `'/'` or `'_'`.
- `path` is a valid absolute Unix path.

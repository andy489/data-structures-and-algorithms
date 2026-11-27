# 722. Remove Comments

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-comments/

---

## Problem Statement

Given a C++ program, remove comments from it. The program `source` is an array where `source[i]` is the `i`th line of the source code. This represents the result of splitting the original source code string by the newline character `\n`.

In C++, there are two types of comments, line comments, and block comments.

- The string `//` denotes a line comment, which represents that it and the rest of the characters to the right of it in the same line should be ignored.
- The string `/*` denotes a block comment, which represents that until the next `*/`, all characters until and including the `*/` should be ignored. (The first effective `*/` found from the character right after the `/*` will end the block comment.) If there is no terminating `*/`, the block comment may span until the end of the file, in which case the program is still valid.

The first effective comment takes precedence over others.

After removing the comments from the source code, return the source code in the same format.

---

## Examples

**Example 1:**
```
Input:  source = ["/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "int d = b + c;", "}"]
Output: ["int main()","{ ","  ","int a, b, c;","int d = b + c;","}"]
```

---

## Constraints

- `1 <= source.length <= 100`
- `0 <= source[i].length <= 80`
- `source[i]` consists of printable ASCII characters.
- Every open block comment is eventually closed.
- There are no single-quote or double-quote in the input.

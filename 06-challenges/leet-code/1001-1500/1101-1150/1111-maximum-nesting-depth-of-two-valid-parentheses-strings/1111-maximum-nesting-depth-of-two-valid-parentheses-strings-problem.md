# 1111. Maximum Nesting Depth of Two Valid Parentheses Strings

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/

---

## Problem Statement

A string is a valid parentheses string (VPS) if it meets one of the following:

- It is an empty string `""`, or a single character not equal to `"("` or `")"`.
- It can be written as `AB` (A concatenated with B), where A and B are VPS.
- It can be written as `(A)`, where A is a VPS.

We can similarly define the nesting depth `depth(S)` of a VPS `S` as follows:

- `depth("") == 0`
- `depth(C) == 0`, where C is a string with a single character not equal to `"("` or `")"`.
- `depth(A + B) == max(depth(A), depth(B))`, where A and B are VPS strings.
- `depth("(" + A + ")") == 1 + depth(A)`, where A is a VPS.

Given a VPS `seq`, split it into two disjoint subsequences `A` and `B`, where every character in `seq` is in exactly one of `A` or `B`, such that the maximum of `depth(A)` and `depth(B)` is minimized.

Return an `answer` array where `answer[i] == 0` if `seq[i]` is assigned to `A`, and `answer[i] == 1` if `seq[i]` is assigned to `B`.

---

## Examples

**Example 1:**
```
Input:  seq = "(()())"
Output: [0, 1, 1, 1, 1, 0]
```

**Example 2:**
```
Input:  seq = "()(())()"
Output: [0, 0, 0, 1, 1, 0, 1, 1]
```

---

## Constraints

- `1 <= seq.size <= 10000`
- `seq` is a valid parentheses string.

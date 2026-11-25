# 1023. Camelcase Matching

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/camelcase-matching/

---

## Problem Statement

Given an array of strings `queries` and a string `pattern`, return a boolean array `answer` where `answer[i]` is `true` if `queries[i]` matches `pattern`.

A query word `queries[i]` matches `pattern` if you can insert lowercase English letters into `pattern` to match it.

---

## Examples

**Example 1:**
```
Input:  queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]
```

---

## Constraints

- `1 <= pattern.length, queries.length <= 100`
- `1 <= queries[i].length <= 100`
- `queries[i]` and `pattern` consist of English letters.

# 946. Validate Stack Sequences

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/validate-stack-sequences/

---

## Problem Statement

Given two integer arrays `pushed` and `popped` each with distinct values, return `true` if this could have been the result of a sequence of push and pop operations on an initially empty stack, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
```

**Example 2:**
```
Input:  pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
```

---

## Constraints

- `1 <= pushed.length <= 1000`
- `0 <= pushed[i] <= 1000`
- All the elements of `pushed` are **unique**.
- `popped.length == pushed.length`
- `popped` is a permutation of `pushed`.

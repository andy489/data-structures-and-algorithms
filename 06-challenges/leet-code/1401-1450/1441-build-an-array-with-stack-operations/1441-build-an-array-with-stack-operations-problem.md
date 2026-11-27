# 1441. Build An Array With Stack Operations

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/build-an-array-with-stack-operations/

---

## Problem Statement

Given `target` (sorted unique positive integers) and `n`, return the sequence of push/pop operations using a stack filled with 1..n to get `target`.

---

## Examples

**Example 1:**
```
Input:  target=[1,3],n=3
Output: ["Push","Push","Pop","Push"]
```

**Example 2:**
```
Input:  target=[1,2,3],n=3
Output: ["Push","Push","Push"]
```

---

## Constraints

- `1 <= target.length <= 100`
- `1 <= target[i] <= n`
- `target is strictly increasing`
- `1 <= n <= 100`

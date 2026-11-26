# 2053. Kth Distinct String in an Array

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/kth-distinct-string-in-an-array/

---

## Problem Statement

A **distinct** string is one that appears exactly once in the array. Given `arr` and integer `k`, return the `k`-th distinct string from left to right, or `""` if fewer than `k` distinct strings exist.

---

## Examples

**Example 1:**
```
Input:  arr = ["d","b","c","b","c","a"], k = 2
Output: "a"
```
Explanation: Distinct: 'd','a'. 2nd is 'a'.

**Example 2:**
```
Input:  arr = ["aaa","aa","a"], k = 1
Output: "aaa"
```

**Example 3:**
```
Input:  arr = ["a","b","a"], k = 3
Output: ""
```
Explanation: Only 'b' is distinct.

---

## Constraints

- `1 <= k <= arr.length <= 1000`
- `1 <= arr[i].length <= 5`
- `arr[i] consists of lowercase English letters.`

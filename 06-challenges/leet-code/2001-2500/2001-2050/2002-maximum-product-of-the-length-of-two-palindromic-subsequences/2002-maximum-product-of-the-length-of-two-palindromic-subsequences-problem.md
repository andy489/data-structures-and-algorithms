# 2002. Maximum Product of the Length of Two Palindromic Subsequences

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/

---

## Problem Statement

Given a string `s`, find two **disjoint palindromic subsequences** of `s` such that the product of their lengths is **maximized**. The two subsequences are disjoint if they do not both pick characters at the same index. Return the **maximum** possible product of the lengths.

---

## Examples

**Example 1:**
```
Input:  s = "leetcodecom"
Output: 9
```
Explanation: Choose subsequences "ete" and "cdc": lengths 3 × 3 = 9.

**Example 2:**
```
Input:  s = "bb"
Output: 1
```
Explanation: Choose "b" and "b": 1 × 1 = 1.

**Example 3:**
```
Input:  s = "accbcaxxcxx"
Output: 25
```
Explanation: Choose "accca" and "xxxxx": 5 × 5 = 25.

---

## Constraints

- `2 <= s.length <= 12`
- `s consists of lowercase English letters.`

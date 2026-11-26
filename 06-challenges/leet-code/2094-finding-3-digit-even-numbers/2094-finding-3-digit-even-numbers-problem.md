# 2094. Finding 3-Digit Even Numbers

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/finding-3-digit-even-numbers/

---

## Problem Statement

You are given an integer array `digits`, where each element is a digit. Return a sorted unique list of all the 3-digit even integers that can be formed using each of the given digits **at most once** in each integer. 3-digit numbers start from 100.

---

## Examples

**Example 1:**
```
Input:  digits = [2,1,3,0]
Output: [102,120,130,132,210,230,302,310,312,320]
```

**Example 2:**
```
Input:  digits = [2,2,8,8,2]
Output: [222,228,282,288,822,828,882]
```

**Example 3:**
```
Input:  digits = [3,7,5]
Output: []
```
Explanation: No even numbers possible.

---

## Constraints

- `3 <= digits.length <= 100`
- `0 <= digits[i] <= 9`

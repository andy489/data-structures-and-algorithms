# 667. Beautiful Arrangement II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/beautiful-arrangement-ii/

---

## Problem Statement

Given two integers `n` and `k`, construct a list which contains all integers from `1` to `n` and obeys the following requirement:

Suppose this list is `answer = [a1, a2, a3, ... , an]`, then the list `[|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|]` has exactly `k` distinct integers.

Return the constructed list. If there are multiple valid answers, return **any of them**.

---

## Examples

**Example 1:**
```
Input:  n = 3, k = 1
Output: [1,2,3]
Explanation: The [|1-2|, |2-3|] list is [1, 1], which has only 1 distinct integer.
```

**Example 2:**
```
Input:  n = 3, k = 2
Output: [1,3,2]
Explanation: The [|1-3|, |3-2|] list is [2, 1], which has 2 distinct integers.
```

---

## Constraints

- `1 <= k < n <= 10⁴`

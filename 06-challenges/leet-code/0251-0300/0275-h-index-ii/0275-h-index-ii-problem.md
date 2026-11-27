# 275. H-Index II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/h-index-ii/

---

## Problem Statement

Given an array of integers `citations` where `citations` is sorted in **ascending order**, and `citations[i]` is the number of citations a researcher received for their `i`th paper, return the researcher's **h-index**.

The **h-index** is defined as the maximum value of `h` such that the given researcher has published at least `h` papers that have each been cited at least `h` times.

You must write an algorithm that runs in logarithmic time.

---

## Examples

**Example 1:**
```
Input:  citations = [0,1,3,5,6]
Output: 3
Explanation: The researcher has 3 papers with at least 3 citations.
```

**Example 2:**
```
Input:  citations = [1,2,100]
Output: 2
```

---

## Constraints

- `n == citations.length`
- `1 <= n <= 10^5`
- `0 <= citations[i] <= 1000`
- `citations` is sorted in **ascending order**.

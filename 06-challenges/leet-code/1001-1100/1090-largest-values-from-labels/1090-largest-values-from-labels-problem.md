# 1090. Largest Values From Labels

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-values-from-labels/

---

## Problem Statement

There is a set of `n` items. You are given two integer arrays `values` and `labels` where the value and the label of the `i`th element are `values[i]` and `labels[i]` respectively. You are also given two integers `numWanted` and `useLimit`.

Choose a subset `s` of the `n` elements such that:
- The size of the subset `s` is at most `numWanted`.
- There are at most `useLimit` items with the same label in `s`.

Return the maximum sum of the values of the chosen elements.

---

## Examples

**Example 1:**
```
Input:  values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
Output: 9
```

**Example 2:**
```
Input:  values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
Output: 12
```

---

## Constraints

- `n == values.length == labels.length`
- `1 <= n <= 2 * 10^4`
- `0 <= values[i], labels[i] <= 2 * 10^4`
- `1 <= numWanted, useLimit <= n`

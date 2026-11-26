# 2064. Minimized Maximum of Products Distributed to Any Store

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/

---

## Problem Statement

You have `n` specialty retail stores and `quantities[i]` products of type `i`. Distribute all products such that each store gets at most one type and each quantity is split among stores. Minimize the maximum quantity any store gets.

---

## Examples

**Example 1:**
```
Input:  n = 6, quantities = [11,6]
Output: 3
```
Explanation: Split 11 into [3,3,3,2] (4 stores), 6 into [3,3] (2 stores). Max=3.

**Example 2:**
```
Input:  n = 7, quantities = [15,10,10]
Output: 5
```

**Example 3:**
```
Input:  n = 1, quantities = [100000]
Output: 100000
```

---

## Constraints

- `m == quantities.length`
- `1 <= m <= n <= 10^5`
- `1 <= quantities[i] <= 10^5`

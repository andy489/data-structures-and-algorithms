# 879. Profitable Schemes

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/profitable-schemes/

---

## Problem Statement

There is a group of `n` members, and a list of various crimes they could commit. The `i`th crime generates a `profit[i]` and requires `group[i]` members to participate in it.

A scheme is any subset of these crimes that generates at least `minProfit` profit, and the total number of members participating in that subset of crimes is at most `n`.

Return the number of schemes that can be chosen. Since the answer may be very large, return it modulo `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  n = 5, minProfit = 3, group = [2,2], profit = [2,3]
Output: 2
```

**Example 2:**
```
Input:  n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
Output: 7
```

---

## Constraints

- `1 <= n <= 100`
- `0 <= minProfit <= 100`
- `1 <= group.length <= 100`
- `1 <= group[i] <= 100`
- `0 <= profit[i] <= 100`

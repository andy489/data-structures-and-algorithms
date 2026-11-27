# 1029. Two City Scheduling

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/two-city-scheduling/

---

## Problem Statement

A company is planning to interview `2n` people. Given the array `costs` where `costs[i] = [aCosti, bCosti]`, the cost of flying the `i`th person to city `a` is `aCosti`, and the cost of flying the `i`th person to city `b` is `bCosti`.

Return the minimum cost to fly every person to a city such that exactly `n` people arrive in each city.

---

## Examples

**Example 1:**
```
Input:  costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110
```

---

## Constraints

- `2 * n == costs.length`
- `2 <= costs.length <= 100`
- `costs.length` is even.
- `1 <= aCosti, bCosti <= 1000`

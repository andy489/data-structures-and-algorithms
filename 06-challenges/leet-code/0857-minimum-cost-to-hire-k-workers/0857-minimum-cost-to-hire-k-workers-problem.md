# 857. Minimum Cost to Hire K Workers

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-cost-to-hire-k-workers/

---

## Problem Statement

There are `n` workers. You are given two integer arrays `quality` and `wage` where `quality[i]` is the quality of the `i`th worker and `wage[i]` is the minimum wage expectation of the `i`th worker.

We want to hire exactly `k` workers to form a paid group. To hire a group of `k` workers, we must pay them according to the following rules:
1. Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
2. Every worker in the paid group must be paid at least their minimum wage expectation.

Return the least amount of money needed to form a paid group of size `k`. Answers within `10^-5` of the actual answer will be accepted.

---

## Examples

**Example 1:**
```
Input:  k = 2, quality = [3,1,10,10,1], wage = [4,8,2,2,7]
Output: 30.66667
```

**Example 2:**
```
Input:  k = 3, quality = [3,1,10,10,1], wage = [4,8,2,2,7]
Output: 30.66667
```

---

## Constraints

- `n == quality.length == wage.length`
- `1 <= k <= n <= 10^4`
- `1 <= quality[i] <= 10^4`
- `1 <= wage[i] <= 10^4`

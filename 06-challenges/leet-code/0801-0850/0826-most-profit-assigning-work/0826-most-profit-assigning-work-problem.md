# 826. Most Profit Assigning Work

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/most-profit-assigning-work/

---

## Problem Statement

You have `n` jobs and `m` workers. You are given three arrays: `difficulty`, `profit`, and `worker` where `difficulty[i]` and `profit[i]` are the difficulty and profit of the `i`th job, and `worker[j]` is the ability of the `j`th worker. Each worker can be assigned at most one job, and they can only complete jobs with difficulty ≤ their ability.

Return the maximum profit we can achieve.

---

## Examples

**Example 1:**
```
Input:  difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
Output: 100
```

---

## Constraints

- `n == difficulty.length == profit.length`
- `m == worker.length`
- `1 <= n, m <= 10^4`
- `1 <= difficulty[i], profit[i] <= 10^5`
- `1 <= worker[i] <= 10^5`

# 3075. Maximize Happiness Of Selected Children

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximize-happiness-of-selected-children/

---

## Problem Statement

You are given an array `happiness` of length `n` and a positive integer `k`.

There are `n` children standing in a queue, each with a happiness value. You can select exactly `k` children from the queue. When you select the ith child, all children before them in the queue lose 1 happiness each. At each step, you pick the child that maximizes the remaining happiness.

Return the maximum sum of happiness values after selecting k children.

Note that the happiness value of a child can become negative.

---

## Examples

**Example 1:**
```
Input:  happiness = [1,2,3], k = 2
Output: 4
```
Explanation: Select child with happiness 3 (contribution 3), then 2-1=1. Sum=4.

**Example 2:**
```
Input:  happiness = [1,1,1,1], k = 2
Output: 1
```
Explanation: Select 1 (contribution 1), then 1-1=0. Sum=1.

---

## Constraints

- `1 <= n == happiness.length <= 2 * 10^5`
- `1 <= happiness[i] <= 10^8`
- `1 <= k <= n`

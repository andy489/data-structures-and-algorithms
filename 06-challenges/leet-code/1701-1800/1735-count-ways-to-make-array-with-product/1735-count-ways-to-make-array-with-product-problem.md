# 1735. Count Ways to Make Array with Product

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-ways-to-make-array-with-product/

---

## Problem Statement

You are given a 2D integer array, `queries`. For each `queries[i] = [ni, ki]`, find the number of different ways you can place positive integers into an array of size `ni` such that the product of the integers is `ki`. As the answer may be too large, the answer for each query should be computed **modulo** `10^9 + 7`.

Return *an integer array* `answer` *where* `answer[i]` *is the answer to the* `i`th *query.*

The different ways that you can distribute `ki` among `ni` positive integers can be thought of as the number of ways to distribute `ki`'s prime factors among `ni` slots.

---

## Examples

**Example 1:**
```
Input: queries = [[2,6],[5,1],[73,660]]
Output: [4,1,50734910]
Explanation:
  [2,6]: [1,6],[2,3],[3,2],[6,1] → 4 ways
  [5,1]: [1,1,1,1,1] → 1 way
  [73,660]: answer mod 10^9+7
```

**Example 2:**
```
Input: queries = [[1,1],[2,2],[3,3],[4,4],[5,5]]
Output: [1,2,3,10,5]
```

---

## Constraints

- `1 <= queries.length <= 10^4`
- `1 <= ni, ki <= 10^4`

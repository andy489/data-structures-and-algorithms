# 3946. Maximum Number of Items From Sale I

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-items-from-sale-i/

---

## Problem Statement

You are given a 2D integer array `items`, where `items[i] = [factor_i, price_i]` represents the i-th item. You are also given an integer `budget`.

There are unlimited copies of each item available for purchase. You may buy any number of copies of any items such that the total cost of the purchased copies is at most `budget`.

After buying items, you may receive free copies according to the following rules:

- For each item `i` that you bought at least one copy of, you receive one free copy of every item `j` such that `j != i` and `factor_i` divides `factor_j`.
- Buying multiple copies of the same item `i` does not give additional free copies through item `i`.
- The same item `j` can be received multiple times for free if it is received from purchases of different item types.

Return the maximum total number of item copies you can obtain, including both purchased copies and free copies, while spending at most `budget` on purchased items.

---

## Examples

**Example 1:**
```
Input:  items = [[6,2],[2,6],[3,4]], budget = 9
Output: 4
```
Explanation: Buy 2 copies of item 0 and 1 copy of item 2 (cost = 2*2 + 4 = 8). Buying item 2 gives 1 free copy of item 0 (3 divides 6). Total: 3 purchased + 1 free = 4.

**Example 2:**
```
Input:  items = [[2,4],[3,2],[4,1],[6,4],[12,4]], budget = 8
Output: 10
```
Explanation: Buy 1 copy of item 0, 1 of item 1, 2 copies of item 2 (cost = 4+2+2 = 8). Item 0 gives 3 free copies, item 1 gives 2 free, item 2 gives 1 free — total 6 free. Total: 4 + 6 = 10.

---

## Constraints

- `1 <= items.length <= 1000`
- `items[i] = [factor_i, price_i]`
- `1 <= factor_i, price_i <= 1500`
- `1 <= budget <= 1500`

# 1711. Count Good Meals

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-good-meals/

---

## Problem Statement

A **good meal** is a meal that contains **exactly two different food items** with a sum of deliciousness equal to a power of two.

You can pick **any** two different foods to make a good meal.

Given an array of integers `deliciousness` where `deliciousness[i]` is the deliciousness of the `i`th item of food, return the number of different **good meals** you can make from this list modulo `10^9 + 7`.

Note that items with different indices are considered different even if they have the same deliciousness value.

---

## Examples

**Example 1:**
```
Input: deliciousness = [1,3,5,7,9]
Output: 4
Explanation: Good meals are (1,3), (1,7), (3,5), (7,9) with sums 4, 8, 8, 16.
```

**Example 2:**
```
Input: deliciousness = [1,1,1,3,3,3,7]
Output: 15
Explanation: Good meals are (1,1) with 3 ways, (1,3) with 9 ways, (1,7) with 3 ways.
```

---

## Constraints

- `1 <= deliciousness.length <= 10^5`
- `0 <= deliciousness[i] <= 2^20`

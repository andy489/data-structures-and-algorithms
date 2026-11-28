# 2944. Minimum Number of Coins for Fruits

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-coins-for-fruits/

---

## Problem Statement

You are given an **0-indexed** integer array `prices` where `prices[i]` denotes the number of coins needed to purchase the `(i + 1)`th fruit.

The fruit market has the following reward for each fruit:

- If you purchase the `(i + 1)`th fruit at `prices[i]` coins, you can get any number of the next `i` fruits for free.

**Note** that even if you **can** take fruit `j` for free, you can still purchase it for `prices[j - 1]` coins to receive its reward.

Return the **minimum** number of coins needed to acquire all the fruits.

---

## Examples

**Example 1:**
```
Input: prices = [3,1,2]
Output: 4
Explanation: Purchase fruit 1 (cost 3), take fruit 2 for free, purchase fruit 2 (cost 1), take fruit 3 for free.
```

**Example 2:**
```
Input: prices = [1,10,1,1]
Output: 2
```

**Example 3:**
```
Input: prices = [26,18,6,12,49,7,45,45]
Output: 39
```

---

## Constraints

- `1 <= prices.length <= 1000`
- `1 <= prices[i] <= 10^5`

# 638. Shopping Offers

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shopping-offers/

---

## Problem Statement

In LeetCode store, there are `n` items to sell. Each item has a price. However, there are some special offers, and a special offer consists of one or more different kinds of items with a price less than the sum of the items' prices.

You are given an integer array `price` where `price[i]` is the price of the `i`th item, and an integer array `special` where `special[i]` is of size `n + 1` where `special[i][j]` is the number of the `j`th item in the `i`th special offer and `special[i][n]` (the last integer in the array) is the price of the `i`th special offer.

You are also given an integer array `needs` where `needs[i]` is the number of the `i`th item you need to buy.

The function returns the minimum cost to buy exactly `needs` items using any number of special offers.

---

## Examples

**Example 1:**
```
Input:  price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
Output: 14
```

**Example 2:**
```
Input:  price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
Output: 11
```

---

## Constraints

- `n == price.length == needs.length`
- `1 <= n <= 6`
- `0 <= price[i], needs[i] <= 10`
- `1 <= special.length <= 100`
- `special[i].length == n + 1`
- `0 <= special[i][j] <= 10`

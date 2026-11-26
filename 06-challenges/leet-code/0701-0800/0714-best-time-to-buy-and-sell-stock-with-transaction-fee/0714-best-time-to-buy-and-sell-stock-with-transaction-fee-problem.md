# 714. Best Time to Buy and Sell Stock with Transaction Fee

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

---

## Problem Statement

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day, and an integer `fee` representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

**Note:** You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

---

## Examples

**Example 1:**
```
Input:  prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: Buy at 1, sell at 8 (profit 5), buy at 4, sell at 9 (profit 3). Total = 8.
```

**Example 2:**
```
Input:  prices = [1,3,7,5,10,3], fee = 3
Output: 6
```

---

## Constraints

- `1 <= prices.length <= 5 * 10^4`
- `1 <= prices[i] < 10^4`
- `0 <= fee < 10^4`

# 1599. Maximum Profit of Operating a Centennial Wheel

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/

---

## Problem Statement

You are the operator of a Centennial Wheel that has **four gondolas**, and each gondola has room for **up** **to** **four people**. You have the ability to rotate the gondolas **counterclockwise**, which costs you `runningCost` dollars.

You are given an array `customers` of length `n` where `customers[i]` is the number of new customers arriving just before the `i`th rotation (0-indexed). This means you **must rotate the wheel** `i` **times before the** `i`th **batch of customers is served**. **Each customer pays** `boardingCost` **dollars when they board**. You may stop the wheel at any time.

**Note** that if there are currently more than four customers waiting at the wheel, only four will board the gondola, and the rest will wait **for the next rotation**.

Return the minimum number of rotations you need to perform to maximize your profit. If there is **no scenario** where the profit is positive, return `-1`.

---

## Examples

**Example 1:**
```
Input:  customers = [8,3], boardingCost = 5, runningCost = 6
Output: 3
```

**Example 2:**
```
Input:  customers = [10,9,6], boardingCost = 6, runningCost = 4
Output: 7
```

**Example 3:**
```
Input:  customers = [3,4,0,5,1], boardingCost = 1, runningCost = 92
Output: -1
```

---

## Constraints

- `n == customers.length`
- `1 <= n <= 10^5`
- `0 <= customers[i] <= 50`
- `1 <= boardingCost, runningCost <= 100`

# 2079. Watering Plants

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/watering-plants/

---

## Problem Statement

You have `n` plants in a row, labeled `0` to `n-1`. `plants[i]` is the water needed. You have a watering can of capacity `capacity`. You start at the river (position -1). Go right, watering each plant; if the can doesn't have enough, return to the river to refill. Return total steps walked.

---

## Examples

**Example 1:**
```
Input:  plants = [2,2,3,3], capacity = 5
Output: 14
```

**Example 2:**
```
Input:  plants = [1,1,1,4,2,3], capacity = 4
Output: 30
```

**Example 3:**
```
Input:  plants = [7,7,7,7,7,7,7], capacity = 8
Output: 49
```

---

## Constraints

- `n == plants.length`
- `1 <= n <= 1000`
- `1 <= plants[i] <= 10^6`
- `max(plants[i]) <= capacity <= 10^9`

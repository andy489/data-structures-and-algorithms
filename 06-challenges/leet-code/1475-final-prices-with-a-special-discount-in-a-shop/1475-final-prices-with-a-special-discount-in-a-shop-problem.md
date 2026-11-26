# 1475. Final Prices With A Special Discount In A Shop

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

---

## Problem Statement

Return prices after applying a special discount: for each item, the first later item with price <= current item is the discount.

---

## Examples

**Example 1:**
```
Input:  prices=[8,4,6,2,3]
Output: [4,2,4,2,3]
```

**Example 2:**
```
Input:  prices=[1,2,3,4,5]
Output: [1,2,3,4,5]
```

**Example 3:**
```
Input:  prices=[10,1,1,6]
Output: [9,0,1,6]
```

---

## Constraints

- `1 <= prices.length <= 500`
- `1 <= prices[i] <= 1000`

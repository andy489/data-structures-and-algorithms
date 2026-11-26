# 1418. Display Table Of Food Orders In A Restaurant

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/

---

## Problem Statement

Return a display table sorted by table number, with food items sorted alphabetically, showing order counts.

---

## Examples

**Example 1:**
```
Input:  orders=[["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Corina","2","Ceviche"],["Corina","5","Fried Chicken"],["Corina","3","Ceviche"]]
Output: [["Table","Beef Burrito","Ceviche","Fried Chicken"],["2","0","1","0"],["3","0","2","1"],["5","0","1","1"],["10","1","0","0"]]
```

---

## Constraints

- `1 <= orders.length <= 5*10^4`
- `orders[i].length == 3`

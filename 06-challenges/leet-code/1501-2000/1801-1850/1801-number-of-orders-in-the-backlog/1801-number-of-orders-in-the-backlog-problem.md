# 1801. Number of Orders in the Backlog

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-orders-in-the-backlog/

---

## Problem Statement

You are given a 2D integer array `orders`, where each `orders[i] = [price_i, amount_i, orderType_i]` denotes that `amount_i` orders have been placed of type `orderType_i` at the price `price_i`. The `orderType_i` is either `0` (buy order) or `1` (sell order).

There is a backlog that consists of orders that have not been fulfilled yet. The backlog is initially empty. When an order is placed, the following happens:

- If the order is a **buy** order, you look at the sell order with the **smallest** price in the backlog. If that sell price is **smaller than or equal to** the current buy price, they will match and be fulfilled. This repeats until there are no more matches or the buy order is fulfilled.
- Else, if the order is a **sell** order, you look at the buy order with the **largest** price in the backlog. If that buy price is **larger than or equal to** the current sell price, they will match and be fulfilled. This repeats until there are no more matches or the sell order is fulfilled.
- If the order is not fulfilled after matching, it is added to the backlog.

Return the **total amount** of orders in the backlog after placing all the orders from the input. Since this number can be large, return it modulo `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input: orders = [[10,5,0],[15,2,1],[25,1,1],[30,4,0]]
Output: 6
Explanation:
- Place buy 10 x5 → backlog buy: {10:5}
- Place sell 15 x2 → no match (15>10), backlog sell: {15:2}
- Place sell 25 x1 → backlog sell: {15:2, 25:1}
- Place buy 30 x4 → matches sell at 15 (2 orders), matches sell at 25 (1 order), remaining buy 1 at 30
- Total: buy backlog {10:5, 30:1} = 6, sell backlog empty. Total = 6.
```

**Example 2:**
```
Input: orders = [[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]
Output: 999999984
Explanation: After processing all orders, total modulo 10^9+7 = 999999984.
```

---

## Constraints

- `1 <= orders.length <= 10^5`
- `orders[i].length == 3`
- `1 <= price_i <= 10^9`
- `1 <= amount_i <= 10^9`
- `orderType_i` is either `0` or `1`

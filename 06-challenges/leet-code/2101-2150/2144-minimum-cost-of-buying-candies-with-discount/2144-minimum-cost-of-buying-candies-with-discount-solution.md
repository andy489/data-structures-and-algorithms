# 2144. Minimum Cost of Buying Candies With Discount — Solution

## Approach: Greedy with Sorting

**Key insight:** To minimize cost, we want to get the most expensive possible candy for free. By sorting in descending order, every 3rd candy (at index 2, 5, 8...) is the cheapest among its group of three, satisfying the discount rule (free candy cost ≤ minimum of the two paid).

**Algorithm:**
1. Sort `cost` in descending order.
2. Skip every 3rd element (indices 2, 5, 8...) — those are the free ones.
3. Sum the remaining elements.

This is optimal because we always skip the cheapest candy in each group of three, maximizing the total savings.

## Complexity

| | Time | Space |
|---|---|---|
| Sorting | O(n log n) | O(1) |
| Summation | O(n) | O(1) |
| **Total** | **O(n log n)** | **O(1)** |

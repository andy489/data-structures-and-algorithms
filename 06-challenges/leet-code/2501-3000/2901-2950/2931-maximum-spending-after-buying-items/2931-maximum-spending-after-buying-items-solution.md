# 2931. Maximum Spending After Buying Items — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-spending-after-buying-items/

---

## Solution: Greedy Sort — O(m·n·log(m·n)) time, O(m·n) space

**Idea:** To maximize total spending, assign larger day multipliers to larger item values. Since items in each shop are sorted non-increasing, the rightmost item in each shop is always the cheapest currently available from that shop. Flatten all items into a single sorted array and assign day 1, 2, ..., m*n in order (smallest value gets day 1, largest gets day m*n).

**Algorithm:**
1. Collect all values from all shops into a single array.
2. Sort the array in non-decreasing order.
3. The answer is sum of `sortedValues[i] * (i + 1)` for all `i`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n·log(m·n)) |
| Space | O(m·n) |

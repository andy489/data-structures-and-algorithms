# 3457. Eat Pizzas! — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/eat-pizzas/

---

## Solution: Greedy with Sorting — O(n log n) time, O(1) space

**Idea:** Sort pizzas in ascending order. There are n/4 days total. Let odd = ceil(days/2) days be odd days (gain max = Z), even = floor(days/2) days be even days (gain 2nd max = Y). On odd days we always take the global maximum available, on even days we take the 2nd maximum. To maximize total weight, greedily assign the largest pizzas to odd days (take index n-1, n-5, n-9...) and next-largest to even days (take index n-2, n-6, n-10...).

**Algorithm:**
1. Sort pizzas ascending.
2. Compute odd = (n/4 + 1) / 2 days (1-indexed odd days), even = n/4 - odd days.
3. For odd days, take from the right end (largest): indices n-1, n-5, ...
4. For even days, take from just below: indices n-2, n-6, ...
5. Sum all taken values.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |

# 1196. How Many Apples Can You Put into the Basket — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/

---

## Solution: Sort and Greedy — O(n log n) time, O(1) space

**Idea:** Sort apples by weight ascending. Pick smallest first until capacity exceeded.

**Algorithm:**
1. Sort weight.
2. Greedily add from lightest until total > 5000.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |

# 1052. Grumpy Bookstore Owner — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/grumpy-bookstore-owner/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Base satisfaction = sum where grumpy=0. Find window of size `minutes` maximizing extra customers rescued (grumpy=1 → satisfied).

**Algorithm:**
1. Compute base = sum of customers where grumpy=0.
2. Slide window of size `minutes`: track extra = sum of customers[i] where grumpy[i]=1.
3. Answer = base + max extra.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |

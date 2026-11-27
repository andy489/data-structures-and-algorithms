# 875. Koko Eating Bananas — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/koko-eating-bananas/

---

## Solution: Binary Search — O(n log m) time, O(1) space

**Idea:** Binary search on the eating speed k in range [1, max(piles)]. For a given k, compute total hours = sum(ceil(pile/k)). Find smallest k where total hours <= h.

**Algorithm:**
1. lo = 1, hi = max(piles).
2. Binary search: mid = (lo+hi)/2. If canFinish(mid) → hi = mid else lo = mid+1.
3. Return lo.

**Complexity:**

| | |
|---|---|
| Time | O(n log m) — n = piles length, m = max pile |
| Space | O(1) |

# 1833. Maximum Ice Cream Bars — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-ice-cream-bars/

---

## Solution: Counting Sort + Greedy — O(n + C) time, O(C) space

**Idea:** To maximize the number of bars bought, greedily pick the cheapest ones first. Use counting sort (since costs ≤ 10^5) to avoid O(n log n) comparison sort. Sweep through costs from smallest to largest, buying as many as possible at each price point.

**Algorithm:**
1. Build a frequency array `freq` of size `maxCost + 1`.
2. For each cost `c` from 1 upward: buy `min(freq[c], coins / c)` bars, subtract the spent coins, add to count.
3. Return count.

**Complexity:**

| | |
|---|---|
| Time | O(n + C) — build freq in O(n), sweep in O(C); C = max cost = 10^5 |
| Space | O(C) — frequency array |

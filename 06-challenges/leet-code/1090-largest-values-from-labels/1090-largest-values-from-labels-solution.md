# 1090. Largest Values From Labels — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-values-from-labels/

---

## Solution: Greedy + Frequency Map — O(n log n) time, O(n) space

**Idea:** Sort by value descending. Greedily pick items while respecting label frequency limits.

**Algorithm:**
1. Sort (value, label) pairs by value descending.
2. For each item: if label count < useLimit and total chosen < numWanted, pick it.
3. Return total sum.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |

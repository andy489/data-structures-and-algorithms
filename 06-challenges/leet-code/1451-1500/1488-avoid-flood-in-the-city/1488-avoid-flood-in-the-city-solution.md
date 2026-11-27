# 1488. Avoid Flood In The City — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/avoid-flood-in-the-city/

---

## Solution: Greedy + TreeSet — O(n log n) time, O(n) space

**Idea:** Track full lakes and when each filled. On a dry day, drain the lake that will flood next (earliest next rain). Use a sorted set of dry days.

**Algorithm:**
1. Track lastFilled[lake] = day lake last filled.
2. Collect dry days in a sorted set.
3. For rain days: if lake already full, find nearest dry day after lastFilled[lake] to drain it.
4. If no such dry day exists, return [].

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |

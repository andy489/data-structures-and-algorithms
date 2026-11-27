# 1744. Can You Eat Your Favorite Candy on Your Favorite Day — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/

---

## Solution: Prefix Sum + Range Check — O(n + q) time, O(n) space

**Idea:** Build a prefix sum array `prefix` where `prefix[i]` is the total number of candies of types 0..i-1. For query `(type, day, cap)`:
- **Earliest** you could reach type `type`: eat 1 candy/day, so you need at least `prefix[type] + 1` days. So earliest finishing-previous day is `prefix[type]` (0-indexed: day index ≥ prefix[type]).
- **Latest** you can be**: by day `day` you've eaten at most `(day+1) * cap` candies total. You must still have at least one candy of type `type` left, so total eaten must be ≤ `prefix[type+1]`.

Condition: `day >= prefix[type]` AND `(long)(day+1)*cap > prefix[type]`.

**Algorithm:**
1. Build prefix sum array (use `long` to avoid overflow).
2. For each query check the two conditions above.

**Complexity:**

| | |
|---|---|
| Time | O(n + q) — prefix sum build + one pass through queries |
| Space | O(n) — prefix sum array |

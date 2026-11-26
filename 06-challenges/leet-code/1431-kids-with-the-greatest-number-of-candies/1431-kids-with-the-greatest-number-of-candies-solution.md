# 1431. Kids With The Greatest Number Of Candies — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

---

## Solution: Linear Scan — O(n) time, O(n) space

**Idea:** Find max. For each kid, check if candies[i] + extraCandies >= max.

**Algorithm:**
1. maxC = max(candies).
2. For each kid: result[i] = (candies[i] + extraCandies >= maxC).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

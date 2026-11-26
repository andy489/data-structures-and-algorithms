# 1033. Moving Stones Until Consecutive — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/moving-stones-until-consecutive/

---

## Solution: Math — O(1) time, O(1) space

**Idea:** Sort positions. Max moves = (b-a-1) + (c-b-1) (fill gaps one by one). Min moves: 0 if already consecutive; 1 if gap of 1 or gap of 2; 2 otherwise.

**Algorithm:**
1. Sort to get x <= y <= z.
2. Max = (y-x-1) + (z-y-1).
3. Min = 0 if z-x==2; 1 if y-x<=2 or z-y<=2; else 2.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |

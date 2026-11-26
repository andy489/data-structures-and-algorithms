# 1029. Two City Scheduling — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/two-city-scheduling/

---

## Solution: Greedy Sort — O(n log n) time, O(1) space

**Idea:** Start by sending everyone to city A. Sort by the extra cost of choosing B over A: (bCost - aCost). Send the first n people (those who save most by going to B) to B.

**Algorithm:**
1. Base cost = sum of all aCosts.
2. Sort by (bCost - aCost).
3. Add first n differences.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |

# 2136. Earliest Possible Day of Full Bloom — Solution

**Link:** https://leetcode.com/problems/earliest-possible-day-of-full-bloom/

## Approach: Greedy — Sort by Grow Time Descending

Key insight: plant seeds with larger grow times first. This greedy approach minimizes the latest bloom day.

Proof: If seed A has a larger grow time than seed B and B is planted before A, swapping them (plant A first) can only decrease the maximum bloom day.

Algorithm:
1. Create pairs `(plantTime[i], growTime[i])` and sort by `growTime` descending.
2. Simulate the planting: track the current day (cumulative plant time).
3. For each seed, bloom day = `currentDay + plantTime[i] + growTime[i]`.
4. Track and return the maximum bloom day.

## Complexity

| | Time | Space |
|---|---|---|
| **Greedy Sort** | O(n log n) | O(n) |

Where `n` is the number of seeds.

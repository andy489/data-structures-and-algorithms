# 1011. Capacity To Ship Packages Within D Days — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

---

## Solution: Binary Search — O(n log(sum)) time, O(1) space

**Idea:** Binary search on the capacity. The minimum possible is max(weights), maximum is sum(weights). For a given capacity, greedily check if we can ship all packages in <= days days.

**Algorithm:**
1. lo = max(weights), hi = sum(weights).
2. Binary search: mid = (lo+hi)/2. Check if feasible with capacity mid.
3. If feasible, hi = mid; else lo = mid+1.

**Complexity:**

| | |
|---|---|
| Time | O(n log(sum)) |
| Space | O(1) |

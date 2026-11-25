# 1094. Car Pooling — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/car-pooling/

---

## Solution: Difference Array — O(n + max_location) time, O(max_location) space

**Idea:** Use a difference array on stations 0..1000. Add passengers at pickup, subtract at dropoff. Check prefix sums never exceed capacity.

**Algorithm:**
1. For each trip [n, from, to]: diff[from] += n, diff[to] -= n.
2. Compute prefix sums and check each is <= capacity.

**Complexity:**

| | |
|---|---|
| Time | O(n + max_location) |
| Space | O(max_location) |

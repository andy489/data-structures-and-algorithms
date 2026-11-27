# 1184. Distance Between Bus Stops — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/distance-between-bus-stops/

---

## Solution: Prefix Sum (Two-Direction Scan) — O(n) time, O(1) space

**Idea:** Compute the total distance going clockwise from `start` to `destination` by summing the arc between them. The counterclockwise distance is simply `total - clockwise`. Return the minimum of the two.

**Algorithm:**
1. Ensure `start <= destination` by swapping if needed.
2. Sum all elements of `distance` to get `total`.
3. Sum `distance[start..destination-1]` to get `clockwise`.
4. Return `min(clockwise, total - clockwise)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass to compute total, one more partial pass |
| Space | O(1) — no extra storage |

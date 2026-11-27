# 1732. Find the Highest Altitude — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-the-highest-altitude/

---

## Solution: Prefix Sum Maximum — O(n) time, O(1) space

**Idea:** Compute running prefix sum (altitude) and track the maximum seen, starting from altitude `0`.

**Algorithm:**
1. Initialize `altitude = 0`, `maxAlt = 0`.
2. For each gain value, update `altitude += gain[i]` and `maxAlt = max(maxAlt, altitude)`.
3. Return `maxAlt`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — constant extra |

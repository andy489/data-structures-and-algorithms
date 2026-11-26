# 1503. Last Moment Before All Ants Fall Out of a Plank — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/

---

## Solution: Key Insight (Collisions = Pass-Through) — O(n) time, O(1) space

**Idea:** When two ants collide and reverse, it is equivalent to the two ants passing through each other. So we can ignore collisions entirely. Each ant moving left falls off at time = its position. Each ant moving right falls off at time = `n - position`. The answer is the maximum over all these times.

**Algorithm:**
1. For each position in `left`, the time to fall is `position`.
2. For each position in `right`, the time to fall is `n - position`.
3. Return the maximum of all such values.

**Complexity:**

| | |
|---|---|
| Time | O(L + R) — single pass over both arrays |
| Space | O(1) — constant extra space |

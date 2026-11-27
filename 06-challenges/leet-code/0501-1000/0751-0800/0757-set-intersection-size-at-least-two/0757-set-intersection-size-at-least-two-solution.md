# 757. Set Intersection Size At Least Two — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/set-intersection-size-at-least-two/

---

## Solution: Greedy Sort — O(n log n) time, O(n) space

**Idea:** Sort intervals by end ascending (break ties by start descending). Greedily assign the two largest values ≤ end to cover as many future intervals as possible. Track the two largest chosen values. For each interval, if it already has ≥ 2 covered points, skip; otherwise add the needed points.

**Algorithm:**
1. Sort by end asc, then by start desc.
2. Keep track of `p1` and `p2` (two largest chosen, `p1 > p2`).
3. For each interval `[s, e]`:
   - If `s > p1`: need 2 new points → add `e-1`, `e`. Set `p2 = e-1`, `p1 = e`. Count += 2.
   - If `s > p2`: need 1 new point → add `e`. Set `p2 = p1`, `p1 = e`. Count += 1.
4. Return count.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sort + linear scan |
| Space | O(1) — ignoring sort |

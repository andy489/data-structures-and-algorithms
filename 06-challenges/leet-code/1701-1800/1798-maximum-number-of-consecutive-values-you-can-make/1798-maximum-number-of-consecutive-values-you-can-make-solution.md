# 1798. Maximum Number of Consecutive Values You Can Make — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/

---

## Solution: Greedy Sort — O(n log n) time, O(1) space

**Idea:** Sort the coins. Maintain `reach` = maximum consecutive value we can currently represent (starting from 0). Initially `reach = 0` (we can only make 0). For each coin `c` in sorted order: if `c <= reach + 1`, we can extend our reach to `reach + c`. Otherwise, there is a gap at `reach + 1` that we can never fill, and we stop.

**Algorithm:**
1. Sort `coins`.
2. Initialize `reach = 0`.
3. For each `c` in `coins`:
   - If `c > reach + 1`: break (gap found).
   - Else: `reach += c`.
4. Return `reach + 1` (number of values from 0 to reach inclusive).

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — dominated by sort |
| Space | O(1) — sort in place |

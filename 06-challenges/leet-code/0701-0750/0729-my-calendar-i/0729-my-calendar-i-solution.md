# 729. My Calendar I — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/my-calendar-i/

---

## Solution: TreeMap (Sorted Map) — O(log n) per booking, O(n) space

**Idea:** Store bookings in a sorted map (start → end). For a new event [s, e), find the nearest existing event whose start ≤ s. Check it doesn't overlap. Also check the next event doesn't overlap.

**Algorithm:**
1. Use a `TreeMap<Integer,Integer>` mapping `start → end`.
2. For `book(s, e)`:
   - `prev` = floorKey(s): if exists and `prev_end > s`, overlap → return false.
   - `next` = ceilingKey(s): if exists and `next_start < e`, overlap → return false.
   - Add `s → e`, return true.

**Complexity:**

| | |
|---|---|
| Time | O(log n) per booking |
| Space | O(n) |

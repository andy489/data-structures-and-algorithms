# 731. My Calendar II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/my-calendar-ii/

---

## Solution: Double Booking Tracking — O(n) time, O(n) space

**Idea:** Maintain two lists: `singles` for all booked intervals, and `doubles` for double-booked intervals. When adding a new event, first check if it overlaps with any double-booked interval (which would cause triple booking). If safe, compute new double-bookings by intersecting with singles, then add to singles.

**Algorithm:**
1. For each `book(start, end)`: check if `[start, end)` overlaps any interval in `doubles` — if so, return false.
2. For each interval `[s, e)` in `singles`, compute intersection with `[start, end)`: `[max(s,start), min(e,end))`. If non-empty, add to `doubles`.
3. Add `[start, end)` to `singles`. Return true.

**Complexity:**

| | |
|---|---|
| Time | O(n) per call — scan both lists |
| Space | O(n) — store up to n singles and n doubles |

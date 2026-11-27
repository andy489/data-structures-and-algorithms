# 1109. Corporate Flight Bookings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/corporate-flight-bookings/

---

## Solution: Difference Array — O(n + m) time, O(n) space

**Idea:** Use a difference array where adding `seats` to position `first` and subtracting at `last + 1` marks a range update in O(1). After all bookings are applied, a prefix-sum pass reconstructs the actual seat counts per flight.

**Algorithm:**
1. Create a difference array `diff` of size `n + 2` (1-indexed, +1 for safe boundary).
2. For each booking `[first, last, seats]`:
   - `diff[first] += seats`
   - `diff[last + 1] -= seats`
3. Compute the prefix sum of `diff[1..n]` to get the answer array.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) — m bookings each in O(1), then one O(n) prefix-sum pass |
| Space | O(n) — the difference array |

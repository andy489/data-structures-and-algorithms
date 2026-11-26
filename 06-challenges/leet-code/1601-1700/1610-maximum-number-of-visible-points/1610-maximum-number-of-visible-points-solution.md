# 1610. Maximum Number of Visible Points — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-visible-points/

---

## Solution: Polar Angle + Sliding Window — O(n log n) time, O(n) space

**Idea:** Convert each point to its polar angle relative to the observer's location. Sort the angles and use a sliding window over a doubled array (angles + angles+360) to find the maximum number of angles that fit within a window of size `angle` degrees. Points at the observer's location are always visible and counted separately.

**Algorithm:**
1. For each point, compute its polar angle (degrees) relative to `location` using `atan2`. Points coinciding with `location` go into a separate `atOrigin` counter.
2. Sort the angles array.
3. Duplicate the array: append `angles[i] + 360` for all `i` (to handle the circular wrap-around).
4. Use a two-pointer sliding window: advance `right`; when `doubled[right] - doubled[left] > angle`, advance `left`. Track maximum window size.
5. Return `maxVisible + atOrigin`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting dominates |
| Space | O(n) — the doubled angles array |

# 1604. Alert Using Same Key-Card Three or More Times in a One-Hour Period — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/

---

## Solution: Sort Times per Worker, Sliding Window — O(n log n) time, O(n) space

**Idea:** Group all access times per worker as minutes since midnight. Sort each worker's list. A window of three consecutive times `[j-2, j-1, j]` triggers an alert if `times[j] - times[j-2] <= 60`.

**Algorithm:**
1. Build a map from worker name to a list of access times in minutes.
2. For each worker, sort their time list.
3. Slide a window of size 3: if the gap between the first and last element of any window is `<= 60`, add the worker to the alert list and move on to the next worker.
4. Sort and return the alert list.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting per worker; total work proportional to n log n |
| Space | O(n) — storing all times per worker |

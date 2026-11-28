# 2933. High-Access Employees — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/high-access-employees/

---

## Solution: Group and Sort — O(n log n) time, O(n) space

**Idea:** Group access times by employee name. For each employee, convert times to integer minutes, sort them, and use a sliding window to check if any 3 consecutive accesses (by sorted time) fall within a strict one-hour window (difference < 60 minutes).

**Algorithm:**
1. Build a map from employee name to list of integer minutes (parse `"HHMM"` as `HH * 60 + MM`).
2. For each employee, sort their access times.
3. Slide over consecutive triples: if `times[i+2] - times[i] < 60`, the employee is high-access.
4. Collect and return high-access employee names.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |

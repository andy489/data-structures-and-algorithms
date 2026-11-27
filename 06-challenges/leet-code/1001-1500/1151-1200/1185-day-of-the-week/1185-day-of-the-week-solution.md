# 1185. Day of the Week — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/day-of-the-week/

---

## Solution: Zeller's Congruence / Day Count from Anchor — O(1) time, O(1) space

**Idea:** Count the total number of days elapsed since a known anchor date (January 1, 1971 — a Friday, index 4 in 0=Sunday convention) and return `days[totalDays % 7]`. To count days: sum full years' days (accounting for leap years) plus the days in the current year up to the given date.

**Algorithm:**
1. For each year from 1971 to `year - 1`, add 366 if it is a leap year, else 365.
2. Add the cumulative days for completed months in `year`.
3. Add `day`.
4. Use `(fridayOffset + totalDays) % 7` to index into the days array.

**Complexity:**

| | |
|---|---|
| Time | O(1) — bounded by constant year range (1971–2100) |
| Space | O(1) — fixed-size arrays only |

---

## Solution 2: Tomohiko Sakamoto's Algorithm — O(1) time, O(1) space

**Idea:** A compact formula that directly computes the day of the week for any Gregorian date without counting days step-by-step.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |

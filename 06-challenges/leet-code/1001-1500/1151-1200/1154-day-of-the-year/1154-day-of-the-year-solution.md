# 1154. Day of the Year — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/day-of-the-year/

---

## Solution: Month Prefix Sums — O(1) time, O(1) space

**Idea:** Parse year, month, day from the string. Use a fixed month-lengths array and add all days from prior months, then add the current day. For leap years (divisible by 4, but not 100 unless also divisible by 400), February has 29 days.

**Algorithm:**
1. Parse `year`, `month`, `day` from the date string.
2. Build a days-per-month array, setting February to 29 if the year is a leap year.
3. Sum days for months 1 through `month-1`, then add `day`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — fixed 12-month array |
| Space | O(1) — constant extra space |

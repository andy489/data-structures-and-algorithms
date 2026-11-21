# 197. Rising Temperature — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/rising-temperature/

---

## Solution: Self-Join on Date Difference

**Idea:** Join the table with itself where the second row's date is exactly one day after the first row's date, and the second row's temperature is higher.

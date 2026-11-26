# 1507. Reformat Date — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reformat-date/

---

## Solution: String Parsing with Month Map — O(1) time, O(1) space

**Idea:** Split the input by spaces, parse day digits (strip the suffix), look up month number via a fixed map, and format with zero-padding.

**Algorithm:**
1. Split `date` on spaces to get `[dayStr, monthStr, yearStr]`.
2. Strip non-digit suffix from `dayStr` to get the day integer.
3. Use a lookup array/map to convert `monthStr` to month number (1-12).
4. Format as `YYYY-MM-DD` with zero-padding on month and day.

**Complexity:**

| | |
|---|---|
| Time | O(1) — fixed-size input (date strings have bounded length) |
| Space | O(1) — fixed auxiliary space for the month lookup |

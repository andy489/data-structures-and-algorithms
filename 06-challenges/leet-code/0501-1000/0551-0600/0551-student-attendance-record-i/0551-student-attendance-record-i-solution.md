# 551. Student Attendance Record I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/student-attendance-record-i/

---

## Solution: String Scan — O(n) time, O(1) space

**Idea:** Count 'A's (must be < 2) and check for any 'LLL' substring.

**Algorithm:**
1. Count occurrences of 'A'; if ≥ 2, return false.
2. Check if `s.contains("LLL")`; if so, return false.
3. Otherwise return true.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |

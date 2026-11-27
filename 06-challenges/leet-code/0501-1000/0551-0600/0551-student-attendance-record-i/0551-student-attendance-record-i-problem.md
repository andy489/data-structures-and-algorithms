# 551. Student Attendance Record I

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/student-attendance-record-i/

---

## Problem Statement

You are given a string `s` representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

- `'A'`: Absent
- `'L'`: Late
- `'P'`: Present

The student is eligible for an attendance award if they meet **both** of the following criteria:

- The student was absent (`'A'`) for **strictly** fewer than 2 days total.
- The student was **never** late (`'L'`) for 3 or more **consecutive** days.

Return `true` if the student is eligible for an attendance award, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  s = "PPALLP"
Output: true
```

**Example 2:**
```
Input:  s = "PPALLL"
Output: false
```

---

## Constraints

- `1 <= s.length <= 1000`
- `s[i]` is either `'A'`, `'L'`, or `'P'`

# 1280. Students and Examinations — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/students-and-examinations/

---

## Solution: CROSS JOIN + LEFT JOIN + COUNT — O(s*j*e) time, O(s*j) space

**Idea:** CROSS JOIN Students and Subjects to get all combinations, then LEFT JOIN Examinations to count attendance.

**Algorithm:**
1. CROSS JOIN Students and Subjects.
2. LEFT JOIN Examinations on (student_id, subject_name).
3. GROUP BY, COUNT, ORDER BY student_id, subject_name.

**Complexity:**

| | |
|---|---|
| Time | O(s*j*e) |
| Space | O(s*j) |


**SQL Solution:**
```sql
SELECT s.student_id, s.student_name, sub.subject_name,
       COUNT(e.student_id) AS attended_exams
FROM Students s
CROSS JOIN Subjects sub
LEFT JOIN Examinations e ON s.student_id = e.student_id AND sub.subject_name = e.subject_name
GROUP BY s.student_id, s.student_name, sub.subject_name
ORDER BY s.student_id, sub.subject_name;
```
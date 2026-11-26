# 2024. Maximize the Confusion of an Exam — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximize-the-confusion-of-an-exam/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Run sliding window twice: once allowing k 'F' changes to 'T', once k 'T' changes to 'F'.

**Algorithm:**
1. Sliding window: max window with at most k of target char.
2. Run for target='F' and target='T', take max.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |

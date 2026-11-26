# 1792. Maximum Average Pass Ratio — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-average-pass-ratio/

---

## Solution: Max Heap by Marginal Gain — O((n + e) log n) time, O(n) space

**Idea:** Greedily assign each extra student to the class that gains the most by adding one student. The gain for class `(pass, total)` from adding one student is `(pass+1)/(total+1) - pass/total`. Use a max heap ordered by this marginal gain. Each step, pop the best class, add one student, push back with updated gain.

**Algorithm:**
1. Build a max heap where each entry is `(-gain, pass, total)`.
2. For each of `extraStudents` students:
   - Pop the class with maximum gain.
   - Add the student: `pass++, total++`.
   - Push back with new gain.
3. Compute and return the average pass ratio.

**Complexity:**

| | |
|---|---|
| Time | O((n + e) log n) — n initial insertions, e heap operations |
| Space | O(n) — heap storage |

# 1700. Number of Students Unable to Eat Lunch — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

---

## Solution: Count-Based Simulation — O(n) time, O(1) space

**Idea:** Instead of simulating the queue, count how many students prefer each type. We process sandwiches in order. If we can serve the current sandwich (there's a student who wants it), serve it; otherwise, all remaining students are stuck.

**Algorithm:**
1. Count students preferring type 0 and type 1.
2. For each sandwich in order: if a student wants it, decrement the count; otherwise, the remaining students can't eat — return their total count.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through sandwiches |
| Space | O(1) — only two counters |

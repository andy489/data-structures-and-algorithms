# 1226. The Dining Philosophers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/the-dining-philosophers/

---

## Solution: Semaphore with Asymmetric Lock Order — O(1) per call time, O(1) space

**Idea:** Use a Semaphore to limit concurrent access and avoid deadlock by having philosophers pick up forks in different orders.

**Algorithm:**
1. Use Semaphore(4) to allow at most 4 philosophers to try simultaneously (breaking circular wait).
2. Acquire semaphore, pick up left and right forks, eat, release.

**Complexity:**

| | |
|---|---|
| Time | O(1) per call |
| Space | O(1) |

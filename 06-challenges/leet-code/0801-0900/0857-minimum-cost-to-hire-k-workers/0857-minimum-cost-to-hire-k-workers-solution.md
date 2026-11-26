# 857. Minimum Cost to Hire K Workers — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-cost-to-hire-k-workers/

---

## Solution: Sort by Wage/Quality Ratio + Max Heap — O(n log n) time, O(n) space

**Idea:** The captain (the worker who sets the ratio for the group) has ratio = wage/quality. All workers paid at this ratio, so total cost = ratio * sum_of_quality. Sort workers by ratio, iterate from smallest ratio to largest, maintaining a max-heap of size k of qualities. At each step, sum of k smallest qualities times current ratio gives the cost.

**Algorithm:**
1. Sort workers by wage[i]/quality[i].
2. Use a max-heap to keep track of k smallest quality values seen so far.
3. For each worker (in ratio order): add quality to heap and sum. If heap size > k, pop the max.
4. If heap size == k, update answer with sum * ratio.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sort + heap ops |
| Space | O(n) — heap |

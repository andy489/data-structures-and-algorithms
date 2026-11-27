# 2224. Minimum Number of Operations to Convert Time — Solution

**Approach:** Greedy

Convert both times to total minutes. Compute the difference `diff`. Greedily subtract the largest allowed increment (60, 15, 5, 1) as many times as possible, adding to the operation count each time.

**Time Complexity:** O(1) — fixed number of steps.

**Space Complexity:** O(1)

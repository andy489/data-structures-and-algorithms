# 1982. Find Array Given Subset Sums — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-array-given-subset-sums/

---

## Solution: Recursive Divide and Conquer — O(n² log n) time, O(n) space

**Idea:** Sort the subset sums. The largest element minus smallest equals the absolute difference of the total sum from 0, which reveals the smallest/largest element. Split the sums into two halves based on whether adding/not-adding the found element produces each sum.

**Algorithm:**
1. Sort `sums`. The difference `sums[last] - sums[last-1]` is a candidate element `d`.
2. Split sums into two equal halves: one that includes subsets with `d`, one without.
3. Decide which half to keep by checking if 0 appears in the smaller half.
4. Recurse on the remaining half.

**Complexity:**

| | |
|---|---|
| Time | O(n² log n) |
| Space | O(n) recursion |

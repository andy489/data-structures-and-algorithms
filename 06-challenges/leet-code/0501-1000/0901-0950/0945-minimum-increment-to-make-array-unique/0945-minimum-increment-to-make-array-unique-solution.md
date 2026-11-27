# 945. Minimum Increment to Make Array Unique — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-increment-to-make-array-unique/

---

## Solution: Sort + Greedy — O(n log n) time, O(1) space

**Idea:** Sort the array. If a value is ≤ previous, increment it to previous+1. Count the increments.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |

# 448. Find All Numbers Disappeared in an Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

---

## Solution: Index Negation — O(n) time, O(1) space

**Idea:** Use the array itself as a presence marker. For each value, negate `nums[|val|-1]`. On second pass, indices still positive indicate missing numbers.

**Algorithm:**
1. For each `num`, negate `nums[|num| - 1]`.
2. Collect indices `i` where `nums[i] > 0`; value `i+1` is missing.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) — O(n) output excluded |

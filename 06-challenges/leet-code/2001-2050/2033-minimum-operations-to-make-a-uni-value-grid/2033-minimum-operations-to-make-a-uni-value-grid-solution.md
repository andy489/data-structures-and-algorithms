# 2033. Minimum Operations to Make a Uni-Value Grid — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/

---

## Solution: Flatten, Sort, Median — O(m*n log(m*n)) time, O(m*n) space

**Idea:** All values must be congruent mod x. Flatten, sort, pick median as target, sum differences / x.

**Algorithm:**
1. Flatten grid.
2. Check all values same mod x (else -1).
3. Sort, pick median.
4. Sum |v - median| / x.

**Complexity:**

| | |
|---|---|
| Time | O(m*n log(m*n)) |
| Space | O(m*n) |

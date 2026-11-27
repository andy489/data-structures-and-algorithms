# 1981. Minimize the Difference Between Target and Chosen Elements — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/

---

## Solution: DP with Bitset — O(m * n * maxSum) time, O(maxSum) space

**Idea:** Use a boolean DP set tracking all achievable sums after processing each row. For each row, expand the set by all achievable sums + each element in the row.

**Algorithm:**
1. Start with `dp = {0}`.
2. For each row, compute new set: `{s + v | s in dp, v in row}`.
3. After processing all rows, return `min(abs(s - target)) for s in dp`.

**Complexity:**

| | |
|---|---|
| Time | O(m · n · maxSum) |
| Space | O(m · maxSum) |

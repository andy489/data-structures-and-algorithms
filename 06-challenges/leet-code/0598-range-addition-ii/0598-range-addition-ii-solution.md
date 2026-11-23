# 598. Range Addition II — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/range-addition-ii/

---

## Solution: Min intersection — O(k) time, O(1) space

**Idea:** Every operation increments a top-left rectangle `[0..ai-1][0..bi-1]`. The cell with the maximum value is incremented by ALL operations. That's the intersection of all rectangles: cells `[0..minA-1][0..minB-1]`. The count is `minA * minB`.

**Algorithm:**
1. Find `minA = min(ops[i][0])` and `minB = min(ops[i][1])`.
2. If `ops` is empty, return `m * n`.
3. Return `minA * minB`.

**Complexity:**

| | |
|---|---|
| Time | O(k) where k = ops.length |
| Space | O(1) |

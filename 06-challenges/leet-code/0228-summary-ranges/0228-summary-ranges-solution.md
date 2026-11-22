# 228. Summary Ranges — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/summary-ranges/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Walk through the sorted array; extend a range while consecutive elements differ by 1. When a gap is found, format and emit the current range.

**Algorithm:**
1. For each index `i`, set `start = nums[i]`.
2. While the next element equals `nums[i] + 1`, advance `i`.
3. If `start == nums[i]` emit `"start"`; else emit `"start->nums[i]"`.
4. Continue from `i + 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) extra (not counting output) |

# 1537. Get the Maximum Score — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/get-the-maximum-score/

---

## Solution: Two Pointer DP — O(n + m) time, O(1) space

**Idea:** Merge-traverse both arrays. Between common elements (intersection points), we accumulate sums independently for each path. At each common element, we take the max of both accumulated sums, synchronize them, and add the common value. The answer is the max of the two final sums.

**Algorithm:**
1. Use two pointers i, j and accumulators sum1, sum2.
2. Advance the pointer with the smaller current value, adding to its sum.
3. When both point to equal values: set both sums to `max(sum1, sum2) + value`, advance both.
4. At the end, return `max(sum1, sum2) % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) — single merged traversal |
| Space | O(1) — only pointer and sum variables |

# 3495. Minimum Operations to Make Array Elements Zero — Solution

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/

---

## Solution: Total Steps with Level Buckets — O(Q * log(max)) time, O(1) space

**Idea:** Each number `x` needs `d(x)` steps to reach zero via repeated `floor(x / 4)`. Each operation reduces exactly 2 numbers simultaneously by one step. The minimum operations for a set of numbers is `ceil(total_steps / 2)` where `total_steps = sum of d(x)`.

Numbers in `[4^(k-1), 4^k - 1]` have `d(x) = k`. So for a query `[l, r]`, iterate over levels and accumulate `count_in_level * level` as the total steps, then answer is `ceil(total_steps / 2)`.

**Algorithm:**
1. For each query `[l, r]`:
   - Initialize level buckets: level 1 = `[1, 3]`, level 2 = `[4, 15]`, level k = `[4^(k-1), 4^k - 1]`.
   - For each level, compute overlap with `[l, r]` and add `overlap_count * level` to `steps`.
   - Add `ceil(steps / 2)` to the answer.

**Complexity:**

| | |
|---|---|
| Time | O(Q * log(max)) |
| Space | O(1) |

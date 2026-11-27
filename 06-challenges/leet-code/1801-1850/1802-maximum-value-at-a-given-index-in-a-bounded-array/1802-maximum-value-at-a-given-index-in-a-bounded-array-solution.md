# 1802. Maximum Value at a Given Index in a Bounded Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

---

## Solution: Binary Search — O(log(maxSum)) time, O(1) space

**Idea:** Binary search on the answer value `v` at the target index. For a candidate value `v`, compute the minimum possible sum of the array: values decrease by 1 each step away from `index`, bottoming out at 1. If that minimum sum fits within `maxSum`, then `v` is achievable.

**Algorithm:**
1. For a side of length `len` where the peak is `v`, the minimum sum on that side is:
   - If `v >= len`: arithmetic sequence `(v-len+1) + ... + v = (v + v-len+1) * len / 2`
   - If `v < len`: the sequence reaches 1 before the end, so it's `v*(v+1)/2 + (len - v)` ones
2. Binary search `lo = 1, hi = maxSum`. For each `mid`, compute `sumSide(mid, left+1) + sumSide(mid, right+1) - mid` (subtract `mid` once since it was counted twice).
3. If the total fits in `maxSum`, try higher; otherwise go lower.

**Complexity:**

| | |
|---|---|
| Time | O(log(maxSum)) — binary search range is 1 to maxSum |
| Space | O(1) — only arithmetic variables |

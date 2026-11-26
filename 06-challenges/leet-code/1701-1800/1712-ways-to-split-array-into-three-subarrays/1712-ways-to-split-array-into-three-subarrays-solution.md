# 1712. Ways to Split Array Into Three Subarrays — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/

---

## Solution: Prefix Sum + Binary Search — O(n log n) time, O(n) space

**Idea:** Build a prefix sum array. For each valid left-end index `i` (left = nums[0..i]):
- Find the minimum j (mid-start = i+1) where `sum(mid) >= sum(left)` using binary search.
- Find the maximum j where `sum(mid) <= sum(right)` using binary search.
- The count of valid mid splits is `maxJ - minJ + 1`.

**Algorithm:**
1. Compute prefix sum `pre`.
2. For each `i` from 0 to n-3:
   - `leftSum = pre[i+1]`
   - Use binary search to find min `j` where `pre[j+1] - pre[i+1] >= leftSum`.
   - Use binary search to find max `j` where `pre[n] - pre[j+1] >= pre[j+1] - pre[i+1]`.
   - Add `max(0, maxJ - minJ + 1)` to result.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — binary search per left split |
| Space | O(n) — prefix sum array |

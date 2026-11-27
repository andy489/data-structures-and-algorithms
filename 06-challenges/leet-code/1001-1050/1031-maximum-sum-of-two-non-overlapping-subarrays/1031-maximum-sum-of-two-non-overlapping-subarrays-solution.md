# 1031. Maximum Sum of Two Non-Overlapping Subarrays — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/

---

## Solution: Prefix Sum + Running Max — O(n) time, O(n) space

**Idea:** Use prefix sums. Slide window of firstLen, tracking max sum before it; then try secondLen after. Do both orderings.

**Algorithm:**
1. Build prefix sum array.
2. Try L before R: track `maxL` = max sum of firstLen window ending before current secondLen window start.
3. Try R before L: track `maxR` similarly.
4. Return max over both.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

# 3040. Maximum Number of Operations With the Same Score II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-ii/

---

## Solution: DP with Memoization — O(n²) time, O(n²) space

**Idea:** Try each of the 3 possible target scores (first+second, last+second-last, first+last). For each target, use interval DP: dp(l, r) = max ops on subarray [l,r] with the fixed target. At each step try removing from front, back, or both ends.

**Algorithm:**
1. Try target = nums[0]+nums[1], nums[n-1]+nums[n-2], nums[0]+nums[n-1].
2. For each target: dp(l, r) = max over valid moves.
3. Return max over all 3 targets.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — O(n²) states, O(1) per state |
| Space | O(n²) — memoization table |

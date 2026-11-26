# 3091. Apply Operations To Make Sum Of Array Greater Than Or Equal To K — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/

---

## Solution: Enumerate + Math — O(k) time, O(1) space

**Idea:** If we do `i` increments first (making value i+1), then `j` duplications, final sum = (i+1) * 2^j. We want (i+1) * 2^j >= k with i+j minimized. Enumerate i from 0 to k-1, compute min j = ceil(log2(k/(i+1))), track min(i+j).

**Algorithm:**
1. For i from 0 to k-1:
2.   val = i + 1
3.   j = max(0, ceil(log2(k/val)))
4.   ans = min(ans, i+j)
5. Return ans.

**Complexity:**

| | |
|---|---|
| Time | O(k) — O(k) |
| Space | O(1) — O(1) |

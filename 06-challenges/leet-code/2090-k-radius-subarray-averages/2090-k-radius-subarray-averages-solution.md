# 2090. K-Radius Subarray Averages — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/k-radius-subarray-averages/

---

## Solution: Sliding Window — O(n) time, O(n) space

**Idea:** Use prefix sum to compute window sums in O(1). Radius 2k+1 window.

**Algorithm:**
1. Compute prefix sums.
2. For each i from k to n-1-k: average = (prefix[i+k+1] - prefix[i-k]) / (2k+1).
3. Others = -1.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

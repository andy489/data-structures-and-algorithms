# 1493. Longest Subarray Of 1s After Deleting One Element — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Sliding window allowing at most one zero. Length of valid window minus 1 (since we must delete one element).

**Algorithm:**
1. Sliding window with at most 1 zero (the deleted element).
2. Track zeros in window. When zeros > 1, shrink from left.
3. Answer = max(right - left) (window size - 1 for the deleted element).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |

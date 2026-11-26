# 1423. Maximum Points You Can Obtain From Cards — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Taking k cards from the ends = leaving a contiguous window of n-k cards. Minimize the sum of that window.

**Algorithm:**
1. Total = sum of all. Window size w = n-k.
2. Find min sum of any contiguous window of size w.
3. Answer = total - minWindow.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |

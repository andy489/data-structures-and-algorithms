# 643. Maximum Average Subarray I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-average-subarray-i/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Compute initial window sum then slide right, adding new element and dropping leftmost.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |

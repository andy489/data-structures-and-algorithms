# 992. Subarrays with K Different Integers — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/subarrays-with-k-different-integers/

---

## Solution: Sliding Window — atMost(k) - atMost(k-1) — O(n) time, O(n) space

**Idea:** Count subarrays with at most k distinct integers. Answer = atMost(k) - atMost(k-1).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — frequency map |

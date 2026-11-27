# 930. Binary Subarrays With Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-subarrays-with-sum/

---

## Solution: Prefix Sum + HashMap — O(n) time, O(n) space

**Idea:** Count subarrays with sum exactly = goal using prefix sums. Count of subarrays ending at i with sum = goal equals count[prefixSum - goal].

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

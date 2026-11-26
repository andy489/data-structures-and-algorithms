# 1470. Shuffle The Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/shuffle-the-array/

---

## Solution: Linear Interleave — O(n) time, O(n) space

**Idea:** Interleave first half and second half of the array.

**Algorithm:**
1. For i in 0..n-1: result[2i] = nums[i], result[2i+1] = nums[i+n].

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

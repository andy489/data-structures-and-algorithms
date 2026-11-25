# 1004. Max Consecutive Ones III — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/max-consecutive-ones-iii/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Maintain a window [left, right] where the number of zeros is at most k. Expand right; shrink left when zeros exceed k.

**Algorithm:**
1. Use left pointer and zero count.
2. For each right, if nums[right]==0, increment zeros.
3. While zeros > k, if nums[left]==0 decrement zeros, advance left.
4. Track max window size.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |

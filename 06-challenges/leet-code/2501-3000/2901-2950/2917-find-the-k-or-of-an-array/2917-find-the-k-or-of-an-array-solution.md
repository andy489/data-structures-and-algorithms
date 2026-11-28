# 2917. Find the K-or of an Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-the-k-or-of-an-array/

---

## Solution: Bit Counting — O(n * 31) time, O(1) space

**Idea:** For each bit position (0 to 30), count how many numbers have that bit set. If the count is at least `k`, set that bit in the result.

**Algorithm:**
1. Initialize `result = 0`.
2. For each bit position `b` from 0 to 30, count how many `nums[i]` have bit `b` set.
3. If count `>= k`, set bit `b` in result.
4. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n * 31) |
| Space | O(1) |

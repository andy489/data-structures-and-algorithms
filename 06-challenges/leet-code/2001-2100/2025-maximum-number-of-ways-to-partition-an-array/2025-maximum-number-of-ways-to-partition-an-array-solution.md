# 2025. Maximum Number of Ways to Partition an Array — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/

---

## Solution: Prefix Sums + HashMap — O(n) time, O(n) space

**Idea:** Try no-op (count prefix sums == total/2). For each j, changing nums[j] to k shifts prefix sums; track counts.

**Algorithm:**
1. Compute prefix sums.
2. Without op: count i where prefix[i] == total/2.
3. With changing j: total' = total - nums[j] + k. Count prefixes where prefix[i] == total'/2.
4. Use frequency maps.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

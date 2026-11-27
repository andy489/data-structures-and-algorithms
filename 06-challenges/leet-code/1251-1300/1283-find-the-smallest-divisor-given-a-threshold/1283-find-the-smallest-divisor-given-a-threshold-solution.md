# 1283. Find the Smallest Divisor Given a Threshold — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

---

## Solution: Binary Search — O(n log(max)) time, O(1) space

**Idea:** Binary search on divisor in [1, max(nums)]. For a given divisor d, check if sum of ceil(x/d) ≤ threshold.

**Algorithm:**
1. Binary search d in [1, max(nums)].
2. For each mid: compute sum of ceil(x/mid) = (x+mid-1)/mid.
3. Return lo.

**Complexity:**

| | |
|---|---|
| Time | O(n log(max)) |
| Space | O(1) |

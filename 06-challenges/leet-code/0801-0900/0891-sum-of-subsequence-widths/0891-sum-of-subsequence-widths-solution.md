# 891. Sum of Subsequence Widths — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sum-of-subsequence-widths/

---

## Solution: Sort + Combinatorics — O(n log n) time, O(n) space

**Idea:** After sorting, element at index i appears as max in 2^i subsequences and as min in 2^(n-1-i) subsequences. Contribution = nums[i] * (2^i - 2^(n-1-i)).

**Algorithm:**
1. Sort nums.
2. For each i: ans += nums[i] * (2^i - 2^(n-1-i)) mod MOD.
3. Return ans mod MOD.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting |
| Space | O(n) — powers array |

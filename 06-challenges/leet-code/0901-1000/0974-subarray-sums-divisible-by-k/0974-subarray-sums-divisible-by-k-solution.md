# 974. Subarray Sums Divisible by K — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/subarray-sums-divisible-by-k/

---

## Solution: Prefix Sum + Remainder Count — O(n) time, O(k) space

**Idea:** Count prefix sum remainders. If two prefix sums have the same remainder mod k, the subarray between them is divisible by k.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(k) — remainder map |

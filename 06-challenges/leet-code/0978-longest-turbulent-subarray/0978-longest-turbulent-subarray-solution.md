# 978. Longest Turbulent Subarray — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-turbulent-subarray/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Track the current turbulent run length. If the sign changes from previous, extend; otherwise reset.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |

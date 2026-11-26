# 1247. Minimum Swaps to Make Strings Equal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/

---

## Solution: Counting — O(n) time, O(1) space

**Idea:** Count mismatches: xy_count (s1[i]='x', s2[i]='y') and yx_count (s1[i]='y', s2[i]='x'). Each pair of same-type mismatches costs 1 swap. A mixed pair costs 2 swaps. If total mismatches is odd, return -1.

**Algorithm:**
1. Count xy and yx mismatches.
2. If (xy + yx) is odd, return -1.
3. Answer = xy//2 + yx//2 + (xy%2)*2.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |

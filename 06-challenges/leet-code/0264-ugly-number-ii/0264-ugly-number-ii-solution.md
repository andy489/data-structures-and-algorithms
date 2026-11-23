# 264. Ugly Number II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/ugly-number-ii/

---

## Solution: Three-Pointer DP — O(n) time, O(n) space

**Idea:** Maintain three pointers into the growing ugly-numbers array, one for each prime factor (2, 3, 5). At each step, the next ugly number is the minimum of `ugly[p2]*2`, `ugly[p3]*3`, `ugly[p5]*5`. Advance whichever pointer(s) produced the minimum to avoid duplicates.

**Algorithm:**
1. Initialize `ugly = [1]`, `p2 = p3 = p5 = 0`.
2. For `i` in `1..n-1`:
   - `next = min(ugly[p2]*2, ugly[p3]*3, ugly[p5]*5)`.
   - Append `next` to `ugly`.
   - Advance any pointer whose product equaled `next`.
3. Return `ugly[n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass filling the array |
| Space | O(n) — stores all n ugly numbers |

# 1746. Maximum Subarray Sum After One Operation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/

---

## Solution: DP with Two States — O(n) time, O(1) space

**Idea:** Extend Kadane's algorithm with two states:
- `noSq`: best subarray sum ending here with **no** square used yet.
- `withSq`: best subarray sum ending here with **exactly one** square used.

At each index `i` with value `v`:
- `withSq = max(noSq + v*v, withSq + v, v*v)` — either extend a previous no-square subarray by squaring `v`, extend an already-squared subarray, or start fresh by squaring `v`.
- `noSq = max(noSq + v, v)` — standard Kadane's.

Track the global max of `withSq`.

**Algorithm:**
1. Initialize `noSq = nums[0]`, `withSq = nums[0]*nums[0]`, `ans = withSq`.
2. For each `v` in `nums[1:]`, update both states; update `ans`.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — two variables |

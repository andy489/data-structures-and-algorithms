# 1186. Maximum Subarray Sum with One Deletion — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/

---

## Solution: DP with Two States — O(n) time, O(1) space

**Idea:** Maintain two DP values at each position:
- `noDelete`: maximum subarray sum ending at index `i` using **no** deletion.
- `oneDelete`: maximum subarray sum ending at index `i` using **exactly one** deletion.

Transitions:
- `noDelete = max(arr[i], noDelete + arr[i])`
- `oneDelete = max(noDelete_prev, oneDelete_prev + arr[i])` — either skip `arr[i]` (the deletion), or extend a previously-deleted subarray.

Track the global maximum over both states throughout the scan.

**Algorithm:**
1. Initialise `noDelete = arr[0]`, `oneDelete = 0` (no valid one-deletion subarray yet of length 1), `ans = arr[0]`.
2. For each `i` from 1 to `n-1`: update `oneDelete` and `noDelete` using the transitions above, update `ans`.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — only scalar variables |

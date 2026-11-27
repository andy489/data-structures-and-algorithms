# 1601. Maximum Number of Achievable Transfer Requests — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/

---

## Solution: Bitmask Enumeration — O(2^r * (r + n)) time, O(n) space

**Idea:** Since `requests.length <= 16`, enumerate all 2^r subsets of requests. For each subset, check whether every building has a net-zero change in employee count (departures equal arrivals). Track the maximum subset size that satisfies this condition.

**Algorithm:**
1. For each bitmask `mask` from `0` to `2^r - 1`:
   - Build a `delta[]` array: for each set bit `i`, decrement `delta[from[i]]` and increment `delta[to[i]]`.
   - If every entry of `delta` is zero, update `best` with the popcount of `mask`.
2. Return `best`.

**Complexity:**

| | |
|---|---|
| Time | O(2^r * (r + n)) — 2^16 subsets, each O(r + n) to validate |
| Space | O(n) — the delta array |

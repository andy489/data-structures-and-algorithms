# 1524. Number of Sub-arrays With Odd Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/

---

## Solution: Prefix Sum Parity — O(n) time, O(1) space

**Idea:** A subarray `arr[i..j]` has odd sum iff `prefix[j] XOR prefix[i-1]` is odd — meaning exactly one of the two prefix sums is odd. Track counts of even and odd prefix sums seen so far. When the current prefix sum is even, all previous odd prefix sums form valid subarrays; when it is odd, all previous even prefix sums form valid subarrays.

**Algorithm:**
1. Initialize `even = 1` (empty prefix has sum 0, which is even), `odd = 0`, `result = 0`, `prefix = 0`.
2. For each `x` in `arr`:
   - `prefix += x`
   - If `prefix` is odd: `result += even`; `odd++`
   - Else: `result += odd`; `even++`
3. Return `result % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — only two counters |

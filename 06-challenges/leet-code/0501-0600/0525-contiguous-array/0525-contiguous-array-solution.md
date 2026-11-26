# 525. Contiguous Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/contiguous-array/

---

## Solution: Prefix Sum + HashMap — O(n) time, O(n) space

**Idea:** Treat `0` as `-1`. Then a subarray with equal 0s and 1s has sum 0. Track `prefixSum → first occurrence index`. If we see the same prefix sum again, the subarray between is balanced.

**Algorithm:**
1. Initialize `firstOccurrence = {0: -1}`, `prefixSum = 0`, `maxLen = 0`.
2. For each `i`, adjust `prefixSum` by `+1` for 1 and `-1` for 0.
3. If `prefixSum` seen before at index `prev`, update `maxLen = max(maxLen, i - prev)`.
4. Otherwise record `firstOccurrence[prefixSum] = i`.
5. Return `maxLen`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — HashMap |

# 560. Subarray Sum Equals K — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/subarray-sum-equals-k/

---

## Solution: Prefix Sum HashMap — O(n) time, O(n) space

**Idea:** `prefixSum[j] - prefixSum[i] == k` iff `prefixSum[i] == prefixSum[j] - k`. Keep a frequency map of prefix sums seen so far.

**Algorithm:**
1. `prefixFreq = {0: 1}`, `sum = 0`, `count = 0`.
2. For each `num`: `sum += num`; `count += prefixFreq.get(sum - k, 0)`; increment `prefixFreq[sum]`.
3. Return `count`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — prefix frequency map |

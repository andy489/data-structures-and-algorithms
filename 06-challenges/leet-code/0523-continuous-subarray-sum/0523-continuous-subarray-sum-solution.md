# 523. Continuous Subarray Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/continuous-subarray-sum/

---

## Solution: Prefix Sum + HashMap (Remainder) — O(n) time, O(k) space

**Idea:** If `prefixSum[j] % k == prefixSum[i] % k` and `j - i >= 2`, then `sum(i+1..j)` is divisible by `k`. Store the first occurrence index of each remainder. If we see the same remainder again at index `j` with `j - firstSeen[rem] >= 2`, return true.

**Algorithm:**
1. Initialize `remainderFirstSeen = {0: -1}` (empty prefix has remainder 0 at index -1).
2. For each index `i`, compute running `prefixSum % k`.
3. If this remainder was seen before at index `prev`, and `i - prev >= 2`, return `true`.
4. Otherwise store this remainder's first occurrence.
5. Return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(min(n, k)) — at most k distinct remainders |

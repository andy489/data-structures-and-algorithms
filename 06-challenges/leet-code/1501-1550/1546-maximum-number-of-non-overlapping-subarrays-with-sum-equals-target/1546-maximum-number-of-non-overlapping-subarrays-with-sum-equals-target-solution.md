# 1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/

---

## Solution: Greedy Prefix Sum — O(n) time, O(n) space

**Idea:** Greedily find the earliest-ending subarray with the target sum. Once found, reset the prefix sum tracking to avoid overlap and continue. This greedy choice is optimal: taking the earliest completion leaves the most room for future subarrays.

**Algorithm:**
1. Maintain a prefix sum set initialized to {0}.
2. For each element, add to prefix sum.
3. If `prefix - target` is in the seen set, we found a subarray: increment count, reset set to {0} and prefix to 0.
4. Otherwise add prefix to seen.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — prefix sum set |

# 898. Bitwise ORs of Subarrays — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/bitwise-ors-of-subarrays/

---

## Solution: DP with Set — O(n log(max)) time, O(n log(max)) space

**Idea:** For each position i, track the set of distinct ORs of subarrays ending at i. When we move to i+1, the new set is `{x | arr[i+1] for x in prev} ∪ {arr[i+1]}`. Because ORs can only increase and there are at most 30 bits, the set size is bounded by 30.

**Complexity:**

| | |
|---|---|
| Time | O(n · 30) = O(n log max) |
| Space | O(n · 30) |

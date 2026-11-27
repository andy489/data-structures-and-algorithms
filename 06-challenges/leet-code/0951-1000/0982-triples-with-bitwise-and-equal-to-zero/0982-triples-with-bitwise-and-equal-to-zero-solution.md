# 982. Triples with Bitwise AND Equal To Zero — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/

---

## Solution: Two-Pass with Pair Counts — O(n² + n·2^16) time, O(2^16) space

**Idea:** Count all pairwise AND values into a frequency map, then for each pair-AND and each k, check if triple AND = 0.

**Algorithm:**
1. Build `pairCount[v]` = number of pairs (i,j) where `nums[i] & nums[j] == v`.
2. For each k, iterate over all pair values v: if `v & nums[k] == 0`, add `pairCount[v]`.

**Complexity:**

| | |
|---|---|
| Time | O(n² + n·2^16) |
| Space | O(2^16) |

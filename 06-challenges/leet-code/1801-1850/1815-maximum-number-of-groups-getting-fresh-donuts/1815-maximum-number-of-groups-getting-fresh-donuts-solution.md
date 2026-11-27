# 1815. Maximum Number of Groups Getting Fresh Donuts — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/

---

## Solution: Greedy + Bitmask DP — O(2^b * b) time, O(2^b) space

**Idea:** Only the remainder `group[i] % batchSize` matters. Groups with remainder 0 are always happy (put them first). Pairs of groups whose remainders sum to `batchSize` can both be served at a fresh batch if placed consecutively. After greedy pairing of complements, use memoized recursion over the remaining remainder counts, tracking the current leftover in the batch.

**Algorithm:**
1. Compute remainders; count groups with remainder 0 as immediately happy.
2. Greedily pair remainders `i` and `batchSize - i` for `i` from 1 to `batchSize/2`; each pair is one additional happy group.
3. Run DP over leftover remainder frequencies, encoded as a compact key; for each state, try scheduling each remaining group and recurse.
4. Add the DP result to the greedy count.

**Complexity:**

| | |
|---|---|
| Time | O(2^b * b) — at most `batchSize^batchSize` states, each with `batchSize` transitions |
| Space | O(2^b) — memoization map |

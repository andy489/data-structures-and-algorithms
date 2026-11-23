# 517. Super Washing Machines — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/super-washing-machines/

---

## Solution: Greedy with prefix sums — O(n) time, O(1) space

**Idea:** Total dresses must be divisible by n. For each position i, track the net "flow" across the cut between i and i+1 (prefix sum of `machines[j] - avg` for j=0..i). The minimum moves equals the maximum over all positions of `max(|flow[i]|, machines[i] - avg)` — a machine with excess must push out one dress per step, while net flow across a cut requires that many steps.

**Algorithm:**
1. If sum % n != 0, return -1.
2. For each i, compute `balance = machines[i] - avg`. Track running prefix sum and update answer with `max(|prefixSum|, balance)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |

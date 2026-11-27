# 1505. Minimum Possible Integer After At Most K Adjacent Swaps On Digits — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/

---

## Solution: Greedy + BIT (Binary Indexed Tree) — O(n * 10 * log n) time, O(n) space

**Idea:** Greedily, at each position we want to place the smallest digit reachable within `k` swaps. For position `i`, if the smallest digit `d` is at original index `j`, it costs `j - i - (number of elements before j already removed)` swaps to bring it to position `i`. We use a BIT (Fenwick tree) to efficiently count how many elements before index `j` have already been placed, so the actual distance is `j - i - bit.query(j)`. We track all positions of each digit 0-9 as queues.

**Algorithm:**
1. Build queues: `pos[d]` = list of original indices where digit `d` appears.
2. Build a BIT of size `n` initialized to 0.
3. For each output position `i` from 0 to n-1:
   - For each digit `d` from 0 to 9, check if `pos[d]` is non-empty. The front index is `j`. Actual cost = `j - bit.query(j)` (the prefix sum gives elements already placed before `j`, which shift `j` left).
   - Pick the smallest `d` where cost <= remaining `k`.
   - Subtract cost from `k`, mark that original index as used (BIT point-update), dequeue it.
4. Return the resulting string.

**Complexity:**

| | |
|---|---|
| Time | O(n * 10 * log n) — for each of n positions, check 10 digits, each BIT query is O(log n) |
| Space | O(n) — BIT and queues |

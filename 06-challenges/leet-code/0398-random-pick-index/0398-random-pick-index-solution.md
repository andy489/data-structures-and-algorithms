# 398. Random Pick Index — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/random-pick-index/

---

## Solution: Reservoir Sampling — O(n) pick time, O(1) extra space

**Idea:** For each call to `pick(target)`, scan the array and use reservoir sampling: when we see the i-th occurrence of target, replace our answer with index i with probability 1/i. This guarantees uniform distribution without prebuilding data structures.

**Complexity:**

| | |
|---|---|
| Time | O(n) per pick call |
| Space | O(1) extra (beyond storing input) |

---

## Alternative: Preprocess with HashMap — O(1) pick, O(n) space

Pre-map each value to list of indices, pick randomly from list. Trade space for time.

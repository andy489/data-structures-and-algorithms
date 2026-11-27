# 975. Odd Even Jump — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/odd-even-jump/

---

## Solution: Monotonic Stack + DP — O(n log n) time, O(n) space

**Idea:** Precompute next-greater-or-equal (for odd jumps) and next-smaller-or-equal (for even jumps) using a monotonic stack on sorted indices. Then DP from right.

**Algorithm:**
1. Sort indices by value (ascending for odd, descending for even) to find next jump targets.
2. Use monotonic stack to build `nextOdd[]` and `nextEven[]` arrays.
3. DP: `oddReach[i]` = can reach end starting with odd jump from i.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting |
| Space | O(n) |

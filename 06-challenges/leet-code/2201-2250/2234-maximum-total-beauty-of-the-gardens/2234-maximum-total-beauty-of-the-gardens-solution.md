# 2234. Maximum Total Beauty of the Gardens

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/maximum-total-beauty-of-the-gardens/

## Approach: Sort + Prefix Sums + Binary Search

**Key observations:**
- It's always optimal to complete the cheapest-to-complete gardens first.
- After sorting, we can use a two-pointer or binary search to try all splits: "complete the last `c` gardens, distribute remaining flowers among incomplete gardens."

**Algorithm:**
1. Sort flowers. Cap all values at target.
2. Build prefix sum array.
3. For each possible number of complete gardens `c` (0..n):
   - Remaining budget = newFlowers - cost to complete the last c gardens.
   - If budget < 0, break.
   - Among the remaining (n - c) incomplete gardens, use binary search to find the highest minimum we can achieve with the remaining flowers.
   - Track `max(c * full + minFlowers * partial)`.

**Complexity:**
- Time: O(n log n)
- Space: O(n)

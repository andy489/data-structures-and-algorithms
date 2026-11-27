# 1850. Minimum Adjacent Swaps to Reach the Kth Smallest Number — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/

---

## Solution: Next Permutation × k + Adjacent Swap Count — O(k·n + n^2) time, O(n) space

**Idea:** Two independent subproblems:
1. Find the kth next permutation by applying the next-permutation algorithm k times.
2. Count the minimum adjacent swaps to transform the original `num` into the target permutation.

For step 2, since both strings are permutations of the same digits, greedily match from left to right: for each position in `num`, find where the target's digit is in the remaining portion of `num` and count the swaps needed to bring it to the front.

**Algorithm:**
1. Apply next-permutation k times to get `target`.
2. Convert both to char arrays. For each index `i`:
   - Find `j >= i` such that `curr[j] == target[i]`.
   - Bubble `curr[j]` left to position `i` counting `j - i` swaps.
3. Return total swap count.

**Complexity:**

| | |
|---|---|
| Time | O(k·n + n^2) — k permutations O(n) each; swap counting O(n^2) |
| Space | O(n) — char arrays |

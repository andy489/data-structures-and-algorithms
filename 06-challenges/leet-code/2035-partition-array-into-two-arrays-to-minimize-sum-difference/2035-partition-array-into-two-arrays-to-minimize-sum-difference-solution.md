# 2035. Partition Array Into Two Arrays to Minimize Sum Difference — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/

---

## Solution: Meet in the Middle — O(2^n * n) time, O(2^n) space

**Idea:** Split array in half, enumerate all subset sums for each half, then binary search for best pairing.

**Algorithm:**
1. Split into left and right halves.
2. For each half, compute subset sums grouped by subset size.
3. For each left subset of size k, binary-search right subsets of size n-k.
4. Minimize |total - 2*chosen_sum|.

**Complexity:**

| | |
|---|---|
| Time | O(2^n * n) |
| Space | O(2^n) |

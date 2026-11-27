# 805. Split Array With Same Average — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/split-array-with-same-average/

---

## Solution: Meet in the Middle — O(2^(n/2)) time, O(2^(n/2)) space

**Idea:** For A to have same average as total, we need sum(A)/k = sum/n, i.e. sum(A) = k*sum/n for some k. Split array in half, enumerate all subset sums from each half, and check if any (k, s) pair from both halves combine to satisfy the condition.

**Algorithm:**
1. Prune: if no valid k (1 to n-1) satisfies k*total % n == 0, return false.
2. Split array into two halves. Enumerate all (count, sum) pairs for each.
3. For each valid subset from left half, check if a complement exists in right half sets.

**Complexity:**

| | |
|---|---|
| Time | O(2^(n/2)) — meet in the middle |
| Space | O(2^(n/2)) — storing subset sums |

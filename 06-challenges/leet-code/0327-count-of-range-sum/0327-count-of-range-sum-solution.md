# 327. Count of Range Sum — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-of-range-sum/

---

## Solution: Merge Sort on Prefix Sums — O(n log n) time, O(n) space

**Idea:** Build prefix sums array. `S(i,j) = prefix[j+1] - prefix[i]`. We need to count pairs `(i,j)` where `lower <= prefix[j+1] - prefix[i] <= upper`. Use merge sort on the prefix array: during merge, for each right element `prefix[j]`, count left elements `prefix[i]` where `prefix[j] - upper <= prefix[i] <= prefix[j] - lower` using two sliding pointers.

**Algorithm:**
1. Build prefix sums.
2. Merge sort: in the merge step, use two pointers `lo`, `hi` to count valid left elements for each right element.
3. Accumulate the count during sort.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) — merge buffer |

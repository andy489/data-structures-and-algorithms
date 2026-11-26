# 1508. Range Sum of Sorted Subarray Sums — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/

---

## Solution: Enumerate and Sort — O(n^2 log n) time, O(n^2) space

**Idea:** Since `n <= 1000`, we have at most ~500,000 subarray sums. Enumerate all, sort them, then sum elements from index `left-1` to `right-1`.

**Algorithm:**
1. Compute prefix sums.
2. Enumerate all `n*(n+1)/2` subarray sums and collect them in a list.
3. Sort the list.
4. Sum elements at indices `left-1` through `right-1` modulo `10^9 + 7`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2 log n) — O(n^2) sums, sorting dominates |
| Space | O(n^2) — store all subarray sums |

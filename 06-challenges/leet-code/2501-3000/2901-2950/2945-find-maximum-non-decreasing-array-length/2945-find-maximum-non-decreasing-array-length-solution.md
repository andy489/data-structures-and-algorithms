# 2945. Find Maximum Non-decreasing Array Length — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-maximum-non-decreasing-array-length/

---

## Solution: DP + Monotonic Deque + Prefix Sums — O(n) time, O(n) space

**Idea:** Define `dp[i]` = maximum length of a valid non-decreasing array using elements `nums[0..i-1]`. Each element of the result is a sum of a contiguous segment. The last segment ends at `i` and starts at some `j+1` where `prefix[i] - prefix[j] >= lastValue`. We need the longest previous sequence where the last segment's sum <= current segment's sum.

Use prefix sums and a monotonic deque to efficiently find, for each `i`, the leftmost valid start `j` such that `prefix[i] - prefix[j] >= dp_val[j]` (last value of sequence ending at j).

**Algorithm:**
1. Compute prefix sums.
2. `dp[i]` = max length ending at index `i`.
3. For each `i`, binary search or use deque to find the best `j` in O(1) amortized.
4. Maintain `minSumForLen`: for each possible length `l`, the minimum prefix sum at that length to allow extending.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

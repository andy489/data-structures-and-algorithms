# 689. Maximum Sum of 3 Non-Overlapping Subarrays — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/

---

## Solution: Sliding Window + Left/Right Best Index Arrays — O(n) time, O(n) space

**Idea:** Precompute `sums[i]` = sum of nums[i..i+k-1]. Then compute `left[i]` = index of max sum in sums[0..i] (leftmost on tie), `right[i]` = index of max sum in sums[i..n-k] (rightmost on tie). Scan middle window, combine left[mid-k], mid, right[mid+k].

**Algorithm:**
1. Compute sliding window sums.
2. Build `left` array (best index from left).
3. Build `right` array (best index from right).
4. For each valid mid, candidate = sums[left[mid-k]] + sums[mid] + sums[right[mid+k]].

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

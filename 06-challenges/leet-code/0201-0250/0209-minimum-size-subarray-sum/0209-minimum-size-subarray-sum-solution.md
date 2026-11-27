# 209. Minimum Size Subarray Sum — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/minimum-size-subarray-sum/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Maintain a window `[left, right]` whose sum is tracked. Expand right to grow the sum; whenever the sum meets `target`, record the window length and shrink from the left to try to find a smaller valid window.

**Algorithm:**
1. Initialise `left = 0`, `sum = 0`, `minLen = Integer.MAX_VALUE`.
2. For each `right` from 0 to n-1:
   - `sum += nums[right]`.
   - While `sum >= target`: update `minLen = min(minLen, right - left + 1)`; `sum -= nums[left++]`.
3. Return `minLen == Integer.MAX_VALUE ? 0 : minLen`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each element added and removed at most once |
| Space | O(1) |

---

## Solution 2: Binary Search on Prefix Sums — O(n log n) time, O(n) space

**Idea:** Build a prefix-sum array. For each start index `i`, binary-search for the smallest `j` such that `prefix[j] - prefix[i] >= target`.

**Algorithm:**
1. Build `prefix[0..n]` where `prefix[i] = nums[0] + ... + nums[i-1]`.
2. For each `i` from 0 to n-1: binary-search in `prefix[i+1..n]` for the smallest value `>= prefix[i] + target`. Update `minLen`.
3. Return `minLen`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — n binary searches over the prefix array |
| Space | O(n) — prefix sum array |

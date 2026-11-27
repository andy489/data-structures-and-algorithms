# 3859. Count Subarrays With K Distinct Integers — Solution

**Link:** https://leetcode.com/problems/count-subarrays-with-k-distinct-integers/

## Approach: Sliding Window — atMost(k, m) - atMost(k-1, m)

Use the standard "exactly k = atMost(k) - atMost(k-1)" technique, adapted to count subarrays with **at most k distinct** integers where **each** appears at least m times.

Define `atMost(K)` = number of subarrays with at most `K` distinct values, each appearing at least `m` times.

Then: `answer = atMost(k) - atMost(k-1)`.

For `atMost(K)`, use a sliding window with two pointers `l, r`:
- Expand right, adding `nums[r]` to the frequency map.
- Track how many distinct values have frequency >= m (call it `qualified`).
- When `qualified > K`, shrink from the left.
- At each `r`, the count of valid subarrays ending at `r` is `r - l + 1`.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

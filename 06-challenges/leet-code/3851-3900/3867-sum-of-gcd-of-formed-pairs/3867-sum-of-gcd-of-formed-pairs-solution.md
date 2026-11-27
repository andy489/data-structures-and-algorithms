# 3867. Sum of GCD of Formed Pairs — Solution

**Link:** https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/

## Approach: Simulation

1. Build `prefixGcd` array: iterate left to right, tracking the running maximum. `prefixGcd[i] = gcd(nums[i], runningMax)`.
2. Sort `prefixGcd`.
3. Use two pointers `l = 0, r = n-1` (or `r = n-2` if n is odd) to form pairs. Sum `gcd(prefixGcd[l], prefixGcd[r])` for each pair.

## Complexity

- **Time:** O(n log n) for sorting
- **Space:** O(n)

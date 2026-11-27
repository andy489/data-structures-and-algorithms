# 2554. Maximum Number of Integers to Choose From a Range I — Solution

## Approach: Greedy with HashSet

To maximize count, greedily pick the smallest available integers (not in `banned`) as they increase the sum least per count increment.

**Algorithm:**
1. Put all banned numbers into a HashSet for O(1) lookup.
2. Iterate from 1 to n; skip banned numbers.
3. If adding the current integer would exceed `maxSum`, stop.
4. Otherwise, add it to the running sum and increment count.

## Complexity

- **Time:** O(n + b) where `b` is the size of `banned`
- **Space:** O(b) — for the HashSet of banned numbers

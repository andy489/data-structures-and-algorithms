# 2226. Maximum Candies Allocated to K Children — Solution

**Approach:** Binary Search

Binary search on the answer (number of candies per child). For a given candidate `m`, check if the total number of piles of size `m` we can form (sum of `candies[i] / m` for all `i`) is at least `k`. The largest `m` for which this holds is the answer.

**Time Complexity:** O(n log(max_candy))

**Space Complexity:** O(1)

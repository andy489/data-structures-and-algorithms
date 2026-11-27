# Solution: 3892. Minimum Operations to Achieve At Least K Peaks

## Approach: Try All Starting Positions with Greedy

For a circular array of size n, the maximum number of peaks possible is `n / 2` (since no two adjacent elements can both be peaks). If `k > n / 2`, return -1.

### Key Insight

When we decide which positions will be peaks, the optimal arrangement is to place peaks every 2 positions. We can try all n possible "starting offsets" for the peak positions (peaks at indices `start, start+2, start+4, ...`).

### Algorithm

1. If `k == 0`, return 0.
2. If `k > n / 2`, return -1.
3. For each starting offset `s` from 0 to 1 (try peaks at even or odd positions), simulate placing k peaks greedily:
   - For each candidate peak position `i`, compute the cost to make `nums[i]` strictly greater than both circular neighbors.
   - Cost = `max(nums[(i-1+n)%n], nums[(i+1)%n]) + 1 - nums[i]` if positive, else 0.
4. Return the minimum cost across all offsets.

For this problem with n up to 5000, we can try all n starting positions with O(n) cost each, for O(n^2) total.

## Complexity

- **Time:** O(N^2) — feasible for N ≤ 5000
- **Space:** O(1)

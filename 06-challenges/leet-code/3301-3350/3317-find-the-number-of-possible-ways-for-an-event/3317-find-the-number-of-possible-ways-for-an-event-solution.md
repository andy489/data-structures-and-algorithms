# Solution: Find the Number of Possible Ways for an Event

## Approach: Stirling Numbers of the Second Kind + Combinatorics

The total count = sum over `k` (number of non-empty stages) from 1 to min(n, x) of:
`C(x, k) * S(n, k) * k! / k! * P(y, k)`

Wait, more precisely:
- Choose which `k` of the `x` stages are used: `C(x, k)`.
- Distribute `n` performers into exactly `k` non-empty groups: Stirling number `S(n, k)` (number of ways to partition n elements into k non-empty subsets).
- The k stages are distinguishable, so multiply by `k!` to assign groups to stages.
- Actually `C(x,k) * k!` = `P(x,k)` = x!/(x-k)! = falling factorial.
- Assign scores to k active stages: `P(y, k)` = y * (y-1) * ... * (y-k+1).

**Answer:** `sum_{k=1}^{min(n,x)} S(n,k) * C(x,k) * k! * P(y,k)`

Where `S(n,k)` = Stirling numbers of the second kind, computed via DP:
`S(n,k) = k * S(n-1,k) + S(n-1,k-1)`.

## Complexity

- **Time:** O(n * min(n,x)) for Stirling numbers computation.
- **Space:** O(n * x).

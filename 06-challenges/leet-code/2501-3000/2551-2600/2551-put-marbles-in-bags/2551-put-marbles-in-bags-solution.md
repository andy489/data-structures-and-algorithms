# 2551. Put Marbles in Bags — Solution

## Approach: Sort Adjacent Pair Sums

**Key Insight:** When dividing `n` marbles into `k` bags with contiguous constraint, we always get `weights[0] + weights[n-1]` in the total score (the first and last marbles always define boundaries). The `k-1` splits between bags each contribute `weights[i] + weights[i+1]` for split points between position `i` and `i+1`.

**Algorithm:**
1. Compute all adjacent pair sums: `pairSums[i] = weights[i] + weights[i+1]` for `i` in `[0, n-2]`.
2. Sort these pair sums.
3. The minimum score takes the `k-1` smallest pair sums; maximum takes `k-1` largest.
4. Return the sum of the top `k-1` minus the sum of the bottom `k-1`.

**Why this works:** Every distribution into `k` bags corresponds to choosing exactly `k-1` split points. The score equals `weights[0] + weights[n-1]` plus the sum of pair sums at the chosen split points. Since `weights[0] + weights[n-1]` cancels out, we just maximize/minimize the sum of chosen pair sums.

## Complexity

- **Time:** O(n log n) — sorting the pair sums array of size `n-1`
- **Space:** O(n) — for the pair sums array

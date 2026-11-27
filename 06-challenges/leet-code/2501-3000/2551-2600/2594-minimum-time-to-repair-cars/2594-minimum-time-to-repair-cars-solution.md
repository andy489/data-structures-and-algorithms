# Solution: 2594. Minimum Time to Repair Cars

## Approach

Use **binary search** on the answer (time `t`).

For a given time `t`, each mechanic with rank `r` can repair `floor(sqrt(t / r))` cars. So for a given time `t`, the total cars that can be repaired is `sum of floor(sqrt(t / ranks[i]))` for all mechanics.

Binary search for the minimum `t` such that total cars >= `cars`.

- **Lower bound:** 1
- **Upper bound:** `min(ranks) * cars * cars` (worst case: only the best mechanic does all work)

## Complexity

- **Time:** O(n log(min_rank * cars^2)) where n is number of mechanics
- **Space:** O(1)

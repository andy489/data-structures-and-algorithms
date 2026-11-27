# 2961. Double Modular Exponentiation — Solution

## Approach: Direct Simulation with Fast Exponentiation

For each index i with values [a, b, c, m]:
1. Compute `inner = a^b % 10` using fast exponentiation (or directly since b <= 1000).
2. Compute `result = inner^c % m` using fast exponentiation.
3. If `result == target`, add i to the answer list.

Since values are small (at most 10^3), even naive exponentiation is acceptable, but we use modular exponentiation for correctness.

## Complexity

| | Time | Space |
|---|---|---|
| O(variables.length * log(max_exp)) | O(n log b) | O(1) extra |

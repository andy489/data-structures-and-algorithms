# Solution: 2579. Count Total Number of Colored Cells

## Approach: Mathematical Formula

After `n` minutes, the colored region forms a diamond (rhombus) shape.

**Pattern:**
- After minute 1: 1 cell
- After minute 2: 5 cells (1 + 4)
- After minute 3: 13 cells (5 + 8)
- After minute 4: 25 cells (13 + 12)
- After minute `k`: adds `4*(k-1)` new cells from the previous step

Each new minute adds 4*(minute-1) cells (the border ring of the diamond).

**Closed Form:** 
- `f(n) = 1 + 4*(1 + 2 + ... + (n-1)) = 1 + 4 * n*(n-1)/2 = 1 + 2*n*(n-1)`
- `f(n) = 2*n*n - 2*n + 1`

**Verification:**
- `f(1) = 2 - 2 + 1 = 1` ✓
- `f(2) = 8 - 4 + 1 = 5` ✓
- `f(3) = 18 - 6 + 1 = 13` ✓

## Complexity

- **Time:** O(1)
- **Space:** O(1)

# 3378. Count Connected Components in LCM Graph — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-connected-components-in-lcm-graph/

---

## Solution: DSU with Multiples Sweep — O(T log T + n) time, O(T + n) space

**Idea:** Two numbers `a` and `b` are connected when `lcm(a, b) <= threshold`. Key observation: if `a` and `b` are both multiples of some `d`, then `lcm(a, b) = a*b/gcd(a,b)` which is `<= threshold` only if the numbers are small enough relative to `threshold`. Rather than checking all pairs (O(n²)), sweep over every value `d` from 1 to `threshold`. For each `d`, collect all multiples of `d` that are present in `nums` and `<= threshold`, then union them all together (they all share `d` as a common divisor and their pairwise LCM divides `lcm` through `d`).

Numbers greater than `threshold` can never form an LCM <= threshold with any other distinct number, so they remain isolated components.

**Algorithm:**
1. Build a set of `nums` values that are `<= threshold`. Count elements `> threshold` as isolated components.
2. Initialize DSU over the values `1..threshold`.
3. For each `d` from 1 to `threshold`, collect all multiples of `d` (i.e., `d, 2d, 3d, ...`) that exist in the set. Union them pairwise (or chain them under the first found multiple).
4. Count distinct roots among the values `<= threshold` that were in `nums`.
5. Add isolated count (nums values > threshold) to get total components.

**Complexity:**

| | |
|---|---|
| Time | O(T log T + n) — harmonic series sweep over multiples; T = threshold |
| Space | O(T + n) — DSU array of size T and the set of nums |

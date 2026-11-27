# 2954. Count the Number of Infection Sequences — Solution

## Approach: Combinatorics with Factorials and Modular Arithmetic

The infection spreads from each infected person simultaneously. We have "gaps" of uninfected people between consecutive infected (or boundary) positions.

**Key insight:**
- Let the total uninfected people count be `total = n - sick.length`.
- Each gap of uninfected people can only be infected from one or two ends depending on position.
- Gaps at the edges (before the first sick person or after the last sick person) are infected from one side only: they contribute 1 ordering per gap (sequential).
- Interior gaps (between two adjacent sick people) are infected from two ends: a gap of size `g` contributes `C(g, floor(g/2)) * 2^(g-1)` orderings if `g > 0`, else `1`. Actually for a gap of size `g` between two infected positions, the number of orderings is `C(g, any_split) * 2^(g - 1 if g > 0 else 0)`. More precisely: `2^(g-1)` for `g >= 1`, since at each of `g-1` steps (after the first) we choose left or right; total is `2^(g-1)` ordered interleaving ways divided by nothing — actually each interior gap of size g contributes `2^(g-1)` orderings.

**Detailed formula:**
- Compute gaps: for each interval of uninfected people, compute size.
- For edge gaps (only one side feeds), contribution to ordering = `1` (but their people still need slots in the multinomial).
- For interior gaps of size g > 0: contribution = `2^(g-1)`.
- Total arrangements = `total! / (g1! * g2! * ... * gk!)` * product of `2^(gi-1)` for interior gaps.

This equals multinomial(total; g1, g2, ..., gk) * 2^(sum of (gi-1) for interior gaps).

## Complexity

| | Time | Space |
|---|---|---|
| Precompute factorials + O(n) pass | O(n) | O(n) |

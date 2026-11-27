# 2561. Rearranging Fruits — Solution

## Approach: Frequency Counting + Greedy

**Key Insight:**
1. First, check feasibility: for each fruit value, its total count across both baskets must be even (so it can be split evenly).
2. The "extra" fruits that need to be swapped are those with odd excess in one basket. Build a list of fruits that basket1 has too many of, and fruits basket2 has too many of.
3. To minimize cost, sort both excess lists and pair them up. Each pair swaps the smaller fruit to the other basket. The cost of a swap is `min(fruit1, fruit2)`. Alternatively, any fruit can be "swapped through" the global minimum twice (bring minimum to basket2, then swap minimum with the target fruit), costing `2 * globalMin`. Take the cheaper of direct swap and indirect swap.

**Algorithm:**
1. Merge counts of both baskets. If any value has odd total count → return -1.
2. For each value, compute excess in basket1 vs basket2. Build `extra1` and `extra2` lists.
3. Sort both lists. Pair them up greedily. For each pair, cost = `min(min(a, b), 2 * globalMin)`.
4. Sum costs.

## Complexity

- **Time:** O(n log n) — sorting excess lists
- **Space:** O(n) — for frequency maps and excess lists

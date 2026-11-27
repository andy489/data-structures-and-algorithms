# 3947. Maximum Number of Items From Sale II

## Approach

For each item `i`, buying one copy gives you free copies of items `j` where `factor_i` divides `factor_j` and `i != j`. The number of free copies you can get per purchased copy of item `i` = number of items `j != i` such that `factor_i | factor_j`.

Precompute: `freeCount[i]` = number of items `j != i` with `factor_i | factor_j`. Since `factor_i <= items.length`, use divisor enumeration.

Then the total items obtained by buying `c_i` copies of item `i` and spending within budget is:
- Total purchased: sum of `c_i`
- Total free: sum of `min(c_i, 1) * freeCount[i]` = `freeCount[i]` if `c_i >= 1` (since you get at most once per pair)

Wait, re-reading: for each ordered pair `(i,j)`, at most one free copy of `j` from buying item `i`. So buying any positive number of copies of item `i` gives at most `freeCount[i]` free items total.

So total = purchased_copies + sum of `freeCount[i]` for each item `i` where at least one copy is bought.

This is a knapsack-like problem: choose which items to buy (and how many copies), maximize total items (bought + free) subject to budget.

Since we want to maximize, greedily buy cheapest items. Sort items by price, buy as many copies of the cheapest item as possible, plus one copy of each other cheapest item to unlock free copies.

Actually: for each distinct item, buying 1 copy gives `freeCount[i]` free. Buying more copies just increases purchased count. So to maximize, greedily allocate budget: consider binary search on total purchased items, or greedy selection.

## Complexity

- **Time:** O(n log n + n * sqrt(n)) — sorting + divisor counting
- **Space:** O(n) — for free count arrays

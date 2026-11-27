// https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/
class Solution {
    public long maxItems(int[][] items, int budget) {
        int n = items.length;
        // For each item i, count how many items j != i have factor_j divisible by factor_i
        // freePerPurchase[i] = number of items j where factor_i | factor_j and j != i
        int[] freeCount = new int[n];
        // Group items by factor
        Map<Integer, List<Integer>> byFactor = new HashMap<>();
        for (int i = 0; i < n; i++) {
            byFactor.computeIfAbsent(items[i][0], x -> new ArrayList<>()).add(i);
        }
        // For item i with factor fi, count j where fi | fj
        // Enumerate multiples of fi
        for (int i = 0; i < n; i++) {
            int fi = items[i][0];
            for (int mult = fi; mult <= n; mult += fi) {
                List<Integer> lst = byFactor.get(mult);
                if (lst != null) {
                    freeCount[i] += lst.size();
                }
            }
            // Subtract self (j != i, but same factor counts itself if factor_i | factor_i)
            freeCount[i]--; // remove self
        }
        // Now: buying any positive number of copies of item i:
        // - each copy costs items[i][1]
        // - buying first copy unlocks freeCount[i] free items
        // - buying more copies just adds to purchased count
        // Maximize: total = (sum of copies bought) + (sum of freeCount[i] for items bought >= 1)
        //
        // Strategy: greedy
        // Sort items by price.
        // For each item, benefit of buying 1st copy = 1 + freeCount[i], cost = price[i]
        // For each additional copy = 1, cost = price[i]
        // We want to maximize total items.
        //
        // Create a list of "purchase options":
        // - For each item i: "first copy" option: cost=price[i], gain=1+freeCount[i]
        // - For each item i: "extra copies" option (unlimited): cost=price[i], gain=1 each
        //
        // This is a fractional knapsack variant.
        // Sort all options by gain/cost ratio descending? But gain per cost:
        // first copy: (1+freeCount[i]) / price[i]
        // extra copy: 1 / price[i]
        //
        // Greedy:
        // 1. For each item, the "extra copies" have ratio 1/price, same as buying 1/price units.
        // 2. First decide which items to buy 1+ copies of (to unlock free items).
        //    Sort first-copy options by value/cost descending.
        //    Use all budget on "extra copies" of cheapest item at the end.
        //
        // Enumerate over which subset of items get at least 1 copy (exponential, not feasible for n=1e5).
        //
        // Key insight: buying 1 copy of item i costs price[i] and gains 1+freeCount[i].
        // Extra copies cost price[i] each for 1 gain.
        // The cheapest item (min price) gives best ratio for extra copies.
        // For first copies, rank by (1+freeCount[i]) / price[i].
        //
        // Greedy: sort items by effective value of first copy descending.
        // Buy first copies greedily until budget runs out, then fill remainder with extra copies of cheapest item.

        long minPrice = Long.MAX_VALUE;
        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        // Sort by value/cost of first copy descending: (1+freeCount[i]) / price[i]
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> {
            // Compare (1+freeCount[a])/price[a] vs (1+freeCount[b])/price[b]
            // Cross multiply: (1+fA)*pB vs (1+fB)*pA
            long lhs = (long)(1 + freeCount[a]) * items[b][1];
            long rhs = (long)(1 + freeCount[b]) * items[a][1];
            return Long.compare(rhs, lhs); // descending
        });

        long totalItems = 0;
        long remaining = budget;

        for (int i : idx) {
            if (remaining <= 0) {
                break;
            }
            long price = items[i][1];
            if (price <= remaining) {
                remaining -= price;
                totalItems += 1 + freeCount[i];
            }
        }
        // Use remaining budget on cheapest item (extra copies)
        totalItems += remaining / minPrice;

        return totalItems;
    }
}
